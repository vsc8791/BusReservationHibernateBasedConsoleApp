package com.firstbit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer busId;

	@Column(name = "bus_number")
	private String busNumber;

	@Column(name = "bus_type")
	private String busType;

	@Column(name = "max_seats")
	private Integer maxSeats;

	@Column(name = "booked_seats")
	private Integer bookedSeats;

	@Column(name = "remaining_seats")
	private Integer remainingSeats;

	@Column(name = "bus_fare")
	private Double busFare;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "source_time")
	private String sourceTime;

	@Column(name = "destination_time")
	private String destinationTime;

	public Bus() {

	}

	public Bus(String busNumber, String busType, Integer maxSeats, Integer bookedSeats, Integer remainingSeats,
			Double busFare, String source, String destination, String sourceTime, String destinationTime) {
		super();
		this.busNumber = busNumber;
		this.maxSeats = maxSeats;
		this.bookedSeats = bookedSeats;
		this.remainingSeats = remainingSeats;
		this.busFare = busFare;
		this.source = source;
		this.destination = destination;
		this.sourceTime = sourceTime;
		this.destinationTime = destinationTime;
		this.busType = busType;
	}
	
	

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public Integer getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(Integer maxSeats) {
		this.maxSeats = maxSeats;
	}

	public Integer getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Integer bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public Integer getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(Integer remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public Double getBusFare() {
		return busFare;
	}

	public void setBusFare(Double busFare) {
		this.busFare = busFare;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSourceTime() {
		return sourceTime;
	}

	public void setSourceTime(String sourceTime) {
		this.sourceTime = sourceTime;
	}

	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}

}
