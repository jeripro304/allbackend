package com.promart.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promart.model.Product;
import com.promart.service.Service;

@RestController
public class ProductController {
	
	@Autowired
	Service  ser;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/view")
	public List<Product> viewProduct() {
		List<Product> plist=ser.getProduct();
		return plist;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add")
	public String addProduct(@RequestBody Product p) {
		ser.add(p);
		return "Product Created";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/edit")
	public String editProduct(@RequestBody Product p) {
		System.out.println(p.getPid()+p.getPqty()+p.getPrice()+p.getPcategory()+p.getPdesc()+p.getPname());
		ser.edit(p);
		return "Product edited";
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable String id) {
		ser.delete(id);
		return "Product Deleted";
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/view/{id}")
	public List<Product> viewSingleProduct(@PathVariable String id) {
		Product p=ser.getOneProduct(id);
		List<Product> l = new ArrayList<Product>();
		l.add(p);
		System.out.println(id);
		return l;
	}
	
	
	

}
