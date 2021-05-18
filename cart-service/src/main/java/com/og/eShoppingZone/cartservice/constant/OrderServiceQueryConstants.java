package com.og.eShoppingZone.cartservice.constant;

public interface OrderServiceQueryConstants {

	public String GET_ALL_ORDERS = "SELECT orderId, orderDate, customerId, amountPaid, modeOfPayment, orderStatus,cartId FROM `order`";
	
	public String GET_ALL_ADDRESS = "SELECT id, customerId, fullName, mobileNumber, flatNumber, city, pinCode, state FROM address";
			
	public String GET_ORDERS_CUSTOMERID = "SELECT orderId, orderDate, customerId, amountPaid, modeOfPayment, orderStatus,cartId FROM `order` where customerId = ?";
	
	public String GET_ADDRESS_CUSTOMERID = "SELECT id, customerId, fullName, mobileNumber, flatNumber, city, pinCode, state FROM address where customerId = ?";
	
	public String ADD_ADDRESS = "INSERT INTO address (customerId, fullName, mobileNumber, flatNumber, city, pinCode, state) VALUES (?,?,?,?,?,?,?)";
	
	public String PLACE_ORDER = "INSERT INTO `order` (orderDate, customerId, amountPaid, modeOfPayment, orderStatus,cartId) VALUES (?,?,?,?,?,?)";
	
	public String UPDATE_ORDER = "UPDATE `order` set orderStatus = ? where orderId = ?";
}
