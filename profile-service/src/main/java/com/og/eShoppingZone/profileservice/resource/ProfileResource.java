package com.og.eShoppingZone.profileservice.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.og.eShoppingZone.profileservice.entity.Profile;
import com.og.eShoppingZone.profileservice.logger.CommonLogger;
import com.og.eShoppingZone.profileservice.service.ProfileService;


@RestController
@RequestMapping(value = "api/v1/profile")
public class ProfileResource {
	
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	CommonLogger logger;

	@Autowired
	ProfileService profileService;
	
	@PostMapping("/addcustomer")
	public boolean addCustomerProfile(@RequestBody Profile profile)
	{
		logger.info(this.getClass(),"ADD CUSTOMER PROFILE API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+profile.toString());
		return profileService.addCustomerProfile(profile);	
	}
	
	@PostMapping("/addmerchant")
	public boolean addMerchantProfile(@RequestBody Profile profile)
	{
		logger.info(this.getClass(),"ADD MERCHANT PROFILE API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+profile.toString());
		return profileService.addMerchantProfile(profile);	
	}
	
	@PostMapping("/adddeliveryagent")
	public boolean addDeliveryAgentProfile(@RequestBody Profile profile)
	{
		logger.info(this.getClass(),"ADD DELIVERY AGENT PROFILE API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+profile.toString());
		return profileService.addDeliveryAgentProfile(profile);	
	}
	
	@GetMapping("/getallprofile")
	public ResponseEntity<List<Profile>> getAllprofiles()
	{
		logger.info(this.getClass(),"GET ALL PROFILE API CALL STARTED AT "+dateFormat.format(new Date()));
		return new ResponseEntity<List<Profile>>(profileService.getAllprofiles(),HttpStatus.OK);
	}
	
	@GetMapping("/getprofilebyid")
	public ResponseEntity<Optional<Profile>> getProfileById(@RequestParam int profileId)
	{
		logger.info(this.getClass(),"GET PROFILE BY ID API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY ID "+profileId);
		return new ResponseEntity<Optional<Profile>>(profileService.getProfileById(profileId),HttpStatus.OK);
	}
	
	@GetMapping("/getprofilebyphone")
	public ResponseEntity<Optional<Profile>> getProfileByPhone(@RequestParam String phoneNo)
	{
		logger.info(this.getClass(),"GET PROFILE BY NAME API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY NAME "+phoneNo);
		return new ResponseEntity<Optional<Profile>>(profileService.getProfileByPhone(phoneNo),HttpStatus.OK);
	}
	
	@GetMapping("/getprofilebyname")
	public ResponseEntity<List<Profile>> getProfileByName(@RequestParam String name)
	{
		logger.info(this.getClass(),"GET PROFILE BY CATEGORY API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY CATEGORY "+name);
		return new ResponseEntity<List<Profile>>(profileService.getProfileByName(name),HttpStatus.OK);
	}

	@PutMapping("/updateprofile")
	public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile)
	{
		logger.info(this.getClass(),"UPDATE PROFILE API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY "+profile.toString());
		return new ResponseEntity<Profile>(profileService.updateProfile(profile),HttpStatus.OK);
	}

	@DeleteMapping("/deleteprofile")
	public boolean deleteProfile(@RequestParam int profileId)
	{
		logger.info(this.getClass(),"DELETE PROFILE API CALL STARTED AT "+dateFormat.format(new Date()));
		logger.debug(this.getClass(),"REQUEST ENTITY ID "+profileId);
		return profileService.deleteProfile(profileId);	
	}
}
