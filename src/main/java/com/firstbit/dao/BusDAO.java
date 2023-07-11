package com.firstbit.dao;

import java.util.List;

import com.firstbit.models.Bus;

public interface BusDAO {
	
	void addBus(Bus bus);

	Bus viewBusDetails(String busNumber);

	List<Bus> showBusesDetails();

	void editBus(String busNumber);

	void deleteBus(String busNumber);

}
