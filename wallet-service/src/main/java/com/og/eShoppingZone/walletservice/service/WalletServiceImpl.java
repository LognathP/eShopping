package com.og.eShoppingZone.walletservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.og.eShoppingZone.walletservice.entity.Wallet;
import com.og.eShoppingZone.walletservice.logger.CommonLogger;
import com.og.eShoppingZone.walletservice.repository.WalletRepository;


@Component
public class WalletServiceImpl implements WalletService {

	@Autowired
	CommonLogger logger;
	
	@Autowired
	WalletRepository walletRepository;

	@Override
	public double getBalance(int walletId) {
		return walletRepository.findById((long) walletId).get().getBalance();
	}

	@Override
	public boolean addMoney(Wallet wallet) {
		boolean stat = false;
		try {
			walletRepository.addMoney(wallet.getId(),wallet.getBalance());
			stat = true;
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON addMoney "+e.getMessage());
		}
		return stat;
	}

	@Override
	public boolean updateWallet(Wallet wallet) {
		boolean stat = false;
		try {
			walletRepository.updateMoney(wallet.getId(),wallet.getBalance());
			stat = true;
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON updateWallet "+e.getMessage());
		}
		return stat;
	}
	
	

	
	
		



	

}
