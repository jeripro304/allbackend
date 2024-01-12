package com.training.microservices.dto;

//import com.training.microservices.model.Inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestInventory {
	
	private String productName;
	private boolean productQuantity;

}
