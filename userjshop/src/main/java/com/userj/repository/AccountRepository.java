package com.userj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userj.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	// 아이디 조회
	Account findById(String id);
	
	
}
