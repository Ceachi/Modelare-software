package com.itinerar.models.parkingSlot;

import com.itinerar.models.vehicle.Vehicle;

public class ParkingSlot {
	private int id;
	private ParkingSlotType parkingSlotType;
	private String description;
	private Vehicle vehicle;
	public int pricePerHour;
	public boolean availability;
	
	
	public ParkingSlot() {
	}


	// TO DO: adauga un sistem de placa cu pricePerHour
	public ParkingSlot(int id, ParkingSlotType parkingSlotType, String description, Vehicle vehicle, int pricePerHour,
			boolean availability) {
		super();
		this.id = id;
		this.parkingSlotType = parkingSlotType;
		this.description = description;
		this.vehicle = vehicle;
		this.pricePerHour = pricePerHour;
		this.availability = availability;
	}
	
	public int getDimension() {
		return this.getParkingSlotType().getDimension();
	}
	
	public void park(Vehicle vehicle) {
		this.setVehicle(vehicle);
		this.setAvailability(false);
	}

	public boolean isAvailable() {
		return availability;
	}
	
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ParkingSlotType getParkingSlotType() {
		return parkingSlotType;
	}


	public void setParkingSlotType(ParkingSlotType parkingSlotType) {
		this.parkingSlotType = parkingSlotType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public int getPricePerHour() {
		return pricePerHour;
	}


	public void setPricePerHour(int pricePerHour) {
		this.pricePerHour = pricePerHour;
	}


	public boolean isAvailability() {
		return availability;
	}


	@Override
	public String toString() {
		return "ParkingSlot [id=" + id + ", parkingSlotType=" + parkingSlotType + ", description=" + description
				+ ", vehicle=" + vehicle + ", pricePerHour=" + pricePerHour + ", availability=" + availability + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (availability ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((parkingSlotType == null) ? 0 : parkingSlotType.hashCode());
		result = prime * result + pricePerHour;
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		ParkingSlot other = (ParkingSlot) obj;
		if (availability != other.availability)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (parkingSlotType == null) {
			if (other.parkingSlotType != null)
				return false;
		} else if (!parkingSlotType.equals(other.parkingSlotType))
			return false;
		if (pricePerHour != other.pricePerHour)
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}
	
	
}
