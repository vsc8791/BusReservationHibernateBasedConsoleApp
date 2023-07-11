package com.firstbit.main;

import java.util.List;
import java.util.Scanner;

import com.firstbit.dao.BusDAO;
import com.firstbit.dao.BusDAOImpl;
import com.firstbit.dao.TicketDAO;
import com.firstbit.dao.TicketDAOImpl;
import com.firstbit.models.Bus;
import com.firstbit.models.Ticket;
import com.firstbit.objectfactory.BusObjectFactory;
import com.firstbit.objectfactory.TicketObjectFactory;

public class TestBusApplication {

	public static Scanner scanner = new Scanner(System.in);

	static void printHeading(String header) {

		System.out.println("==========================================================\n");
		System.out.println("                       " + header + "                     \n");
		System.out.println("==========================================================\n");
	}

	public static void welcomeScreen() {
		System.out.println(" ================================================");
		System.out.println(" ||                  WELCOME TO                ||");
		System.out.println(" ||                                            ||");
		System.out.println(" ||      BUS RESERVATION SYSTEM MANAGEMENT     ||");
		System.out.println(" ||                                            ||");
		System.out.println(" ||                    PROJECT                 ||");
		System.out.println(" ||        Developer : Vaibhav Singh Chauhan   ||");
		System.out.println(" ================================================");
		mainMenu();
	}

	public static void mainMenu() {
		int choice;

		while (true) {

			// MENU ITEMS
			printHeading("MAIN MENU");

			System.out.println(" -------------------------------------------------");
			System.out.println("  1. User Menu                                   ");
			System.out.println(" ------------------------------------------------");
			System.out.println("  2. Admin Menu                                  ");
			System.out.println(" ------------------------------------------------");
			System.out.println("  3. EXIT                                         ");
			System.out.println(" ------------------------------------------------");
			System.out.println(" Enter your choice:-> ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				userMenu();
				break;

			case 2:
				adminLogin();
				break;

			case 3:

				System.out.println("   Thanks for using our project...!!! ");
				System.out.println("           Have a nice day...!!!      ");
				System.exit(0);

			default:
				System.out.println("   Choose valid option!!! ");
				mainMenu();
			}
		}
	}

	// ADMIN LOGIN
	public static void adminLogin() {
		String adminUname;
		String adminPass;

		printHeading("ADMIN LOGIN");
		System.out.println(" Enter AdminID:-> ");
		adminUname = scanner.next();
		System.out.println(" Enter Password:-> ");
		adminPass = scanner.next();
		;
		if (adminUname.equals("admin") && adminPass.equals("admin")) {
			adminMenu();
		} else {
			System.out.println(" Username or Password is wrong...!!! ");

			adminLogin();
		}
	}

	// USER MENU
	public static void userMenu() {

		int choice;
		while (true) {

			TicketDAOImpl ticketObj = new TicketDAOImpl();
			BusDAO busObj = new BusDAOImpl();
			// MENU ITEMS
			printHeading("USER MENU");

			System.out.println(" -------------------------------------------------");
			System.out.println("  1. Book Ticket                                  ");
			System.out.println(" -------------------------------------------------");
			System.out.println("  2. View Ticket                                  ");
			System.out.println(" -------------------------------------------------");
			System.out.println("  3. Cancel Ticket                                ");
			System.out.println(" -------------------------------------------------");
			System.out.println("  4. BACK                                         ");
			System.out.println(" -------------------------------------------------");

			System.out.println(" Enter your choice:-> ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				busObj.showBusesDetails();
				System.out.println(" Enter your Bus Number :");
				String busNo_12 = scanner.next();
				Bus bus = busObj.viewBusDetails(busNo_12);
				System.out.println("========log1");
				Ticket ticket = TicketObjectFactory.getTicketObject(bus);
				ticketObj.generateTicket(ticket);
				System.out.println("---- TICKET GENERATED SUCCESSFULLY ----");
				break;

			case 2:
				System.out.println(" Enter your PNR Number to fetch Ticket Details:-> ");
				String pnr_01 = scanner.next();
				ticketObj.showTicketByPNR(pnr_01);

				break;

			case 3:
				System.out.println(" Enter your PNR Number to cancel:-> ");
				String pnr_02 = scanner.next();
				ticketObj.cancelBookedTicket(pnr_02);
				break;

			case 4:

				mainMenu();
				break;

			default:
				System.out.println("  Choose valid option!!! ");

				break;

			}
		}
	}

