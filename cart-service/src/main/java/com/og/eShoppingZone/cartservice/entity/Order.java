package com.og.eShoppingZone.cartservice.entity;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class Order {

	int orderId;
	Date orderDate;
	int customerId;
	double amountPaid;
	String modeOfPayment;
	int orderStatus;
	int cartId;
		
}


