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
	private String parkingSpaceType;
	
	
	
	public ParkingSpace() {
		super();
	}

	public ParkingSpace(String parkingName, int floorNumber, Map<Integer, List<ParkingSlot>> parkingSlotMap,
			String parkingSpaceType) {
		super();
		this.parkingName = parkingName;
		this.floorNumber = floorNumber;
		this.parkingSlotMap = parkingSlotMap;
		this.parkingSpaceType = parkingSpaceType;
	}

	public void addParkingSlot(int rowNumber, ParkingSlot parkingSlot) {
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

	public String getParkingSpaceType() {
		return parkingSpaceType;
	}

	public void setParkingSpaceType(String parkingSpaceType) {
		this.parkingSpaceType = parkingSpaceType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floorNumber;
		result = prime * result + ((parkingName == null) ? 0 : parkingName.hashCode());
		result = prime * result + ((parkingSlotMap == null) ? 0 : parkingSlotMap.hashCode());
		result = prime * result + ((parkingSpaceType == null) ? 0 : parkingSpaceType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingSpace other = (ParkingSpace) obj;
		if (floorNumber != other.floorNumber)
			return false;
		if (parkingName == null) {
			if (other.parkingName != null)
				return false;
		} else if (!parkingName.equals(other.parkingName))
			return false;
		if (parkingSlotMap == null) {
			if (other.parkingSlotMap != null)
				return false;
		} else if (!parkingSlotMap.equals(other.parkingSlotMap))
			return false;
		if (parkingSpaceType == null) {
			if (other.parkingSpaceType != null)
				return false;
		} else if (!parkingSpaceType.equals(other.parkingSpaceType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParkingSpace [parkingName=" + parkingName + ", floorNumber=" + floorNumber + ", parkingSlotMap="
				+ parkingSlotMap + ", parkingSpaceType=" + parkingSpaceType + "]";
	}
	
	
	
	
}
