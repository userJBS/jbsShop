package com.userj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userj.domain.Account;
import com.userj.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByAccount(Account id);

}
