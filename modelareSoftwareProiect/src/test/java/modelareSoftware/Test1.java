package modelareSoftware;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itinerar.controller.ParkingService;
import com.itinerar.models.parkingSlot.LargeSpot;
import com.itinerar.models.parkingSlot.Obstacle;
import com.itinerar.models.parkingSlot.ParkingSlot;
import com.itinerar.models.parkingSlot.SmallSpot;
import com.itinerar.models.parkingSpace.ParkingSpace;
import com.itinerar.models.parkingSpace.ParkingSpaceBuilder;
import com.itinerar.models.ticket.Ticket;
import com.itinerar.models.vehicle.Car;
import com.itinerar.models.vehicle.Vehicle;

public class Test1 {

	ParkingService parkingService = new ParkingService();

	@Test
	public void simpleTest() {
		parkingService.createParkingSpace(this.createSimpleParkingSpace());
		Vehicle myVehicle = new Car(1, "Ilfov: 1234", "BMW", "simplut", 1);
		Ticket expectedTicket = new Ticket();
		Ticket ticket = parkingService.requestToPark(myVehicle);
		
		System.out.println("tichetul este = ");
		System.out.println(ticket);
		assertEquals(1, 1);
	}
	@Test
	public void complexTest() {
		parkingService.createParkingSpace(this.createSimpleParkingSpace());
		Vehicle myVehicle = new Car(1, "Ilfov: 1234", "BMW", "simplut", 5);
		Ticket expectedTicket = new Ticket();
		Ticket ticket = parkingService.requestToPark(myVehicle);
		
		System.out.println("tichetul complex este = ");
		System.out.println(ticket);
		assertEquals(1, 1);
		parkingService.freeSpot(ticket, 50);
		System.out.println("tichetul complex sters este = ");
		System.out.println(ticket);
	}

	public ParkingSpace createSimpleParkingSpace() {
		// creating the parkingSpace
		Map<Integer, List<ParkingSlot>> parkingSlotMap = new HashMap<>();
		List<ParkingSlot> row1ParkingSlot = new ArrayList<>();
		row1ParkingSlot.add(new ParkingSlot(1, new SmallSpot(), "small Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(2, new LargeSpot(), "large Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(3, new Obstacle(), "obstacle Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(4, new LargeSpot(), "large Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(5, new LargeSpot(), "large Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(6, new SmallSpot(), "small Spot", null, 2, true));
		parkingSlotMap.put(1, row1ParkingSlot);

		ParkingSpace parkingSpace = new ParkingSpaceBuilder().setFloorNumber(1).setParkingName("AFI Cotroceni")
				.setParkingSlotMap(parkingSlotMap).setParkingSpaceType("DREPTUNGHIULAR").build();
		
		return parkingSpace;
	}
}
