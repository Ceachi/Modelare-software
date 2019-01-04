package com.itinerar.models.ticket;

import com.itinerar.models.parkingSlot.ParkingSlot;
import com.itinerar.models.parkingSlot.ParkingSlotComplex;
import com.itinerar.models.parkingSpace.ParkingSpace;
import com.itinerar.models.vehicle.Vehicle;

public class Ticket {
	
	public Vehicle vehicle;
	public ParkingSlot parkingSlot;
	public ParkingSlotComplex parkingSlotComplex;
	public ParkingSpace parkingSpace;
	public boolean paid;
	public int money;
	
	
	public ParkingSlotComplex getParkingSlotComplex() {
		return parkingSlotComplex;
	}
	public Ticket setParkingSlotComplex(ParkingSlotComplex parkingSlotComplex) {
		this.parkingSlotComplex = parkingSlotComplex;
		return this;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public Ticket setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}
	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}
	public Ticket setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
		return this;
	}
	public boolean isPaid() {
		return paid;
	}
	public Ticket setPaid(boolean paid) {
		this.paid = paid;
		return this;
	}
	public int getMoney() {
		return money;
	}
	public Ticket setMoney(int money) {
		this.money = money;
		return this;
	}
	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}
	public Ticket setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
		return this;
	}
	@Override
	public String toString() {
		return "Ticket [vehicle=" + vehicle + ", parkingSlot=" + parkingSlot + ", parkingSlotComplex="
				+ parkingSlotComplex + ", parkingSpace=" + parkingSpace + ", paid=" + paid + ", money=" + money + "]";
	}
	
	
	
	
}
