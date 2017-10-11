package com.userj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userj.repository.AccountRepository;
import com.userj.repository.OrderRepository;

//  관리자만 볼수 있는 페이지
@Controller
@RequestMapping("/account/manager")
public class ManagerController {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OrderRepository orderRepository;
	// 모든 회원 리스트 (관리)
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("account", accountRepository.findAll());
		return "/account/manager/list";
	}

	// 주문 리스트(회원들이 주문한 상품)
	@GetMapping("/order")
	public String productList(Model model) {
		model.addAttribute("order", orderRepository.findAll());
		 
		
		return "/account/manager/order";
	}

}
