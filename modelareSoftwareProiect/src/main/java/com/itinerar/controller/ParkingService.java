package com.itinerar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.itinerar.models.parkingSlot.ParkingSlot;
import com.itinerar.models.parkingSlot.ParkingSlotComplex;
import com.itinerar.models.parkingSpace.*;
import com.itinerar.models.ticket.Ticket;
import com.itinerar.models.vehicle.Vehicle;;

@Component
public class ParkingService {

	public List<ParkingSpace> parkingSpaceList;
	
	

	public ParkingService() {
		this.parkingSpaceList = new ArrayList<>();
	}

	public Ticket requestToPark(Vehicle vehicle) {
		ParkingSpace parkingSpace = parkingSpaceList.get(0); // cautam in primul space
		ParkingSlotComplex complexSlot = null;
		ParkingSlot parkingSlot = null;
		if (vehicle.getDimensionSpotNeeded() > 2) {
			complexSlot = searchForFreeParkingSlotComplex(vehicle, parkingSpace);
		} else {
			parkingSlot = searchForFreeParkingSlot(vehicle, parkingSpace);
		}
		Ticket ticket = new Ticket();// creem tichetul

		if (complexSlot != null) {
			int money = 10 * complexSlot.getDimension();
			ticket.setMoney(money).setPaid(false).setParkingSlotComplex(complexSlot).setVehicle(vehicle)
					.setParkingSpace(parkingSpace);
			return ticket;
		} else if (parkingSlot != null) {
			int money = 10 * parkingSlot.getDimension(); // TO DO: adauga un sistem de placa cu pricePerHour
			ticket.setMoney(money).setPaid(false).setParkingSlotComplex(complexSlot).setVehicle(vehicle)
					.setParkingSpace(parkingSpace);
			return ticket;
		}
		return ticket;
	}

	public Ticket freeSpot(Ticket ticket, int money) {
		ParkingSlotComplex parkingSlotComplex = ticket.getParkingSlotComplex();
		ParkingSlot parkingSlot = ticket.getParkingSlot();
		ParkingSpace parkingSpace = ticket.getParkingSpace();

		if (ticket.getMoney() - money == 0 && ticket.isPaid() == false) {
			if (parkingSlotComplex != null) {
				// parcurgem parcarea
				for (Map.Entry<Integer, List<ParkingSlot>> entry : parkingSpace.getParkingSlotMap().entrySet()) {
					List<ParkingSlot> parkingSlotList = entry.getValue();// luam toate space-urile de pe fiecare rand
					if (parkingSlotComplex.getComplexSlot().isEmpty()) {
						break;
					}
					// si verificam daca le avem in obiectul parkingSlotComplex
					for (Iterator<ParkingSlot> complexIterator = parkingSlotComplex.getComplexSlot()
							.listIterator(); complexIterator.hasNext();) {
						ParkingSlot complexItem = complexIterator.next();
						for (Iterator<ParkingSlot> slotIterator = parkingSlotList.listIterator(); slotIterator
								.hasNext();) {
							ParkingSlot slot = slotIterator.next();
							if (slot == complexItem) {
								slot.setVehicle(null);
								slot.setAvailability(true);
								complexIterator.remove();
							}
						}
					}

				}
			} else if (parkingSlot != null) {
				for (Map.Entry<Integer, List<ParkingSlot>> entry : parkingSpace.getParkingSlotMap().entrySet()) {
					for (Iterator<ParkingSlot> slotIterator = entry.getValue().listIterator(); slotIterator
							.hasNext();) {
						ParkingSlot slot = slotIterator.next();
						if (parkingSlot == slot) {
							slot.setVehicle(null);
							slot.setAvailability(true);
							break;
						}
					}
				}
			}
			ticket.setPaid(true);
		}
		return ticket;
	}

	public void createParkingSpace(ParkingSpace parkingSpace) {
		parkingSpaceList.add(parkingSpace);
	}

	ParkingSlot searchForFreeParkingSlot(Vehicle vehicle, ParkingSpace parkingSpace) {
		for (Map.Entry<Integer, List<ParkingSlot>> entry : parkingSpace.getParkingSlotMap().entrySet()) {
			List<ParkingSlot> parkingSlotList = entry.getValue();
			for (Iterator<ParkingSlot> iter = parkingSlotList.listIterator(); iter.hasNext();) {
				ParkingSlot slot = iter.next();
				if (slot.isAvailability() == true && vehicle.canFit(slot)) {
					slot.park(vehicle);
					System.out.println(slot);
					return slot;
				}
			}
		}
		return null;
	}

	ParkingSlotComplex searchForFreeParkingSlotComplex(Vehicle vehicle, ParkingSpace parkingSpace) {
		ParkingSlotComplex complexParkingSlot = new ParkingSlotComplex();
		int vehicleDimension = vehicle.getDimensionSpotNeeded(); // din aceasta variabila o sa scad dimensiunea
		// incepem cautarea
		for (Map.Entry<Integer, List<ParkingSlot>> entry : parkingSpace.getParkingSlotMap().entrySet()) {
			List<ParkingSlot> parkingSlotList = entry.getValue();
			for (Iterator<ParkingSlot> iter = parkingSlotList.listIterator(); iter.hasNext();) {
				ParkingSlot slot = iter.next();
				int slotDimension = slot.getParkingSlotType().getDimension();
				if (slot.isAvailability() == true) {
					if (slotDimension <= vehicleDimension) {
						int dif = vehicleDimension - slotDimension;
						if (dif < 0) {
							vehicleDimension = vehicle.getDimensionSpotNeeded();
							complexParkingSlot = null; // am intalnit un obstacol sau diferenta nu se pliaza perfect
						} else if (dif == 0) { // am reusit sa gasesc un complexSpot
							complexParkingSlot.addSlot(slot);
							complexParkingSlot.setDimension(complexParkingSlot.getDimension() + slotDimension);
							return complexParkingSlot;
						} else {
							complexParkingSlot.addSlot(slot);
							complexParkingSlot.setDimension(complexParkingSlot.getDimension() + slotDimension);
							vehicleDimension = dif;
						}
					} else {
						vehicleDimension = vehicle.getDimensionSpotNeeded();
						complexParkingSlot.setComplexSlot(new ArrayList<>());
						complexParkingSlot.setDimension(0);
					}
				}
			}
		}
		return null;
	}
}
