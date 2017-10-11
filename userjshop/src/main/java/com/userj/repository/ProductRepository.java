package com.userj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.userj.domain.Product;
import com.userj.enums.Category;

//public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// 상품 조회 ( select p from Product p where number =:number )
	Product findByNumber(Integer number);

	// select p from Product p where p...=?1 and p...=?2
	// List<Product> findBy필드변수이름1and필드변수이름2(String 필드변수이름1,String 필드변수이름2);

	// finAll(...) : 모든 엔티티를 조회한다. 정렬(Sort), 페이징(Pageable) 조건을 파라미터로 제공할 수 있다.

	// 스프링 데이터 JPA 쿼리 생성 기능
	// http://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference/html/jpa.repositories.html

	Page<Product> findByCategory(Category category, Pageable pageable);

	Page<Product> findByTitleContaining(String title, Pageable pageable);
	
	Page<Product> findByContentsContaining(String contents, Pageable pageable);
	

	// Product findAll
	// Containing
}