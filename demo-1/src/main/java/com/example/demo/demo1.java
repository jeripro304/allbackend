package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class demo1 {
	@GetMapping
	public String demo1()
	{
		return "Hi everyone";
	}

}
