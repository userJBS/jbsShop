package com.userj.session;

import javax.servlet.http.HttpSession;

import com.userj.domain.Account;
import com.userj.enums.Authority;

// 홈페이지 전체 세션 관리 클래스
public class HttpSessionUtils {

	// 사용자 세션
	public static final String ACCOUNT_SESSION_KEY = "sessionedAccount";

	// 관리자 세션
	public static final String MANAGER_SESSION_KEY = "sessionedManager";

	// 세션값에 sessionedAccount 값이 있다면 Account 객체를 리턴 해준다.
	public static Account getUserFromSession(HttpSession session) {
		if (session.getAttribute(ACCOUNT_SESSION_KEY) == null) {
			return null; // 세션 값이 없으면 null 리턴
		}
		return (Account) session.getAttribute(ACCOUNT_SESSION_KEY);
	}

	public static void save(HttpSession session, Account account) {
		// 로그인된 계정에 세션값 할당
		session.setAttribute(HttpSessionUtils.ACCOUNT_SESSION_KEY, account);

		// 권한 설정 MANAGER(관리) 세션값 할당
		if (account.getAuthority().equals(Authority.MANAGER)) {
			session.setAttribute(HttpSessionUtils.MANAGER_SESSION_KEY, "OK");
		}
	}

}
