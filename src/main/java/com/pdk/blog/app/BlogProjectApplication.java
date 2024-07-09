package com.pdk.blog.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogProjectApplication.class, args);
		System.out.println("-----------------------------------");
		System.out.println("|	  Blog Application        |");
		System.out.println("-----------------------------------");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
