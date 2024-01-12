package com.promart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.promart.model.Product;
import com.promart.repo.ProductRepo;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	ProductRepo repo;
	
	public List<Product> getProduct(){
		List<Product> plist= repo.findAll();
		return plist;
		
	}
	
	public void add(Product p) {
		repo.save(p);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public Product getOneProduct(String id) {
		Product p= repo.findById(id).get();
		return p;
		
	}
	
	public void edit(Product p) {
		repo.save(p);
	}

}
