package com.userj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userj.domain.Product;
import com.userj.domain.utility.PageModel;
import com.userj.domain.utility.PageSearch;
import com.userj.enums.Category;
import com.userj.repository.ProductRepository;

// (카테 고리)  
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ProductRepository productRepository;

	// 게시물 수
	private final int pageSize = 8;

	// 카테고리 첫 및 페이징 처리
	@GetMapping("/{category}/{pageNumber}")
	public String page(Model model, @PathVariable Category category, @PathVariable Integer pageNumber) {
		// 페이징 처리(현제 페이지, 게시물 수, 정렬(내림,오름 차순), 정렬 기준)
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, Direction.DESC, "number");
		// 페이징 처리된 데이터 조회(카테고리 별로 조회)
		Page<Product> page = category == Category.all ? productRepository.findAll(pageable)
				: productRepository.findByCategory(category, pageable);

		// 뷰에 뿌려줄 데이터
		model.addAttribute("product", page.getContent());
		// 페이징 관리(현제페이지 번호, 총 데이터 갯수, 현제 카테고리)
		model.addAttribute("page", new PageModel(pageNumber, page.getTotalPages(), category));
		// 검색 관련 정보(검색어, 필터)
		model.addAttribute("search", new PageSearch("name", ""));

		return "/category/list";
	}

	// 검색 처리
	@GetMapping("/{pageNumber}/{firter}/{searchParam}")
	public String search(Model model, @PathVariable Integer pageNumber, @PathVariable String firter,
			@PathVariable String searchParam) {

		// 페이징 처리(현제 페이지, 게시물 수, 정렬(내림,오름 차순), 정렬 기준)
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, Direction.DESC, "number");
		// 페이징 처리된 데이터 조회 [제목으로 검색, 내용으로 검색]
		Page<Product> page = firter.equals("name") ? productRepository.findByTitleContaining(searchParam, pageable)
				: productRepository.findByContentsContaining(searchParam, pageable);

		// 뷰에 뿌려줄 데이터
		model.addAttribute("product", page.getContent());
		// 페이징 관리(현제페이지 번호, 총 데이터 갯수, 현제 카테고리)
		model.addAttribute("page", new PageModel(pageNumber, page.getTotalPages(), Category.all));
		// 검색 관련 정보(검색어, 필터)
		model.addAttribute("search", new PageSearch(firter, searchParam));

		return "/category/list";
	}

}