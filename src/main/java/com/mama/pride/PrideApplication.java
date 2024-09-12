package com.mama.pride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
// import com.main.pride.services.CategoryServiceImplement;

@SpringBootApplication
public class PrideApplication {
	@Autowired
	Environment env;

	// @Autowired
	// private CategoryServiceImplement categoryService;

	public static void main(String[] args) {
		SpringApplication.run(PrideApplication.class, args);

	}
}
