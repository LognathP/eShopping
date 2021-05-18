package com.og.eShoppingZone.walletservice.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.og.eShoppingZone.walletservice.entity.Wallet;


public interface WalletRepository extends JpaRepository<Wallet,Long>{

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE Wallet w set w.balance = w.balance + :bal where w.id = :id")
	void addMoney(@Param("id") long id, @Param("bal") double balance);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE Wallet w set w.balance = w.balance - :bal where w.id = :id")
	void updateMoney(@Param("id") long id, @Param("bal") double balance);
}
