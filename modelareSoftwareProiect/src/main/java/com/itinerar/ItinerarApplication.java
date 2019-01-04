package com.itinerar;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.itinerar.models.parkingSlot.ParkingSlot;
import com.itinerar.models.parkingSlot.ParkingSlotType;
import com.itinerar.models.parkingSlot.SmallSpot;
import com.itinerar.models.parkingSpace.*;
import com.itinerar.models.vehicle.Car;
import com.itinerar.models.vehicle.Vehicle;

@SpringBootApplication
public class ItinerarApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(ItinerarApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}


	/*
	 * @Override public void run(String... args) throws Exception { // creating the
	 * parkingSpace Map<Integer, List<ParkingSlot>> parkingSlotMap = new
	 * HashMap<>(); List<ParkingSlot> row1ParkingSlot = new ArrayList<>(); for(int i
	 * = 0; i <= 5; i++) { row1ParkingSlot.add(new ParkingSlot(1, new SmallSpot(),
	 * "small Spot", null, 2, true)); } parkingSlotMap.put(1, row1ParkingSlot);
	 * 
	 * ParkingSpace parkingSpace = new ParkingSpaceBuilder() .setFloorNumber(1)
	 * .setParkingName("AFI Cotroceni") .setParkingSlotMap(parkingSlotMap)
	 * .setParkingSpaceType("DREPTUNGHIULAR") .build();
	 * 
	 * 
	 * // client simulation for parking Vehicle car = new Car(1, null, null, null,
	 * 1); boolean canPark = requestToPark(car,parkingSpace);
	 * System.out.println("Can the client park?"); System.out.println(canPark);
	 * 
	 * }
	 */
	/*
	 * boolean requestToPark(Vehicle vehicle, ParkingSpace parkingSpace) {
	 * for(Map.Entry<Integer, List<ParkingSlot>> entry :
	 * parkingSpace.getParkingSlotMap().entrySet()) { List<ParkingSlot>
	 * parkingSlotList = entry.getValue(); // deleting the ParkingSlot from the list
	 * for(Iterator<ParkingSlot> iter = parkingSlotList.listIterator();
	 * iter.hasNext();) { ParkingSlot slot = iter.next(); if(slot.isAvailability()
	 * == true && vehicle.canFit(slot)) { slot.park(vehicle); return true; }
	 * 
	 * } }
	 * 
	 * return false; }
	 */
}
