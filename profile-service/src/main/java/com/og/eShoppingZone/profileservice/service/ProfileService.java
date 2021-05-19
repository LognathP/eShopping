package com.og.eShoppingZone.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.og.eShoppingZone.profileservice.entity.Profile;



@Service
public interface ProfileService {

	boolean addCustomerProfile(Profile profile);

	boolean addMerchantProfile(Profile profile);

	boolean addDeliveryAgentProfile(Profile profile);

	List<Profile> getAllprofiles();

	Optional<Profile> getProfileById(int profileId);

	Optional<Profile> getProfileByPhone(String phoneNo);

	List<Profile> getProfileByName(String name);

	Profile updateProfile(Profile profile);

	boolean deleteProfile(int profileId);

	Profile authenticateLogin(String email, String password);

	Profile getProfileByEmail(String email);
	
	
	
	

}
