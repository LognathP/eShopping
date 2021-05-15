package com.og.eShoppingZone.cartservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.og.eShoppingZone.cartservice.entity.Cart;
import com.og.eShoppingZone.cartservice.logger.CommonLogger;
import com.og.eShoppingZone.cartservice.repository.CartRepository;


@Component
public class CartServiceImpl implements CartService {

	@Autowired
	CommonLogger logger;
	
	@Autowired
	CartRepository cartRepository;
	
	
	
	@Override
	public Cart addCart(Cart cart) {
		try {
			cartRepository.save(cart);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON addCart "+e.getMessage());
		}
		return cart;
	}
	
	@Override
	public List<Cart> getAllcarts() {
		try {
			return cartRepository.findAll();
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getAllcarts "+e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<Cart> getCartById(int cartId) {
		try {
			return cartRepository.findById((long) cartId);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getCartById "+e.getMessage());
		}
		return null;
	}

	@Override
	public Double getCartTotal(int cartId) {
		try {
			return cartRepository.findById((long) cartId).get().getTotalPrice();
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getCartTotal "+e.getMessage());
		}
		return null;
		
	}

	
	@Override
	public Cart updateCart(Cart cart) {
		try {
			cartRepository.save(cart);
			return cartRepository.findById(cart.getCartId()).get();
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON updateCart "+e.getMessage());
		}
		return null;
		
	}

	
		



	

}
