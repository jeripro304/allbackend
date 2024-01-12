package com.promart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promart.model.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

}
