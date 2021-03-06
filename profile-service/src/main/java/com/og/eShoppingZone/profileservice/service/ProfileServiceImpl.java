package com.og.eShoppingZone.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.og.eShoppingZone.profileservice.entity.Profile;
import com.og.eShoppingZone.profileservice.entity.Role;
import com.og.eShoppingZone.profileservice.entity.Wallet;
import com.og.eShoppingZone.profileservice.logger.CommonLogger;
import com.og.eShoppingZone.profileservice.repository.ProfileRepository;
import com.og.eShoppingZone.profileservice.repository.WalletRepository;
import com.og.eShoppingZone.profileservice.util.DESEncryptor;


@Component
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	CommonLogger logger;
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	private Environment env;
	
	
	@Override
	public boolean addCustomerProfile(Profile profile) {
		boolean status = false;
		try {
			profile.setRole(Role.Customer);
			profile.setPassword(DESEncryptor.encrypt(profile.getPassword(), env.getProperty("password.key")));
			profileRepository.save(profile);
			Wallet w = new Wallet();
			w.setId(profile.getProfileId());
			w.setBalance(0);
			walletRepository.save(w);
			status = true;
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON addCustomerProfile "+e.getMessage());
		}
		return status;		
	}
	
	@Override
	public boolean addMerchantProfile(Profile profile) {
		boolean status = false;
		try {
			profile.setPassword(DESEncryptor.encrypt(profile.getPassword(), env.getProperty("password.key")));
			profile.setRole(Role.Merchant);
			profileRepository.save(profile);
			status = true;
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON addMerchantProfile "+e.getMessage());
		}
		return status;		
	}
	
	@Override
	public boolean addDeliveryAgentProfile(Profile profile) {
		boolean status = false;
		try {
			profile.setPassword(DESEncryptor.encrypt(profile.getPassword(), env.getProperty("password.key")));
			profile.setRole(Role.DeliveryAgent);
			profileRepository.save(profile);
			status = true;
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON addDeliveryAgentProfile "+e.getMessage());
		}
		return status;		
	}

	@Override
	public List<Profile> getAllprofiles() {
		try {
			return profileRepository.findAll();
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getAllprofiles "+e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<Profile> getProfileById(int profileId) {
		try {
			return profileRepository.findById((long) profileId);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getProfileById "+e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<Profile> getProfileByPhone(String phoneNo) {
		try {
			return profileRepository.findByProfileByPhone(phoneNo);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getProfileByPhone "+e.getMessage());
		}
		return null;
		
	}

	@Override
	public List<Profile> getProfileByName(String name) {
		try {
			return profileRepository.findByProfileByName(name);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getProfileByName "+e.getMessage());
		}
		return null;
		
	}

	@Override
	public Profile updateProfile(Profile profile) {
		try {
			profile.setPassword(DESEncryptor.encrypt(profile.getPassword(), env.getProperty("password.key")));
			profileRepository.save(profile);
			return profileRepository.findById(profile.getProfileId()).get();
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON updateProfile "+e.getMessage());
		}
		return null;
		
	}

	@Override
	public boolean deleteProfile(int profileId) {
		boolean status = false;
		try {
			profileRepository.deleteById((long) profileId);
			status = true;
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON deleteProfile "+e.getMessage());
		}
		return status;
				
	}

	@Override
	public Profile authenticateLogin(String email, String password) {
		try {
			return profileRepository.authenticateUser(email, password);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON authenticateLogin "+e.getMessage());
		}
		return null;
	}
	
	@Override
	public Profile getProfileByEmail(String email) {
		try {
			return profileRepository.findByProfileByEmail(email);
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getProfileByEmail "+e.getMessage());
		}
		return null;
	}

	
	
		



	

}
