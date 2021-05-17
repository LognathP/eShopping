package com.og.eShoppingZone.cartservice.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class Cart {

	int id;
	double totalPrice;
	private List<Item> item;
	
	
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", totalPrice=" + totalPrice + ", item=" + item + "]";
	}



		
}


