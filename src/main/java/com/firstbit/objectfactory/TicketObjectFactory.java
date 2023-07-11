package com.firstbit.objectfactory;

import java.util.Scanner;

import com.firstbit.models.Bus;
import com.firstbit.models.Ticket;
import com.firstbit.utils.DateUtils;
import com.firstbit.utils.TicketGenerationUtils;

public class TicketObjectFactory {

	public static Scanner scanner = new Scanner(System.in);

	public static Ticket getTicketObject(Bus bus) {

		System.out.println("================================================================");
		System.out.println("Please Enter the Ticket Details : ");
		System.out.println("Passenger Name : ");
		String passengerName = scanner.next();
		System.out.println("Passenger Age : ");
		Integer passengerAge = scanner.nextInt();
		System.out.println("Passenger Gender : ");
		String passengerGender = scanner.next();
		System.out.println("Number Of Seats to be Booked : ");
		int numberOfSeatsToBeBooked = scanner.nextInt();
		System.out.println("================================================================");
		Ticket ticket = new Ticket(TicketGenerationUtils.generatePNR(), passengerName, passengerAge, passengerGender,
				DateUtils.getDate(), DateUtils.getCurrentDate(), numberOfSeatsToBeBooked, bus.getBusNumber());
		return ticket;
	}

}
