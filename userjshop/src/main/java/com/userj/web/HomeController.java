package com.userj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 홈페이지 메인 페이지
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index"; // src/main/resources/templates/index.html 파일 접근
	}

}
