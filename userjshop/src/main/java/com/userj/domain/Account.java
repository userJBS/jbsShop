package com.userj.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import com.userj.enums.Authority;
import com.userj.enums.Gender;
import com.userj.enums.LoginType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString(exclude = "password")
@NoArgsConstructor
public class Account extends AbstractEntity {

	@Id // PK 키설정
	@NotBlank
	private String id;
	private String password;
	private String name;
	private String email = "";
	private String address = "";

	// 권한 (기본값 : BUYER(구매자))
	@Enumerated(EnumType.STRING)
	private Authority authority = Authority.BUYER;

	// 성별 (기본값 : NOTVERIFIABLE(미설정))
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.NOTVERIFIABLE;

	// 회원가입 타입 (기본값 : USERJSHOP(홈페이지 가입))
	@Enumerated(EnumType.STRING)
	private LoginType loginType = LoginType.USERJSHOP;

	// 아이디&비밀번호 확인 (로그인)
	public boolean machAccount(Account newAccount) {
		if (newAccount == null) {
			return false;
		}
		return this.id.equals(newAccount.id) && this.password.equals(newAccount.password);
	}

	// 계정 수정
	public void update(Account newAccount) {
		this.email = newAccount.email;
		this.name = newAccount.name;
		this.gender = newAccount.gender;
		this.address = newAccount.address;
	}

	// sns 가입 할경우 아이디,이름 저장
	public Account(String id, String name, LoginType loginType) {
		this.id = id;
		this.name = name;
		this.loginType = loginType;
	}

	// 회원 가입
	public void create(Account newAccount) {
		this.password = newAccount.password;
		this.id = newAccount.id;
		this.name = newAccount.name;
	}

}
