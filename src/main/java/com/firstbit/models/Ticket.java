package com.firstbit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@Column(name = "pnr_number")
	private String pnrNumber;

	@Column(name = "passenger_name")
	private String passengerName;

	@Column(name = "passenger_age")
	private Integer passengerAge;

	@Column(name = "passenger_gender")
	private String passengerGender;

	@Column(name = "date_of_journey")
	private String dateOfJourney;

	@Column(name = "date_of_booking")
	private String dateOfBooking;

	@Column(name = "number_of_seats_to_be_booked")
	private Integer numberOfSeatsToBeBooked;

	@Column(name = "linked_bus_number")
	private String linkedBusNumber;

	public Ticket() {

	}

	public Ticket(String pnrNumber, String passengerName, Integer passengerAge, String passengerGender,
			String dateOfJourney, String dateOfBooking, Integer numberOfSeatsToBeBooked, String linkedBusNumber) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
		this.dateOfJourney = dateOfJourney;
		this.dateOfBooking = dateOfBooking;
		this.numberOfSeatsToBeBooked = numberOfSeatsToBeBooked;
		this.linkedBusNumber = linkedBusNumber;
	}

	public String getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(String dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public Integer getNumberOfSeatsToBeBooked() {
		return numberOfSeatsToBeBooked;
	}

	public void setNumberOfSeatsToBeBooked(Integer numberOfSeatsToBeBooked) {
		this.numberOfSeatsToBeBooked = numberOfSeatsToBeBooked;
	}

	public String getLinkedBusNumber() {
		return linkedBusNumber;
	}

	public void setLinkedBusNumber(String linkedBusNumber) {
		this.linkedBusNumber = linkedBusNumber;
	}

	@Override
	public String toString() {
		return "Ticket [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", passengerAge=" + passengerAge
				+ ", passengerGender=" + passengerGender + ", dateOfJourney=" + dateOfJourney + ", dateOfBooking="
				+ dateOfBooking + ", numberOfSeatsToBeBooked=" + numberOfSeatsToBeBooked + "]";
	}

}
