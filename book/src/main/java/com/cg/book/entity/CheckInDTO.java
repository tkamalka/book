package com.cg.book.entity;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class CheckInDTO {
	private int id;
	private String lastName;
	private String firstName;
	private Date checkInTime;
	private int flightNumber;
	@Temporal(TemporalType.DATE)
	private Date flightdate;
	private int bookingId;

	public CheckInDTO() {

	}

	public CheckInDTO(String lastName, String firstName, Date checkInTime, int flightNumber, Date flightdate,
			int bookingId) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.checkInTime = checkInTime;
		this.flightNumber = flightNumber;
		this.flightdate = flightdate;
		this.bookingId = bookingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getFlightdate() {
		return flightdate;
	}

	public void setFlightdate(Date flightdate) {
		this.flightdate = flightdate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "CheckInDTO [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", checkInTime="
				+ checkInTime + ", flightNumber=" + flightNumber + ", flightdate=" + flightdate + ", bookingId="
				+ bookingId + "]";
	}

}
