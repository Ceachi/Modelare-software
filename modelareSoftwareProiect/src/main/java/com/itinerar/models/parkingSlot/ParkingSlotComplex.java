package com.itinerar.models.parkingSlot;

import java.util.ArrayList;
import java.util.List;

import com.itinerar.models.vehicle.Vehicle;

public class ParkingSlotComplex {
	
	private int dimension;
	private List<ParkingSlot> complexSlot;

	public ParkingSlotComplex() {
		complexSlot = new ArrayList<>();
	}
	
	
	public ParkingSlotComplex(int dimension, List<ParkingSlot> complexSlot) {
		this.dimension = dimension;
		this.complexSlot = complexSlot;
	}
	
	public void addSlot(ParkingSlot slot) {
		complexSlot.add(slot);
	}
	public int getDimension() {
		return dimension;
	}
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	public List<ParkingSlot> getComplexSlot() {
		return complexSlot;
	}
	public void setComplexSlot(List<ParkingSlot> complexSlot) {
		this.complexSlot = complexSlot;
	}
	@Override
	public String toString() {
		return "ParkingSlotComplex [dimension=" + dimension + ", complexSlot=" + complexSlot + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complexSlot == null) ? 0 : complexSlot.hashCode());
		result = prime * result + dimension;
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
		ParkingSlotComplex other = (ParkingSlotComplex) obj;
		if (complexSlot == null) {
			if (other.complexSlot != null)
				return false;
		} else if (!complexSlot.equals(other.complexSlot))
			return false;
		if (dimension != other.dimension)
			return false;
		return true;
	}
	
	
}
