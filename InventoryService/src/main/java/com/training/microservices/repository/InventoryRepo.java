package com.training.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservices.model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
	
	List<Inventory> findByproductNameIn(List<String> pname);
	

}
