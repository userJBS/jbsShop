package com.userj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.userj.interceptor.LoginInterceptor;

@EntityScan(basePackageClasses = { UserjshopApplication.class, Jsr310JpaConverters.class })
@EnableJpaAuditing
@SpringBootApplication
public class UserjshopApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(UserjshopApplication.class, args);
	}

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		// 로그인 체크
		registry.addInterceptor(new LoginInterceptor())
				// URL /account/** 에 접근할경우 LoginInterceptor접근 가능 여부 체크
				.addPathPatterns("/account/**")
				// 아래 URL은 모두 접근 가능한 URL로 지정
				.excludePathPatterns("/account/create");

	}
}