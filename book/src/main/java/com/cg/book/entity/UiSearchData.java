package com.cg.book.entity;

import java.util.Date;

public class UiSearchData {
	String origin;
	String destination;
	Date flightDate;

	public UiSearchData() {

	}

	public UiSearchData(String origin, String destination, Date flightDate) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
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

	@Override
	public String toString() {
		return "UiSearchData [origin=" + origin + ", destination=" + destination + ", flightDate=" + flightDate + "]";
	}

}
