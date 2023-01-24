package com.cg.book.entity;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private int flightNumber;
	private String origin;
	private String destination;
	private Date bookingDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date flightDate;
	private long fare;
	private long totalFare;
	private String status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	Set<Passenger> passenger;

	public Book() {

	}

	public Book(int flightNumber, String origin, String destination, Date bookingDate, Date flightDate,
			long fare, String status, Set<Passenger> passenger) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.bookingDate = bookingDate;
		this.flightDate = flightDate;
		this.fare = fare;
		this.status = status;
		this.passenger = passenger;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
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

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(Set<Passenger> passenger) {
		this.passenger = passenger;
	}
	

	public long getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(long totalFare) {
		this.totalFare = totalFare;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", flightNumber=" + flightNumber + ", origin=" + origin + ", destination="
				+ destination + ", bookingDate=" + bookingDate + ", flightDate=" + flightDate + ", fare=" + fare
				+ ", totalFare=" + totalFare + ", status=" + status + ", passenger=" + passenger + "]";
	}

	

}
