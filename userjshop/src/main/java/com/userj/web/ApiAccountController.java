package com.userj.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userj.domain.Account;
import com.userj.message.Result;
import com.userj.repository.AccountRepository;
import com.userj.session.HttpSessionUtils;

// (관리 페이지) 회원 관리 클래스
@RestController
@RequestMapping("/account")
public class ApiAccountController {

	@Autowired
	private AccountRepository accountRepository;

	// 계정삭제
	@DeleteMapping
	public Result delete(@RequestBody(required = false) String checkPassword, HttpSession session) {
		Account sessionAccount = HttpSessionUtils.getUserFromSession(session);
		Account account = accountRepository.findById(sessionAccount.getId());

		// sns 회원일 경우..
		if (account.getPassword() == null) {
			return new Result(false, "sns 계정은  해당 사이트에서 탈퇴가 가능합니다.");
		}

		if (checkPassword == null) {
			return new Result(false, "비밀번호를 입력해주세요.");
		}

		if (account.getPassword().equals(checkPassword)) {
			// 비밀번호 체크후 아이디 삭제
			accountRepository.delete(account.getId());
			session.invalidate(); // 모든 세션 삭제
			return new Result(true, "계정을 삭제합니다.");
		}

		return new Result(false, "비밀번호가 틀렸습니다.");
	}

	// 계정 생성 처리
	@PostMapping("/create")
	public Result create(Account newAccount, String passwordCheck, HttpSession session) {
		Account account = accountRepository.findById(newAccount.getId());

		// 아이디 or 비밀번호 짧을 경우
		if (newAccount.getId().length() < 2 || newAccount.getPassword().length() < 2) {
			return new Result(false, "아이디 & 비밀번호를 입력해주세요.");
		}

		// 아이디가 이미 존재할 경우
		if (account != null) {
			return new Result(false, "이미 존재 하는 아이디 입니다.");
		}

		// 비밀번호 확인
		if (!newAccount.getPassword().equals(passwordCheck)) {
			return new Result(false, "비밀번호를 확인해 주세요.");
		}

		// 새로운 계정 생성
		Account createAccount = new Account();
		createAccount.create(newAccount);

		accountRepository.save(createAccount);

		// 세션에 account 저장
		session.setAttribute(HttpSessionUtils.ACCOUNT_SESSION_KEY, newAccount);

		// 회원가입 완료후 메인으로 이동
		return new Result(true, "회원가입 완료...");
	}
}