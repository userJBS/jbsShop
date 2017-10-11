package com.userj.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userj.domain.Account;
import com.userj.domain.Order;
import com.userj.message.Result;
import com.userj.repository.AccountRepository;
import com.userj.repository.OrderRepository;
import com.userj.session.HttpSessionUtils;

// (관리 페이지) 회원 관리 클래스
@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OrderRepository orderRepository;

	// #계정 삭제 FORM
	@GetMapping("/{{id}}")
	public String delete() {
		return "/account/delete";
	}

	// #계정 정보 수정 FORM
	@GetMapping
	public String update(Model model, HttpSession session) {
		// 현제 로그인 중인 계정 ID (세션 값)
		String id = HttpSessionUtils.getUserFromSession(session).getId();
		model.addAttribute("account", accountRepository.findById(id));
		return "/account/update";
	}

	// #계정 정보 수정
	@PostMapping
	public String update(Account newAccount, Model model) {
		Account account = accountRepository.findById(newAccount.getId());

		account.update(newAccount);
		// 수정된 객체(계정) 업데이트
		accountRepository.save(account);

		model.addAttribute("account", account);
		model.addAttribute(Result.MESSAGE_KEY, new Result("수정 완료"));
		return "/account/update";
	}

	// #계정 생성 FORM
	@GetMapping("/create")
	public String createForm() {
		return "/account/create";
	}

	// 주문/배송 리스트
	@GetMapping("/order")
	public String productList(Model model, HttpSession session) {
		// 현제 로그인 중인 계정 ID (세션 값)
		Account account = HttpSessionUtils.getUserFromSession(session);
		List<Order> order = orderRepository.findByAccount(account);

		model.addAttribute("order", order);
		return "/account/order/list";
	}
}