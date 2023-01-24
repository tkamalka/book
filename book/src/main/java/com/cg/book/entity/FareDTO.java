package com.cg.book.entity;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class FareDTO {
	private int fareId;
	private int flightNumber;
	private Date flightDate;
	private long fare;

	public int getFareId() {
		return fareId;
	}

	public void setFareId(int fareId) {
		this.fareId = fareId;
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

	public long getFare() {
		return fare;
	}

	public void setFare(long fare) {
		this.fare = fare;
	}

}
