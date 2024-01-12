package com.training.microservices.dto;

import com.training.microservices.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
	
	private String productName;
	private Double prodcutPrice;
	private Integer productQuantity;

}