	// ADMIN MENU FUNCTION
	public static void adminMenu() {
		BusDAO busObj = new BusDAOImpl();
		TicketDAO ticketObj = new TicketDAOImpl();
		int choice;
		while (true) {

			printHeading("ADMIN PORTAL");

			System.out.println("-------------------------------------------------");
			System.out.println(" 1. Add Bus                                      ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 2. View Buses                                   ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 3. Book Ticket                                  ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 4. Edit Ticket                                  ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 5. Cancel Ticket                                ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 6. View Bookings                                ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 7. View Bus Details                             ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 8. Edit Bus                                     ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 9. Delete Bus                                   ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 10. BACK                                        ");
			System.out.println("-------------------------------------------------");

			System.out.println("Enter your choice:-> ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				busObj.addBus(BusObjectFactory.getBusObject());
				System.out.println("Bus Added Successfully....");
				break;
			case 2:
				busObj.showBusesDetails();
				break;

			case 3:
				//ticketObj.generateTicket(TicketObjectFactory.getTicketObject());
				break;

			case 4:
				System.out.println(" Enter your PNR Number to fetch Ticket Details to Update:-> ");
				String pnr_01 = scanner.next();
				ticketObj.editTicket(pnr_01);
				break;

			case 5:
				System.out.println(" Enter your PNR Number to cancel:-> ");
				String pnr_04 = scanner.next();
				ticketObj.cancelBookedTicket(pnr_04);
				break;

			case 6:
				viewBookingsMenu();
				break;

			case 7:
				System.out.println(" Enter your Bus Number:-> ");
				String busNum_01 = scanner.next();
				busObj.viewBusDetails(busNum_01);
				break;

			case 8:
				System.out.println(" Enter your Bus Number you want to Update:-> ");
				String busNum_03 = scanner.next();
				busObj.editBus(busNum_03);
				break;

			case 9:
				System.out.println(" Enter your Bus Number you want to delete:-> ");
				String busNum_02 = scanner.next();
				busObj.deleteBus(busNum_02);
				break;

			case 10:

				mainMenu();
				break;

			default:
				System.out.println("  Choose valid option!!! ");
				adminMenu();
			}
		}
	}

	// VIEW BOOKINGS MENU FUNCTION
	public static void viewBookingsMenu() {
		TicketDAO ticketObj = new TicketDAOImpl();
		int choice;

		while (true) {

			// printHeading("VIEW BOOKINGS");

			System.out.println("-------------------------------------------------");
			System.out.println(" 1. By PNR                                      ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 2. By Name                                      ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 3. By Bus                                       ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 4. All Bookings                                 ");
			System.out.println("-------------------------------------------------");
			System.out.println(" 5. BACK                                         ");
			System.out.println("-------------------------------------------------");

			System.out.println("Enter your choice:-> ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println(" Enter your PNR Number to fetch Ticket Details:-> ");
				String pnr_11 = scanner.next();
				ticketObj.showTicketByPNR(pnr_11);

				break;

			case 2:
				System.out.println(" Enter your Passenger Name to fetch Ticket Details:-> ");
				String psgrName = scanner.next();
				ticketObj.showTicketByName(psgrName);
				break;

			case 3:
				System.out.println(" Enter your Bus Number to fetch Ticket Details:-> ");
				String busNum_06 = scanner.next();
				ticketObj.showTicketByBus(busNum_06);
				break;
			case 4:
				List<Ticket> tickets = ticketObj.showAllTickets();
				for (Ticket ticket : tickets) {
					System.out.println(ticket);
				}
				break;

			case 5:
				adminMenu();
				break;

			default:
				System.out.println("  Choose valid option!!! ");

				viewBookingsMenu();

			}
		}
	}

	public static void main(String[] args) {
		welcomeScreen();
	}

}
