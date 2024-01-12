package com.training.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.microservices.dto.ProductRequest;
import com.training.microservices.dto.ProductResponse;
import com.training.microservices.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService ps;
	
	@PostMapping()
	public String createProduct(@RequestBody ProductRequest productrequest){
		ps.createNewProduct(productrequest);
		return "Product added in product and inventory";
	}
	
	@GetMapping
	public List<ProductResponse> getProducts(){
		List<ProductResponse> plist= ps.getAllProducts();
		return plist;
	}
	
	

}
