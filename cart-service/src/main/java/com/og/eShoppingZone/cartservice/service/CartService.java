package com.og.eShoppingZone.cartservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.og.eShoppingZone.cartservice.entity.Cart;



@Service
public interface CartService {

	Cart addCart(Cart cart);

	List<Cart> getAllcarts();

	Optional<Cart> getCartById(int cartId);

	Double getCartTotal(int cartId);

	Cart updateCart(Cart cart);
	
	
	

}
