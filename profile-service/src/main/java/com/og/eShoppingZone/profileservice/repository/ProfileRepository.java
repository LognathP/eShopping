package com.og.eShoppingZone.profileservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.og.eShoppingZone.profileservice.entity.Profile;


public interface ProfileRepository extends JpaRepository<Profile,Long>{

	
	@Query("SELECT p FROM Profile p where p.mobileNumber = :no")
	Optional<Profile> findByProfileByPhone(@Param("no") String name);
	
	@Query("SELECT p FROM Profile p where p.fullName = :name")
	List<Profile> findByProfileByName(@Param("name") String name);
}
