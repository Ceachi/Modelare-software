package com.itinerar.models.vehicle;

import com.itinerar.models.parkingSlot.ParkingSlot;

public class Bus extends Vehicle {

	public static final int DIMENSION = 8;
	public Bus(int id, String number, String company, String description) {
		super(id, number, company, description, DIMENSION);
	}

	@Override
	public boolean canFit(ParkingSlot parkingSlot) {
		int dimension = parkingSlot.getParkingSlotType().getDimension();
		if(dimension - dimensionSpotNeeded == 0) {
			return true;
		}
		return false;
	}

	public static int getDimension() {
		return DIMENSION;
	}
	
	

}
