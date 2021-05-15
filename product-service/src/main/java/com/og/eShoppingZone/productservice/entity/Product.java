package com.og.eShoppingZone.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	long productId;
	@NotNull
	@Column(name = "product_type")
	String productType;
	@NotNull
	@Column(name = "product_name")
	String productName;
	@NotNull
	String category;
	double price;
	String description;

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productType=" + productType + ", productName=" + productName
				+ ", category=" + category + ", price=" + price + ", description=" + description + "]";
	}
	
	
	
}
