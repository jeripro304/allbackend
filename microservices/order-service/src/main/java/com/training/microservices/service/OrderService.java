package com.training.microservices.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.training.microservices.dto.OrderLineItemsDto;
import com.training.microservices.dto.OrderRequest;
import com.training.microservices.dto.ProductResponse;
import com.training.microservices.dto.RequestInventory;
import com.training.microservices.model.Order;
import com.training.microservices.model.OrderLineItems;
import com.training.microservices.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	private final WebClient.Builder webClientBuilder;
	//public List<OrderLineItems> addOrders;
	
	public String placeOrder(OrderRequest or) {
		String msg;
		System.out.println(or);
		Order o=new Order();
		o.setOrderNumber(UUID.randomUUID().toString());
		o.setOrderLineItems(or.getOrderLineItemsDtoList().stream().map(dto->mapToDto(dto)).toList());
		
		
		
		//getting the product names and storing it in list and send to inventory server
		List<String> productNames=o.getOrderLineItems().stream().map(orderItemsList->orderItemsList.getPName()).toList();
		
		//the inventory server will accept product names as string while we order the names will be send to inventory server
		// to check the availability of product
		//sending the data of product names using uriBuilder
		RequestInventory[] inventoryResponseArray= webClientBuilder.build().get().uri("http://INVENTORY-SERVICE/inventory",uriBuilder->uriBuilder.queryParam("productNames", productNames).build())
		.retrieve()
		.bodyToMono(RequestInventory[].class)
		.block();
		
		//if any one stock is not available order will be not placed
		boolean stockCheckStatus = Arrays.stream(inventoryResponseArray).allMatch(inventory->inventory.isProductQuantity() && inventoryResponseArray.length!=0) ;
		
		if(stockCheckStatus) {
			orderRepository.save(o);
		    msg="Order placed Succesfully";
		}
		else {
			msg="Some of the product are out of Stock !!";
//			throw new IllegalArgumentException("Some of the product are out of Stock !!");
		}
		return msg;
		}
	
	public ProductResponse[] getAllProducts() {
		ProductResponse[] prolist=( webClientBuilder.build().get()
				.uri("http://product-service/product").retrieve().bodyToMono(ProductResponse[].class)
				.block());
		return prolist;
	}
	
	public OrderLineItems mapToDto(OrderLineItemsDto dto) {
		return OrderLineItems.builder()
				.pId(dto.getPId())
				.pName(dto.getPName())
				.pPrice(dto.getPPrice())
				.pQty(dto.getPQty())
				.build();
	}
}