package com.cg.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pass_id")
	private int passengerId;
	private String firstName;
	private String lastName;
	private String gender;

	public Passenger() {

	}

	public Passenger(String firstName, String lastName, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + "]";
	}

}
