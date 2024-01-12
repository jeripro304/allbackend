package com.training.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservices.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
