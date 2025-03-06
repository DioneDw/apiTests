package com.dwprojects.apiTests;

import com.dwprojects.apiTests.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTestsApplication.class, args);

		User user = new User(1,"Teste","teste@teste.com","12345");
	}

}
