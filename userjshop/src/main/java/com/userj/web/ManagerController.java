package com.userj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userj.repository.AccountRepository;

//  (관리 페이지) 홈페이지 관리자 페이지 
@Controller
@RequestMapping("/account")
public class ManagerController {
	@Autowired
	private AccountRepository accountRepository;

	// 관리자만 볼수 있는 페이지 모든 회원 리스트 (관리)
	@GetMapping("/manager")
	public String list(Model model) {
		model.addAttribute("account", accountRepository.findAll());
		return "/account/manager/list";
	}

}
