package com.og.eShoppingZone.walletservice.service;

import org.springframework.stereotype.Service;

import com.og.eShoppingZone.walletservice.entity.Wallet;



@Service
public interface WalletService {

	double getBalance(int walletId);

	boolean addMoney(Wallet wallet);

	boolean updateWallet(Wallet wallet);
	
	
	

}
