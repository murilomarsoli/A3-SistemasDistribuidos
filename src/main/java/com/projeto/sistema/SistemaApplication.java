package com.projeto.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SistemaApplication {

	@GetMapping("/administrativo")
	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);
	}

}