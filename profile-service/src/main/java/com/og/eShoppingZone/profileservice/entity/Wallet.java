package com.og.eShoppingZone.profileservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Wallet {

	@Id
	long id;
	double balance;
	@Override
	public String toString() {
		return "Wallet [id=" + id + ", balance=" + balance + "]";
	}
	
	
	
	
	
	
}
