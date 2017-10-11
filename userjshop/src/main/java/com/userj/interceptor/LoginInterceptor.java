package com.userj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.userj.domain.Account;
import com.userj.enums.Authority;
import com.userj.session.HttpSessionUtils;

// URL  /users/** 로그인 사용자만 접근 허용
public class LoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();

		// 세션에 저장된 계정
		Account account = (Account) session.getAttribute(HttpSessionUtils.ACCOUNT_SESSION_KEY);
		if (account == null) {
			response.sendRedirect("/login");
			return false;
		}

		// 권한(매니저) 체크 ( 권한 없이 매니저 페이지에 접근할경우 강제로 홈으로 이동시킴)
		if (findByAuthority(request).equals("manager") && !(account.getAuthority() == Authority.MANAGER)) {
			session.invalidate(); // 모든 세션 삭제
			response.sendRedirect("/");
			return false;
		}

		return true;
	}

	// URL에서 권한을 추출한다.
	private String findByAuthority(HttpServletRequest request) {
		// ex) URL : .../user/권한
		StringBuffer url = request.getRequestURL();
		// 요청한 URL 권한 자원 추출
		String urlAuthority = url.substring(url.indexOf("account") + 7);
		// 추출한 권한에 "/"가표시되 있을경우 공백으로 변환
		return urlAuthority.replace("/", "");
	}

}
