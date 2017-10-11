package com.userj.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 댓글 관리 클래스

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = { "account", "product" })
public class Comment extends AbstractEntity {

	// 댓글 번호
	@Id
	@GeneratedValue
	private Integer number;

	// 댓글 작성자
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_comments_account"))
	private Account account;

	// 댓글이 달린 상품
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_comments_to_product"))
	private Product product;

	// 평점 TODO 평점 기능 시간나면 추가..
	private Integer score;

	// 내용
	@Lob
	private String contents;

	// 댓글 작성
	public Comment(Account account, Product product, String contents) {
		this.account = account;
		this.product = product;
		this.contents = contents;
	}

}