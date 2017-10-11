package com.userj.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userj.domain.Account;
import com.userj.domain.Order;
import com.userj.domain.Product;
import com.userj.repository.AccountRepository;
import com.userj.repository.OrderRepository;
import com.userj.repository.ProductRepository;
import com.userj.session.HttpSessionUtils;

//  주문,배송 조회
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AccountRepository accountRepository;

	private Product product = null;
	private Account account = null;

	// 주문 페이지
	@GetMapping("/{productNumber}")
	public String order(Model model, @PathVariable Integer productNumber, HttpSession session) {

		product = productRepository.findOne(productNumber);

		// 현제 로그인 중인 계정 아이디
		account = HttpSessionUtils.getUserFromSession(session);

		if (account == null) {
			model.addAttribute("detailMessage", "주문  하려면 로그인이 필요합니다.");
		}

		model.addAttribute("product", product);
		model.addAttribute("account", account);

		return "/order/order";
	}

	// 주문
	@PostMapping("/{productNumber}")
	public String orderLogic(Model model, int amount) {
		Order order = new Order(null, account, product, amount);
		orderRepository.save(order);

		return "redirect:/account/order";
	}

	// 주문 취소
	@GetMapping("/{orderCode}/delete")
	public String orderDelete(Model model, @PathVariable Integer orderCode, HttpSession session) {
		// 현제 로그인 중인 계정 아이디
		Account account = HttpSessionUtils.getUserFromSession(session);

		// 주문 취소(자신의 주문만 취소 가능)
		if (account != null && accountRepository.findOne(account.getId()).getId().equals(account.getId())) {
			// 주문 취소
			orderRepository.delete(orderCode);
		}

		return "redirect:/account/order";
	}

}
