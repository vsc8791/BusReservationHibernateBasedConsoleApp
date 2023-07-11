package com.firstbit.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.firstbit.models.Bus;
import com.firstbit.models.Ticket;
import com.firstbit.utils.HibernateUtils;

public class TicketDAOImpl implements TicketDAO {

	Session session = HibernateUtils.getSession();
	Scanner scanner = new Scanner(System.in);

	@Override
	public void cancelBookedTicket(String pnrNumber) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Ticket ticket = showTicketByPNR(pnrNumber);
		session.remove(ticket);
		Bus bus = new BusDAOImpl().viewBusDetails(ticket.getLinkedBusNumber());
		new BusDAOImpl().changeRemainingSeatsCountOfBus(ticket.getLinkedBusNumber(),
				bus.getRemainingSeats() + ticket.getNumberOfSeatsToBeBooked(),
				bus.getBookedSeats() - ticket.getNumberOfSeatsToBeBooked());
		transaction.commit();
		session.close();
	}

	@Override
	public Ticket editTicket(String pnrNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket showTicketByPNR(String pnrNumber) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Ticket where pnrNumber=:pnrNumber");
		query.setParameter("pnrNumber", pnrNumber);
		Ticket ticket = (Ticket) query.uniqueResult();
		display(ticket);
		transaction.commit();
		session.close();
		return ticket;
	}

	@Override
	public Ticket showTicketByName(String passengerName) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Ticket where passengerName=:passengerName");
		query.setParameter("passengerName", passengerName);
		Ticket ticket = (Ticket) query.uniqueResult();
		display(ticket);
		transaction.commit();
		session.close();
		return ticket;
	}

	@Override
	public Ticket showTicketByBus(String busNumber) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Ticket where busNumber=:busNumber");
		query.setParameter("busNumber", busNumber);
		Ticket ticket = (Ticket) query.uniqueResult();
		display(ticket);
		transaction.commit();
		session.close();
		return ticket;
	}

	@Override
	public List<Ticket> showAllTickets() {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).getResultList();
		tickets.forEach(ticket -> display(ticket));
		transaction.commit();
		session.close();
		return tickets;
	}

	public void display(Ticket ticket) {
		System.out.println("-------------------------------------------------");
		System.out.println(" PNR Number:-> " + ticket.getPnrNumber());
		System.out.println("Passenger Name:-> " + ticket.getPassengerName());
		System.out.println("Passenger Age:-> " + ticket.getPassengerAge());
		System.out.println("Passenger Gender:-> " + ticket.getPassengerGender());
		System.out.println("Date of Journey:-> " + ticket.getDateOfJourney());
		System.out.println("Date of Booking:-> " + ticket.getDateOfBooking());
		BusDAO buses = new BusDAOImpl();
		Bus bus = buses.viewBusDetails(ticket.getLinkedBusNumber());
		System.out.println(" Source:-> " + bus.getSource());
		System.out.println(" Destination:-> " + bus.getDestination());
		System.out.println(" Time:-> " + bus.getSourceTime() + " - " + bus.getDestinationTime());
		System.out.println("Fare/Passenger:-> " + bus.getBusFare());
		System.out.println("Number of Seats Booked:-> " + ticket.getNumberOfSeatsToBeBooked());

		System.out.println("-------------------------------------------------");
	}

	@Override
	public void generateTicket(Ticket ticket) {

		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(ticket);
		Bus bus = new BusDAOImpl().viewBusDetails(ticket.getLinkedBusNumber());
		new BusDAOImpl().changeRemainingSeatsCountOfBus(ticket.getLinkedBusNumber(),
				bus.getRemainingSeats() - ticket.getNumberOfSeatsToBeBooked(), ticket.getNumberOfSeatsToBeBooked());
		transaction.commit();
		session.close();

	}

}
