package com.og.eShoppingZone.walletservice.resource;

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

import com.og.eShoppingZone.walletservice.entity.Wallet;
import com.og.eShoppingZone.walletservice.logger.CommonLogger;
import com.og.eShoppingZone.walletservice.service.WalletService;


@RestController
@RequestMapping(value = "api/v1/wallet")
public class WalletResource {
	
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	CommonLogger logger;

	@Autowired
	WalletService walletService;
	
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	@PostMapping("/getbalance")
	public double getBalance(@RequestParam int walletId)
	{
		logger.info(this.getClass(),"GET BALANCE API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+walletId);
		return walletService.getBalance(walletId);	
	}
	
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	@PostMapping("/addmoney")
	public boolean addMoney(@RequestBody Wallet wallet)
	{
		logger.info(this.getClass(),"ADD MONEY API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+wallet.toString());
		return walletService.addMoney(wallet);	
	}
	
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	@PostMapping("/updatewallet")
	public boolean updateWallet(@RequestBody Wallet wallet)
	{
		logger.info(this.getClass(),"UPDATE WALLET API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+wallet.toString());
		return walletService.updateWallet(wallet);	
	}
	
	
}
