package com.review.yj.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing
@SpringBootApplication
public class CommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

	// PutMapping, DeleteMapping을 사용하기 위해 Bean 주입
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() { 		return new HiddenHttpMethodFilter(); 	}
}
