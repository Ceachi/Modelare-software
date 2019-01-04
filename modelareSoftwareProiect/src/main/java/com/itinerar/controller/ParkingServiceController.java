package com.itinerar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itinerar.models.parkingSpace.ParkingSpace;
import com.itinerar.models.ticket.Ticket;
import com.itinerar.models.vehicle.Vehicle;

@Controller
public class ParkingServiceController {

	@Autowired
	public ParkingService parkingService;

	public Ticket requestToPark(Vehicle vehicle) {
		return parkingService.requestToPark(vehicle);
	}

	public Ticket freeSpot(Ticket ticket, int money) {
		return parkingService.freeSpot(ticket, money);
	}
	
	public void createParkingSpace(ParkingSpace parkingSpace) {
		parkingService.createParkingSpace(parkingSpace);
	}

}
