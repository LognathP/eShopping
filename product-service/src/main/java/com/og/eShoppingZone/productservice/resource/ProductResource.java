package com.og.eShoppingZone.productservice.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.og.eShoppingZone.productservice.entity.Product;
import com.og.eShoppingZone.productservice.logger.CommonLogger;
import com.og.eShoppingZone.productservice.service.ProductService;


@RestController
@RequestMapping(value = "api/v1/products")
public class ProductResource {
	
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	CommonLogger logger;

	@Autowired
	ProductService productService;
	
	@PostMapping("/addproduct")
	public boolean addProduct(@RequestBody Product product)
	{
		logger.info(this.getClass(),"ADD PRODUCT API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+product.toString());
		return productService.addProduct(product);	
	}
	
	@GetMapping("/getallproduct")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		logger.info(this.getClass(),"GET ALL PRODUCTs API CALL STARTED AT "+dateFormat.format(new Date()));
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/getproductbyid")
	public ResponseEntity<Optional<Product>> getProductById(@RequestParam int productId)
	{
		logger.info(this.getClass(),"GET PRODUCT BY ID API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY ID "+productId);
		return new ResponseEntity<Optional<Product>>(productService.getProductById(productId),HttpStatus.OK);
	}
	
	@GetMapping("/getproductbyname")
	public ResponseEntity<Optional<Product>> getProductByName(@RequestParam String productName)
	{
		logger.info(this.getClass(),"GET PRODUCT BY NAME API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY NAME "+productName);
		return new ResponseEntity<Optional<Product>>(productService.getProductByName(productName),HttpStatus.OK);
	}
	
	@GetMapping("/getproductbycategory")
	public ResponseEntity<List<Product>> getProductByCategory(@RequestParam String categoryName)
	{
		logger.info(this.getClass(),"GET PRODUCT BY CATEGORY API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY CATEGORY "+categoryName);
		return new ResponseEntity<List<Product>>(productService.getProductByCategory(categoryName),HttpStatus.OK);
	}

	@GetMapping("/getproductbytype")
	public ResponseEntity<List<Product>> getProductByType(@RequestParam String productType)
	{
		logger.info(this.getClass(),"GET PRODUCT BY TYPE API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY TYPE "+productType);
		return new ResponseEntity<List<Product>>(productService.getProductByType(productType),HttpStatus.OK);
	}

	@PutMapping("/updateproduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		logger.info(this.getClass(),"UPDATE PRODUCT API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+product.toString());
		return new ResponseEntity<Product>(productService.updateProduct(product),HttpStatus.OK);
	}

	@DeleteMapping("/deleteproduct")
	public boolean deleteProduct(@RequestParam int productId)
	{
		logger.info(this.getClass(),"DELETE PRODUCT API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY ID "+productId);
		return productService.deleteProduct(productId);	
	}
}