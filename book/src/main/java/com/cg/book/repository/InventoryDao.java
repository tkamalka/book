package com.cg.book.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.book.entity.Inventory;

public interface InventoryDao extends JpaRepository<Inventory, Integer> {
	public Inventory findByFlightNumberAndFlightDate(int flightNumber, Date flightDate);
	
	public Inventory findByFlightNumber(int flightNumber);

}
