package com.og.eShoppingZone.cartservice.entity;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class Address {

	int id;
	int customerId;
	String fullName;
	String mobileNumber;
	int flatNumber;
	String city;
	int pinCode;
	String state;
}


