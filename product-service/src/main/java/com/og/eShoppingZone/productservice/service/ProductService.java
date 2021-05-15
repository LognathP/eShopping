package com.og.eShoppingZone.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.og.eShoppingZone.productservice.entity.Product;



@Service
public interface ProductService {

	boolean addProduct(Product product);

	List<Product> getAllProducts();

	Optional<Product> getProductById(int productId);

	Optional<Product> getProductByName(String productName);

	List<Product> getProductByCategory(String categoryName);

	List<Product> getProductByType(String productType);

	Product updateProduct(Product product);

	boolean deleteProduct(int productId);
	
	
	

}
