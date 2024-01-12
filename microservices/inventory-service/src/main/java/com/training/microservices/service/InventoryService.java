package com.training.microservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.microservices.dto.RequestInventory;
import com.training.microservices.dto.ResponseInventory;
import com.training.microservices.model.Inventory;
import com.training.microservices.repository.InventoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepo inventoryRepo;
	
	public List<RequestInventory> isInStock (List<String> productname){
		try {
			System.out.println("thread started sleeping");
			Thread.sleep(10000);
			System.out.println("thread is Available");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void addProducts(ResponseInventory ri) {
		Inventory i= Inventory.builder().productName(ri.getProductName())
				.productQuantity(ri.getProductQuantity()).build();
		
		inventoryRepo.save(i);
		
	}
}
