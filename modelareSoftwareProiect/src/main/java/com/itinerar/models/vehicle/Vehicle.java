package com.itinerar.models.vehicle;

import com.itinerar.models.parkingSlot.ParkingSlot;
/*
 * TO DO: sa stabilesti de la inceput care este dimensiunea fiecarui vehicul
 */
public class Vehicle {
	public int id;
	public final String number;
	public final String company;
	public String description;
	public final int dimensionSpotNeeded;
	
	
	
	public Vehicle(int id, String number, String company, String description,
			int dimensionSpotNeeded) {
		super();
		this.id = id;
		this.number = number;
		this.company = company;
		this.description = description;
		this.dimensionSpotNeeded = dimensionSpotNeeded;
	}

	public boolean canFit(ParkingSlot parkingSlot) {
		int dimension = parkingSlot.getParkingSlotType().getDimension();
		if(dimension - dimensionSpotNeeded == 0) {
			return true;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public String getCompany() {
		return company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDimensionSpotNeeded() {
		return dimensionSpotNeeded;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", number=" + number + ", company=" + company + ", description=" + description
				+ ", dimensionSpotNeeded=" + dimensionSpotNeeded + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + dimensionSpotNeeded;
		result = prime * result + id;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dimensionSpotNeeded != other.dimensionSpotNeeded)
			return false;
		if (id != other.id)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
}
