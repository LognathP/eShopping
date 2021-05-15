package com.og.eShoppingZone.profileservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_id")
	long profileId;
	@NotNull
	@Column(name = "full_name")
	String fullName;
	String image;
	@NotNull
	@Column(name = "email_id")
	String emailId;
	@NotNull
	@Column(name = "mobile_number")
	String mobileNumber;
	String about;
	@Column(name = "date_of_birth")
	String dateOfBirth;
	String gender;
	String role;
	String password;
	
	@Override
	public String toString() {
		return "UserProfile [profileId=" + profileId + ", fullName=" + fullName + ", image=" + image + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", about=" + about + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", role=" + role + ", password=" + password + "]";
	}
	
	
	
	
}
