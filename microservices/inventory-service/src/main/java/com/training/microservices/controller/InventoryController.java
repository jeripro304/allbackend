package com.training.microservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservices.dto.RequestInventory;
import com.training.microservices.dto.ResponseInventory;
import com.training.microservices.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {
	
	private final InventoryService inventoryService;
	
	@GetMapping
	public List<RequestInventory> isInStock(@RequestParam List<String> productNames){
		
		return inventoryService.isInStock(productNames);
		
	}
	
	@PostMapping
	public String addproduct(@RequestBody ResponseInventory inv) {
		
		inventoryService.addProducts(inv);
		
		return "Product added in inventory";
	}

}
