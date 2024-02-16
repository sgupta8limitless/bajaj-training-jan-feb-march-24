package com.thorabh.jwtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JwtdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtdemoApplication.class, args);
	}

}
