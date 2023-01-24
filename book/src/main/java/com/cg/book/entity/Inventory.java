package com.cg.book.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "inv_id")
	private int id;

	private int flightNumber;

	@Temporal(TemporalType.DATE)
	private Date flightDate;

	private int available;

	public Inventory() {

	}

	public Inventory(int id, int flightNumber, Date flightDate, int available) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.available = available;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", available="
				+ available + "]";
	}

}
