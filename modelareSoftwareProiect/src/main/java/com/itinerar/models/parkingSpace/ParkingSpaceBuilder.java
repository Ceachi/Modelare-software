package com.itinerar.models.parkingSpace;

import java.util.List;
import java.util.Map;

import com.itinerar.models.parkingSlot.ParkingSlot;

public class ParkingSpaceBuilder {
	
	private String parkingName;
	private int floorNumber;
	private Map<Integer, List<ParkingSlot>> parkingSlotMap;
	private ParkingSpaceType parkingSpaceType;
	
	public ParkingSpaceBuilder setParkingName(String parkingName) {
		this.parkingName = parkingName;
		return this;
	}

	public ParkingSpaceBuilder setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
		return this;
	}


	public ParkingSpaceBuilder setParkingSlotMap(Map<Integer, List<ParkingSlot>> parkingSlotMap) {
		this.parkingSlotMap = parkingSlotMap;
		return this;
	}

	public ParkingSpaceBuilder setParkingSpaceType(ParkingSpaceType parkingSpaceType) {
		this.parkingSpaceType = parkingSpaceType;
		return this;
	}
	
	public ParkingSpace build() {
		return new ParkingSpace(parkingName, floorNumber, parkingSlotMap, parkingSpaceType);
	}

}
