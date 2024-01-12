package com.training.microservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservices.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
