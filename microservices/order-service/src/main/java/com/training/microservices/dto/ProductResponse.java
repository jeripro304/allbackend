package com.training.microservices.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

	private Integer ProductId;
	private String productName;
	private Double prodcutPrice;
	private Integer productQuantity;
}
