package com.og.eShoppingZone.cartservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.og.eShoppingZone.cartservice.entity.Address;
import com.og.eShoppingZone.cartservice.entity.Cart;
import com.og.eShoppingZone.cartservice.entity.Order;



@Service
public interface OrderService {

	List<Order> getAllOrders();

	List<Address> getAllAddress();

	List<Order> getOrderbyCustomerId(int customerId);

	List<Address> getAddressbyCustomerId(int customerId);

	boolean placeOrder(Order order);

	boolean storeAddress(Address address);

	boolean changeOrderStatus(int orderId,int orderStatus);

	
	
	

}
