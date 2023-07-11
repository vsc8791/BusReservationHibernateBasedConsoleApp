package com.firstbit.objectfactory;

import java.util.Scanner;

import com.firstbit.main.TestBusApplication;
import com.firstbit.models.Bus;

public class BusObjectFactory {

	public static Scanner scanner = new Scanner(System.in);

	public static Bus getBusObject() {

		System.out.println("================================================================");
		System.out.println("Please Enter the Bus Details : ");
		System.out.println("Bus Number : ");
		String busNumber = scanner.next();
		System.out.println("Bus Type : ");
		String busType = scanner.next();
		System.out.println("Bus Max Seats : ");
		Integer maxSeats = scanner.nextInt();
		System.out.println("Bus Fare : ");
		Double busFare = scanner.nextDouble();
		System.out.println("Source Station : ");
		String source = scanner.next();
		System.out.println("Destination Station : ");
		String destination = scanner.next();
		System.out.println("Source Departure Time : ");
		String sourceTime = scanner.next();
		System.out.println("Destination Arrival Time : ");
		String destinationTime = scanner.next();
		System.out.println("================================================================");
		Bus bus = new Bus(busNumber, busType, maxSeats, 0, maxSeats, busFare, source, destination, sourceTime,
				destinationTime);
		return bus;
	}

	public static Bus updateBusObject(Bus bus) {

		int choice = 0;
		System.out.println("================================================================");
		System.out.println("Enter Details What you want to Change : ");
		System.out.println("1. Bus Type");
		System.out.println("2. Bus Max Seats");
		System.out.println("3. Bus Fare");
		System.out.println("4. Source Station ");
		System.out.println("5. Destination Station");
		System.out.println("6. Source Departure Time");
		System.out.println("7. Destination Arrival Time");
		System.out.println("8. Remaining Seats");
		choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Updated Bus Type : ");
			String busType = scanner.next();
			bus.setBusType(busType);
			break;
		case 2:
			System.out.println("Updated Bus Max Seats : ");
			Integer maxSeats = scanner.nextInt();
			bus.setMaxSeats(maxSeats);
			break;
		case 3:
			System.out.println("Updated Bus Fare : ");
			Double busFare = scanner.nextDouble();
			bus.setBusFare(busFare);
			break;
		case 4:
			System.out.println("Updated Source Station : ");
			String source = scanner.next();
			bus.setSource(source);
			break;
		case 5:
			System.out.println("Updated Destination Station : ");
			String destination = scanner.next();
			bus.setDestination(destination);
			break;
		case 6:
			System.out.println("Updated Source Departure Time : ");
			String sourceTime = scanner.next();
			bus.setSourceTime(sourceTime);
			break;
		case 7:
			System.out.println("Updated Destination Arrival Time : ");
			String destinationTime = scanner.next();
			bus.setDestinationTime(destinationTime);
			break;
		case 8:
			System.out.println("Updated Remaining Seats : ");
			Integer remainingSeats = scanner.nextInt();
			bus.setRemainingSeats(remainingSeats);
			break;

		}
		System.out.println("================================================================");

		return bus;
	}

}
