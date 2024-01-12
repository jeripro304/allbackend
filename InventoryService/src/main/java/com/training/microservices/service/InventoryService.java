package com.training.microservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.microservices.dto.RequestInventory;
import com.training.microservices.model.Inventory;
import com.training.microservices.repository.InventoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepo inventoryRepo;
	
	public List<RequestInventory> isInStock (List<String> productname){
		List<Inventory> ilist= inventoryRepo.findByproductNameIn(productname);
		List<RequestInventory> rlist=ilist.stream().map(product->mapToRequestInventory(product)).toList();
		
		return rlist;
		
		
	}

	private RequestInventory mapToRequestInventory(Inventory product) {
		RequestInventory ri=RequestInventory.builder()
				.productName(product.getProductName())
				.productQuantity(product.getProductQuantity()>0)
				.build();
		
		
		return ri;
	}
}
