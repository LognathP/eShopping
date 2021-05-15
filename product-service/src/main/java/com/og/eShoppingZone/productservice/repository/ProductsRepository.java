package com.og.eShoppingZone.productservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.og.eShoppingZone.productservice.entity.Product;


public interface ProductsRepository extends JpaRepository<Product,Long>{

	
	@Query("SELECT p FROM Product p where p.productName = :name")
	Optional<Product> findByProductName(@Param("name") String name);
	
	@Query("SELECT p FROM Product p where p.category = :cName")
	List<Product> findByCategory(@Param("cName") String categoty);
	
	@Query("SELECT p FROM Product p where p.productType = :pType")
	List<Product> findByProductType(@Param("pType") String productType);
}
