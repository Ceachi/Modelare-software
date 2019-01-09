package com.itinerar.facade;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.itinerar.models.parkingSpace.ParkingSpace;
import com.itinerar.models.ticket.Ticket;
import com.itinerar.models.vehicle.Vehicle;
import com.itinerar.service.ParkingService;

@Controller
public class ParkingServiceController {
	
	private static ParkingServiceController instance;
	public ParkingService parkingService = ParkingService.getInstance(); // i know i can use @Autowired
	
	private  ParkingServiceController() {
	}
	
	public static synchronized ParkingServiceController getInstance() {
		if(instance == null) {
			instance = new ParkingServiceController();
		}
		return instance;
	}


	public Ticket requestToPark(Vehicle vehicle) {
		return parkingService.requestToPark(vehicle);
	}

	public Ticket freeSpot(Ticket ticket, int money) {
		return parkingService.freeSpot(ticket, money);
	}
	
	public void createParkingSpace(ParkingSpace parkingSpace) {
		parkingService.createParkingSpace(parkingSpace);
	}


	public ParkingService getParkingService() {
		return parkingService;
	}


	public void setParkingService(ParkingService parkingService) {
		this.parkingService = parkingService;
	}
	
	
	
	
}
