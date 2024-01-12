package com.training.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservices.dto.OrderRequest;
import com.training.microservices.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService oser;
	
	
	@PostMapping
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		System.out.println(orderRequest);
		oser.placeOrder(orderRequest);
		
		return "Order Created";
	}
	

	
}
