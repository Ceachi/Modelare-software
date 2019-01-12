package com.itinerar.models.vehicle;

import com.itinerar.models.parkingSlot.ParkingSlot;

/**
 * This can be any Car of type Vehicle
 * @author Ceachi Bogdan
 *
 */
public class Car extends Vehicle {

	public Car(int id, String number, String company, String description, int dimensionSpotNeeded) {
		super(id, number, company, description, dimensionSpotNeeded);
	}

	@Override
	public boolean canFit(ParkingSlot parkingSlot) {
		int dimension = parkingSlot.getParkingSlotType().getDimension();
		if(dimension - dimensionSpotNeeded == 0) {
			return true;
		}
		return false;
	}

}
