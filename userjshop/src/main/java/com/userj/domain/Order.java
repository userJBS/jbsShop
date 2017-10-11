package com.userj.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@ToString(exclude = { "account", "product" })
@AllArgsConstructor
@NoArgsConstructor
public class Order extends AbstractEntity {

	// 주문 코드
	@Id
	@GeneratedValue
	private Integer code;

	// 주문자 ID
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_orders_account"))
	private Account account;

	// 상품 번호
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_orders_product"))
	private Product product;

	// 주문 수량
	private int amount;

	// 결제 방식
	// private Payment payment;

	// 실제로 결제된 금액
	// private int price
}
