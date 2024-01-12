package com.training.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//this  is actually RequestInventory since we are uploading the data in db

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseInventory {


	private String productName;
	private Integer productQuantity;
}
