package com.og.eShoppingZone.profileservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.og.eShoppingZone.profileservice.entity.Profile;
import com.og.eShoppingZone.profileservice.entity.Wallet;


public interface WalletRepository extends JpaRepository<Wallet,Long>{


}
