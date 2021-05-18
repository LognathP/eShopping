package com.og.eShoppingZone.cartservice.resource;

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

import com.og.eShoppingZone.cartservice.entity.Address;
import com.og.eShoppingZone.cartservice.entity.Cart;
import com.og.eShoppingZone.cartservice.entity.Order;
import com.og.eShoppingZone.cartservice.logger.CommonLogger;
import com.og.eShoppingZone.cartservice.service.CartService;
import com.og.eShoppingZone.cartservice.service.OrderService;


@RestController
@RequestMapping(value = "api/v1/order")
public class OrderResource {
	
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	CommonLogger logger;

	@Autowired
	OrderService orderService;
	
	@GetMapping("/getallorders")
	public ResponseEntity<List<Order>> getAllOrders()
	{
		logger.info(this.getClass(),"GET ALL ORDERS API CALL STARTED AT "+dateFormat.format(new Date()));
		return new ResponseEntity<List<Order>>(orderService.getAllOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/getalladdress")
	public ResponseEntity<List<Address>> getAllAddress()
	{
		logger.info(this.getClass(),"GET ALL ADDRESS API CALL STARTED AT "+dateFormat.format(new Date()));
		return new ResponseEntity<List<Address>>(orderService.getAllAddress(),HttpStatus.OK);
	}
	
	@GetMapping("/getallorderbyid")
	public ResponseEntity<List<Order>> getOrderbyCustomerId(@RequestParam int customerId)
	{
		logger.info(this.getClass(),"GET CUSTOMER ORDER API CALL STARTED AT "+dateFormat.format(new Date()));
		return new ResponseEntity<List<Order>>(orderService.getOrderbyCustomerId(customerId),HttpStatus.OK);
	}
	
	@GetMapping("/getalladdressbyid")
	public ResponseEntity<List<Address>> getAddressbyCustomerId(@RequestParam int customerId)
	{
		logger.info(this.getClass(),"GET ADDRESS ORDER API CALL STARTED AT "+dateFormat.format(new Date()));
		return new ResponseEntity<List<Address>>(orderService.getAddressbyCustomerId(customerId),HttpStatus.OK);
	}
	
	@PostMapping("/placeorder")
	public boolean placeOrder(@RequestBody Order order)
	{
		logger.info(this.getClass(),"PLACE ORDER API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY NAME "+order.toString());
		return orderService.placeOrder(order);
	}
	
	@PostMapping("/storeaddress")
	public boolean storeAddress(@RequestBody Address address)
	{
		logger.info(this.getClass(),"ADD ADDRESS API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY NAME "+address.toString());
		return orderService.storeAddress(address);
	}
	
	@PostMapping("/changeorderstatus")
	public boolean changeOrderStatus(@RequestParam int orderId,@RequestParam int orderStatus)
	{
		logger.info(this.getClass(),"CHANGE ORDER STATUS API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY NAME "+orderId + " - " + orderStatus);
		return orderService.changeOrderStatus(orderId,orderStatus);
	}
	
	

	

	
}
