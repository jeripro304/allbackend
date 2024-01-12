package com.training.microservices.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservices.dto.OrderRequest;
import com.training.microservices.dto.ProductResponse;
import com.training.microservices.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService oser;
	
	
	@PostMapping("/addorder")
	@CircuitBreaker(name = "inventory",fallbackMethod="fallBackMethod")
	@TimeLimiter(name="inventory")
	@Retry(name = "inventory")
	public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
		System.out.println(orderRequest);
		String msg=oser.placeOrder(orderRequest);
		
		return CompletableFuture.supplyAsync(()->msg);
	}
	
	public CompletableFuture<String> fallbackMethod(OrderRequest orderreq,RuntimeException exception) {
		System.out.println("fallback mechanism");
		return  CompletableFuture.supplyAsync(()->"Call back method error in placing order");
		
	}
	
	@GetMapping("/products")
	public ProductResponse[] getproducts() {
		return oser.getAllProducts();
	}

	
}
