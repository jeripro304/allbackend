package com.training.microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.training.microservices.model.Inventory;
import com.training.microservices.repository.InventoryRepo;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	//comment the bean tag once it runs on the first time else on 
	//each time it runs it inserts the value every time
//	@Bean
	public CommandLineRunner loadData(InventoryRepo inventoryRepository) {
		return arge->{
			Inventory phone=Inventory.builder().build();
			phone.setProductName("redmi not 8");
			phone.setProductQuantity(9);
			inventoryRepository.save(phone);
			
			Inventory laptop=Inventory.builder().build();
			laptop.setProductName("Dell latitude");
			laptop.setProductQuantity(8);
			inventoryRepository.save(laptop);
			
		};
	}
}
