package com.training.microservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.microservices.Repository.ProductRepository;
import com.training.microservices.dto.ProductRequest;
import com.training.microservices.dto.ProductResponse;
import com.training.microservices.entity.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productrepo;
	
	public void createNewProduct(ProductRequest productRequest) {
		
//		these are use by creating a object using new keyword
//		Product p=new Product();
//		p.setProductName(productRequest.getProductName());
//		p.setProdcutPrice(productRequest.getProdcutPrice());
//		p.setProductQuantity(productRequest.getProductQuantity());
		
//	    this is done by creating a object using builder
		Product p=Product.builder().productName(productRequest.getProductName())
				.prodcutPrice(productRequest.getProdcutPrice())
				.productQuantity(productRequest.getProductQuantity())
				.build();
		
		productrepo.save(p);

	}

	public List<ProductResponse> getAllProducts() {
		List<Product> prolist=productrepo.findAll();
		List<ProductResponse> responseProduct=new ArrayList<>();
		
		for (Product p:prolist) {
			responseProduct.add(mapToProductResponse(p));
		}
//		The below is done using stream api
//		List<ProductResponse> plist=prolist.stream().map(pro->mapToProductResponse(pro)).toList();
		
		return responseProduct;
	}
	
	public ProductResponse mapToProductResponse(Product p) {
		ProductResponse pr=new ProductResponse();
		pr.setProductId(p.getProductId());
		pr.setProductName(p.getProductName());
		pr.setProdcutPrice(p.getProdcutPrice());
		pr.setProductQuantity(p.getProductQuantity());
		
		return pr;
	}
	

}
