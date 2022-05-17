package com.nowon.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //이벤트 감시 기능 활성화
@SpringBootApplication
public class SpringTest04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringTest04Application.class, args);
	}

}

