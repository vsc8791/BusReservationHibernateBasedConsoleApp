package com.firstbit.dao;

import java.util.List;

import com.firstbit.models.Bus;
import com.firstbit.models.Ticket;

public interface TicketDAO {

	void generateTicket(Ticket ticket);

	void cancelBookedTicket(String pnrNumber);

	Ticket editTicket(String pnrNumber);

	Ticket showTicketByPNR(String pnrNumber);

	Ticket showTicketByName(String passengerName);

	Ticket showTicketByBus(String busNumber);

	List<Ticket> showAllTickets();

}
