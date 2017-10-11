package com.userj.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userj.domain.Account;
import com.userj.domain.Comment;
import com.userj.domain.Product;
import com.userj.repository.CommentRepository;
import com.userj.repository.ProductRepository;
import com.userj.session.HttpSessionUtils;

// 상품 관리 CURD, 댓글 관리
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CommentRepository commentRepository;

	// 상품 보기(댓글 포함)
	// 1. "/{number}" : 상품 보기
	// 2. "/{number}/comment" : 댓글 입력
	@GetMapping({ "/{productNumber}", "/{productNumber}/comment" })
	public String detail(@PathVariable Integer productNumber, String contents, Model model, HttpSession session) {
		Product product = productRepository.findByNumber(productNumber);

		// 상품 정보(댓글 정보 포함)
		model.addAttribute("product", product);

		// 현제 로그인 중인 계정 아이디
		Account account = HttpSessionUtils.getUserFromSession(session);

		// 조건 1. 로그인 상태여야 한다. 2. 상품이 존재 해야한다.
		if (account != null && contents != null && contents.length() > 0) {
			// (댓글 작성자, 상품 번호, 댓글 내용)
			Comment comment = new Comment(account, product, contents);
			commentRepository.save(comment);
			return "redirect:/product/" + productNumber;
		}

		return "/product/detail";
	}

	// 댓글 삭제
	@PostMapping("/{productNumber}/{commentNumber}/comment")
	public String commentDelete(@PathVariable Integer productNumber, @PathVariable Integer commentNumber, Model model,
			HttpSession session) {
		// 현제 로그인 중인 계정 아이디
		Account loginAccount = HttpSessionUtils.getUserFromSession(session);

		// 댓글 작성자 ID
		String commentWriter = commentRepository.findOne(commentNumber).getAccount().getId();

		// 삭제 기능(자신이 쓴글만 삭제 가능)
		if (loginAccount != null && commentWriter.equals(loginAccount.getId())) {
			// 댓글 삭제
			commentRepository.delete(commentNumber);
		}

		Product product = productRepository.findByNumber(productNumber);
		// 상품 정보(댓글 정보 포함)
		model.addAttribute("product", product);

		return "redirect:/product/" + productNumber;
	}

	// 상품 등록 폼
	@GetMapping("/save")
	public String create() {
		return "/product/save";
	}

	// 상품 등록 처리
	@PostMapping("/save")
	public String create(Product product) {
		productRepository.save(product);
		return "redirect:/category/all/1";
	}

	// 상품 이미지 파일 처리 (TODO:사용 되지 안는 이미지 삭제 처리 기능 필요.. 일딴 그냥 이미지 올리는 기능만..)
	@PostMapping("/upload")
	public String create(Part part, HttpServletRequest request) throws IOException {
		// 실제 파일 이름
		String fileName = part.getSubmittedFileName();
		// 서버에 파일이 저장될 랜덤 이름
		String realFileNm = fileNameRandom(fileName);

		// 업로드 파일이 저장될 경로
		// 카페24
		String uploadFilepath = "/home/hosting_users/jbs1995/tomcat/webapps/ROOT/upload";
		// 윈도우
		// String uploadFilepath =
		// "C:/DevelopmentTools/apache-tomcat-8.0.29/webapps/ROOT/upload";
		// 리눅스 일 경우
		// String uploadFilepath =
		// "/home/userj/apache-tomcat-8.5.6/webapps/ROOT/upload";

		// 업로드 파일이 저장될 디렉토리 없을 경우 디렉토리 생성
		fileExce(uploadFilepath);

		// 업로드할 파일이 있을 경우 실행 ( File.separatorChar : \\ 기능 )
		if (fileName.length() > 0) {
			part.write(uploadFilepath + File.separatorChar + realFileNm);
		}

		return redirectUri(request, realFileNm, "/upload/" + realFileNm);
	}

	// # 상품 수정 Form
	@GetMapping("/update/{productNumber}")
	public String updateForm(@PathVariable Integer productNumber, Model model) {
		Product product = productRepository.findByNumber(productNumber);
		// 상품 정보
		model.addAttribute("product", product);
		return "/product/update";
	}

	// # 상품 수정
	@PostMapping("/update/{productNumber}")
	public String update(@PathVariable Integer productNumber, Product newProduct) {
		Product product = productRepository.findByNumber(productNumber);
		product.update(newProduct);
		productRepository.save(product);
		return "redirect:/product/" + productNumber;
	}

	// 상품 삭제
	@GetMapping("/delete/{productNumber}")
	public String delete(@PathVariable Integer productNumber) {
		Product product = productRepository.findByNumber(productNumber);

		// TODO 궁금증?? delete 메서드 null 체그 원래는 해야하지만 댓글이 없어도 "[]" 값이 들어 있어서 체크
		// 하지안아도 예외가 발생하지 않는다... 데이터 타입이 list라서그런건가??
		commentRepository.delete(product.getComments());
		productRepository.delete(product);

		return "redirect:/category/all/1";
	}

	// 아래 코드는 메서드 영역

	// 업로드 파일이 저장될 디렉토리 없을 경우 디렉토리 생성
	private void fileExce(String uploadFilepath) {
		File file = new File(uploadFilepath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	// callback.html 로 리다이렉트
	private String redirectUri(HttpServletRequest request, String realFileNm, String uploadFilepath) {
		String callback_uri = request.getParameter("callback");
		String callback_func = request.getParameter("callback_func");

		String redirectUri = String.format("redirect:%s?callback_func=%s&bNewLine=true&sFileName=%s&sFileURL=%s",
				callback_uri, callback_func, realFileNm, uploadFilepath);
		return redirectUri;
	}

	// 저장될 파일 이름 랜덤으로 생성
	private String fileNameRandom(String fileName) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String today = formatter.format(new java.util.Date());
		String randomFileName = today + UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
		return randomFileName;
	}
}