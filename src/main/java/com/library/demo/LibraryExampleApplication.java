package com.library.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController


public class LibraryExampleApplication {


    public static void main(String[] args) {
		SpringApplication.run(LibraryExampleApplication.class, args);
	}


	@GetMapping("/")
	public String index(){


		return "Library management system using Springboot";
	}




}
