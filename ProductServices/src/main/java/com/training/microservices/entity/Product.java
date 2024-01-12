package com.training.microservices.entity;

import com.training.microservices.dto.ProductRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer ProductId;
	private String productName;
	private Double prodcutPrice;
	private Integer productQuantity;

}
