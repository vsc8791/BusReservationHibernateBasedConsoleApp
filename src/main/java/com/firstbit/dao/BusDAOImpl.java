package com.firstbit.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.firstbit.models.Bus;
import com.firstbit.objectfactory.BusObjectFactory;
import com.firstbit.utils.HibernateUtils;

public class BusDAOImpl implements BusDAO {

	Scanner scanner = new Scanner(System.in);

	@Override
	public void addBus(Bus bus) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(bus);
		transaction.commit();
		session.close();
	}

	@Override
	public Bus viewBusDetails(String busNumber) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Bus where busNumber=:busNumber");
		query.setParameter("busNumber", busNumber);
		Bus bus = (Bus) query.uniqueResult();
		display(bus);
		transaction.commit();
		session.close();
		return bus;
	}

	public void display(Bus bus) {
		System.out.println("-------------------------------------------------");
		System.out.println(" Bus No:-> " + bus.getBusNumber());
		System.out.println(" Source:-> " + bus.getSource());
		System.out.println(" Destination:-> " + bus.getDestination());
		System.out.println(" Time:-> " + bus.getSourceTime() + " - " + bus.getDestinationTime());
		System.out.println(" Total Seats:-> " + bus.getMaxSeats());
		System.out.println(" Seats Remaining:-> " + (bus.getMaxSeats() - bus.getBookedSeats()));
		System.out.println(" Bus Fare:-> " + bus.getBusFare());
		System.out.println("-------------------------------------------------");
	}

	@Override
	public List<Bus> showBusesDetails() {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		List<Bus> buses = session.createQuery("from Bus", Bus.class).getResultList();
		buses.forEach(bus -> display(bus));
		transaction.commit();
		session.close();
		return buses;
	}

	@Override
	public void deleteBus(String busNumber) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Bus bus = viewBusDetails(busNumber);
		session.remove(bus);
		transaction.commit();
		session.close();
	}

	@Override
	public void editBus(String busNumber) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Bus bus = viewBusDetails(busNumber);
		Bus newBus = BusObjectFactory.updateBusObject(bus);
		session.update(newBus);
		transaction.commit();
		session.close();
	}

	public void changeRemainingSeatsCountOfBus(String busNumber, Integer remainingSeats, Integer bookedSeats) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Bus bus = viewBusDetails(busNumber);
		bus.setRemainingSeats(remainingSeats);
		bus.setBookedSeats(bookedSeats);
		session.update(bus);
		transaction.commit();
		session.close();
	}
}
