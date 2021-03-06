package com.og.eShoppingZone.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.og.eShoppingZone.cartservice.dao.CartServiceDao;
import com.og.eShoppingZone.cartservice.entity.Cart;
import com.og.eShoppingZone.cartservice.logger.CommonLogger;


@Component
public class CartServiceImpl implements CartService {

	@Autowired
	CommonLogger logger;
	
	@Autowired
	CartServiceDao cartDao;

		
	@Override
	public Cart addCart(Cart cart) {
		try {
			cartDao.addCart(cart);
					
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON addCart "+e.getMessage());
		}
		return cart;
	}
	
	@Override
	public List<Cart> getAllcarts() {
		try {
			return cartDao.getAllcarts();
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getAllcarts "+e.getMessage());
		}
		return null;
	}

	@Override
	public Cart getCartById(int cartId) {
		try {
			return cartDao.getCartById(cartId);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getCartById "+e.getMessage());
		}
		return null;
	}

	@Override
	public Double getCartTotal(int cartId) {
		try {
			return cartDao.getCartTotal(cartId);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getCartTotal "+e.getMessage());
		}
		return null;
		
	}

	
	@Override
	public Cart updateCart(Cart cart) {
		try {
			return cartDao.updateCart(cart);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON updateCart "+e.getMessage());
		}
		return null;
		
	}


	
		



	

}
