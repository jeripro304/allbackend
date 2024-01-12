package com.training.microservices.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.training.microservices.dto.OrderLineItemsDto;
import com.training.microservices.dto.OrderRequest;
import com.training.microservices.model.Order;
import com.training.microservices.model.OrderLineItems;
import com.training.microservices.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	//public List<OrderLineItems> addOrders;
	
	public void placeOrder(OrderRequest or) {
		System.out.println(or);
		Order o=new Order();
		o.setOrderNumber(UUID.randomUUID().toString());
		o.setOrderLineItems(or.getOrderLineItemsDtoList().stream().map(dto->mapToDto(dto)).toList());
		orderRepository.save(o);
		
		
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
