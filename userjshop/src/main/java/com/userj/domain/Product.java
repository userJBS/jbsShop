package com.userj.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import com.userj.enums.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "comments")
@NoArgsConstructor
public class Product extends AbstractEntity {

	// 상품 번호
	@Id
	@GeneratedValue
	private Integer number;

	// 제목
	@NotBlank
	private String title;

	// 상품 가격
	private Integer price;

	@Enumerated(EnumType.STRING)
	private Category category;

	// 상품 내용
	@Lob
	private String contents;

	// 상품 이미지
	private String img;

	// 로컬 저장소 경로
	// private final String saveRoute = "";

	@OneToMany(mappedBy = "product") // mappedBy="필드 이름"
	// @OrderBy("number DESC") // ASC(순차), DESC(역순)
	private List<Comment> comments;

	// 내용 값 저장할때 썸네일 이미지도 함께 지정
	public void setContents(String contents) {
		this.contents = contents;
		this.img = findByImg(contents);
	}

	// 글에서 이미지 파일이 있을경우 썸네일 지정(상품 내용에 있는 첫번째 이미지를 썸내일로 지정한다.)
	private String findByImg(String imgFind) {
		int startImgFind = imgFind.indexOf("<img src=");
		if (startImgFind > 0) {
			imgFind = imgFind.substring(startImgFind + 10);
			int endImgFind = imgFind.indexOf("\"");
			imgFind = imgFind.substring(0, endImgFind);
		} else {
			// 상품 이미지가 없을 경우 썸내일 파일 주소
			imgFind = "/img/noImg.jpg";
		}
		return imgFind;
	}

	// 상품 수정
	public void update(Product newProduct) {
		this.title = newProduct.title;
		this.price = newProduct.price;
		this.category = newProduct.category;
		this.contents = newProduct.contents;
		this.img = findByImg(newProduct.contents);
	}

}
