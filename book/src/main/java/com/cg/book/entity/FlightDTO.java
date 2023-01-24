package com.cg.book.entity;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class FlightDTO {

	private int flightId;
	private String origin;
	private String destination;
	@Temporal(TemporalType.DATE)
	private Date flightDate;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

}
