package com.itinerar.models.parkingSpace;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.itinerar.exception.RowNotFoundException;
import com.itinerar.models.parkingSlot.ParkingSlot;

public class ParkingSpace {
	
	private String parkingName;
	private int floorNumber;
	private Map<Integer, List<ParkingSlot>> parkingSlotMap;
	private ParkingSpaceType parkingSpaceType;
	
	
	
	public ParkingSpace() {
		super();
	}

	public ParkingSpace(String parkingName, int floorNumber, Map<Integer, List<ParkingSlot>> parkingSlotMap,
			ParkingSpaceType parkingSpaceType) {
		super();
		this.parkingName = parkingName;
		this.floorNumber = floorNumber;
		this.parkingSlotMap = parkingSlotMap;
		this.parkingSpaceType = parkingSpaceType;
	}

	public void addParkingSlot(int rowNumber, ParkingSlot parkingSlot) {
		ParkingSpaceType parkingSpacetype = this.getParkingSpaceType();
		ParkingSpaceType DREPTUNGHIULAR = ParkingSpaceType.DREPTUNGHIULAR;
		ParkingSpaceType CIRCLE = ParkingSpaceType.DREPTUNGHIULAR;
		ParkingSpaceType SQUARE = ParkingSpaceType.SQUARE;
		if(parkingSpacetype.equals(DREPTUNGHIULAR) && (rowNumber >= 1 && rowNumber <= 2)) {
				throw new RowNotFoundException("row not found");
		}else if(parkingSpacetype.equals(CIRCLE) && (rowNumber != 1) ) {
				throw new RowNotFoundException("row not found");
		}
		if((rowNumber >= 1 && rowNumber <= 2)) 
			throw new RowNotFoundException("row not found");
		
		List<ParkingSlot> parkingSlotList = parkingSlotMap.get(rowNumber);
		parkingSlotList.add(parkingSlot);
		
		parkingSlotMap.put(rowNumber, parkingSlotList);
	}
	public void deleteParkingSlot(int rowNumber, ParkingSlot parkingSlot) {
		if((rowNumber >= 1 && rowNumber <= 2)) 
			throw new RowNotFoundException("row not found");
		for(Map.Entry<Integer, List<ParkingSlot>> entry : parkingSlotMap.entrySet()) {
			List<ParkingSlot> parkingSlotList = entry.getValue();
			// deleting the ParkingSlot from the list
			for(Iterator<ParkingSlot> iter = parkingSlotList.listIterator(); iter.hasNext();) {
				ParkingSlot slot = iter.next();
				if(slot.equals(parkingSlot)) {
					iter.remove();
				}
			}
			parkingSlotMap.put(rowNumber, parkingSlotList);
		}
	}

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Map<Integer, List<ParkingSlot>> getParkingSlotMap() {
		return parkingSlotMap;
	}

	public void setParkingSlotMap(Map<Integer, List<ParkingSlot>> parkingSlotMap) {
		this.parkingSlotMap = parkingSlotMap;
	}

	public ParkingSpaceType getParkingSpaceType() {
		return parkingSpaceType;
	}

	public void setParkingSpaceType(ParkingSpaceType parkingSpaceType) {
		this.parkingSpaceType = parkingSpaceType;
	}

	

	@Override
	public String toString() {
		return "ParkingSpace [parkingName=" + parkingName + ", floorNumber=" + floorNumber + ", parkingSlotMap="
				+ parkingSlotMap + ", parkingSpaceType=" + parkingSpaceType + "]";
	}
	
	
	
	
}
