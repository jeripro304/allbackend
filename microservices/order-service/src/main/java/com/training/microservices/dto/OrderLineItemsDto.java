package com.training.microservices.dto;

import com.training.microservices.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItemsDto {
	
	private Integer pId;
	private String pName;
	private Double pPrice;
	private Integer pQty;

}
