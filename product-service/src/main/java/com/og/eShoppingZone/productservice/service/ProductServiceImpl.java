package com.og.eShoppingZone.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.og.eShoppingZone.productservice.entity.Product;
import com.og.eShoppingZone.productservice.logger.CommonLogger;
import com.og.eShoppingZone.productservice.repository.ProductsRepository;


@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	CommonLogger logger;
	
	@Autowired
	ProductsRepository productRepository;
	
	@Override
	public boolean addProduct(Product product) {
		boolean status = false;
		try {
			productRepository.save(product);
			status = true;
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON addProduct "+e.getMessage());
		}	
		return status;
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			return productRepository.findAll();
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getAllProducts "+e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<Product> getProductById(int productId) {
		try {
			return productRepository.findById((long) productId);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getProductById "+e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<Product> getProductByName(String productName) {
		try {
			return productRepository.findByProductName(productName);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getProductByName "+e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Product> getProductByCategory(String categoryName) {
		try {
			return productRepository.findByCategory(categoryName);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getProductByCategory "+e.getMessage());
		}
		return null;
		
	}

	@Override
	public List<Product> getProductByType(String productType) {
		try {
			return productRepository.findByProductType(productType);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getProductByType "+e.getMessage());
		}
		return null;
		
		
	}

	@Override
	public Product updateProduct(Product product) {
		try {
			productRepository.save(product);
			return productRepository.findById(product.getProductId()).get();
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON updateProduct "+e.getMessage());
		}
		return null;
		
	}

	@Override
	public boolean deleteProduct(int productId) {
		boolean status = false;
		try {
			productRepository.deleteById((long) productId);
			status = true;
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON deleteProduct "+e.getMessage());
		}
		return status;
				
	}

	
	
		



	

}
