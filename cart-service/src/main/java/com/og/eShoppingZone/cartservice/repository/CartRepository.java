package com.og.eShoppingZone.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.og.eShoppingZone.cartservice.entity.Cart;


public interface CartRepository extends JpaRepository<Cart,Long>{

		
}
