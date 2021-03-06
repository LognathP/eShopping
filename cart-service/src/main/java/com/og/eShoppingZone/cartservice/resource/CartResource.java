package com.og.eShoppingZone.cartservice.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.og.eShoppingZone.cartservice.entity.Cart;
import com.og.eShoppingZone.cartservice.logger.CommonLogger;
import com.og.eShoppingZone.cartservice.service.CartService;


@RestController
@RequestMapping(value = "api/v1/cart")
public class CartResource {
	
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	CommonLogger logger;

	@Autowired
	CartService cartService;
	
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	@PostMapping("/addcart")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart)
	{
		logger.info(this.getClass(),"ADD CART CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+cart.toString());
		return new ResponseEntity<Cart>(cartService.addCart(cart),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	@GetMapping("/getallcart")
	public ResponseEntity<List<Cart>> getAllcarts()
	{
		logger.info(this.getClass(),"GET ALL CART API CALL STARTED AT "+dateFormat.format(new Date()));
		return new ResponseEntity<List<Cart>>(cartService.getAllcarts(),HttpStatus.OK);
	}
	
	@GetMapping("/getcartbyid")
	public ResponseEntity<Cart> getCartById(@RequestParam int cartId)
	{
		logger.info(this.getClass(),"GET CART BY ID API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY ID "+cartId);
		return new ResponseEntity<Cart>(cartService.getCartById(cartId),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	@GetMapping("/getcarttotal")
	public ResponseEntity<Double> getCartTotal(@RequestParam int cartId)
	{
		logger.info(this.getClass(),"GET CART TOTAL API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY NAME "+cartId);
		return new ResponseEntity<Double>(cartService.getCartTotal(cartId),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart)
	{
		logger.info(this.getClass(),"UPDATE CART API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+cart.toString());
		return new ResponseEntity<Cart>(cartService.updateCart(cart),HttpStatus.OK);
	}

	
}
