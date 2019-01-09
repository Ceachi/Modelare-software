package modelareSoftware;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.itinerar.models.parkingSlot.LargeSpot;
import com.itinerar.models.parkingSlot.Obstacle;
import com.itinerar.models.parkingSlot.ParkingSlot;
import com.itinerar.models.parkingSlot.ParkingSlotComplex;
import com.itinerar.models.parkingSlot.SmallSpot;
import com.itinerar.models.parkingSpace.ParkingSpace;
import com.itinerar.models.parkingSpace.ParkingSpaceBuilder;
import com.itinerar.models.vehicle.Car;
import com.itinerar.models.vehicle.Vehicle;

public class ParkingSpaceTest {

	@Test
	// testing using ParkingSpace only with SmallSpots
	public void testingOnlyWithSmallSpots() {
		// creating the parkingSpace with only 1 row
		Map<Integer, List<ParkingSlot>> parkingSlotMap = new HashMap<>();
		List<ParkingSlot> row1ParkingSlot = new ArrayList<>();
		// first we create the row with some parkingSpots
		for (int i = 0; i <= 5; i++) {
			row1ParkingSlot.add(new ParkingSlot(i, new SmallSpot(), "small Spot", null, 2, true));
		}
		// then we add the list with ParkingSlots into the Map
		parkingSlotMap.put(1, row1ParkingSlot);

		// and now we use Builder Pattern to create a ParkingSpace
		ParkingSpace parkingSpace = new ParkingSpaceBuilder().setFloorNumber(1).setParkingName("AFI Cotroceni")
				.setParkingSlotMap(parkingSlotMap).setParkingSpaceType("DREPTUNGHIULAR").build();

		// client simulation for parking
		int vehicleDimension = 1;
		Vehicle car = new Car(1, null, null, null, vehicleDimension);
		boolean canPark = requestToPark(car, parkingSpace);
		System.out.println("Can the client park?");
		System.out.println(canPark);
		assertEquals(true, canPark);
	}

	@Test
	public void testingWithSmallSpotsAndLargeSpots() {
		// creating the parkingSpace
		Map<Integer, List<ParkingSlot>> parkingSlotMap = new HashMap<>();
		List<ParkingSlot> row1ParkingSlot = new ArrayList<>();
		for (int i = 0; i <= 2; i++) {
			row1ParkingSlot.add(new ParkingSlot(i, new SmallSpot(), "small Spot", null, 2, true));
		}

		row1ParkingSlot.add(new ParkingSlot(10, new LargeSpot(), "large Spot", null, 2, true));
		parkingSlotMap.put(1, row1ParkingSlot);

		ParkingSpace parkingSpace = new ParkingSpaceBuilder().setFloorNumber(1).setParkingName("AFI Cotroceni")
				.setParkingSlotMap(parkingSlotMap).setParkingSpaceType("DREPTUNGHIULAR").build();

		// client simulation for parking
		Vehicle car = new Car(1, null, null, null, 2);
		boolean canPark = requestToPark(car, parkingSpace);
		System.out.println("Can the client park?");
		System.out.println(canPark);
		assertEquals(true, canPark);
	}

	@Test
	public void testingComplexSpots() {
		// Creating the ParkingSpace
		Map<Integer, List<ParkingSlot>> parkingSlotMap = new HashMap<>();
		List<ParkingSlot> row1ParkingSlot = new ArrayList<>();
		row1ParkingSlot.add(new ParkingSlot(1, new SmallSpot(), "small Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(2, new LargeSpot(), "large Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(2, new Obstacle(), "obstacle Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(2, new LargeSpot(), "large Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(2, new LargeSpot(), "large Spot", null, 2, true));
		row1ParkingSlot.add(new ParkingSlot(1, new SmallSpot(), "small Spot", null, 2, true));

		parkingSlotMap.put(1, row1ParkingSlot);

		ParkingSpace parkingSpace = new ParkingSpaceBuilder().setFloorNumber(1).setParkingName("AFI Cotroceni")
				.setParkingSlotMap(parkingSlotMap).setParkingSpaceType("DREPTUNGHIULAR").build();

		Vehicle car = new Car(1, null, null, null, 5);
		boolean canPark = requestToPark(car, parkingSpace);
		System.out.println("Can the client park?");
		System.out.println(canPark);
		assertEquals(true, canPark);
	}

	ParkingSlotComplex searchForParkingSlotComplex(Vehicle vehicle, ParkingSpace parkingSpace) {
		ParkingSlotComplex complexParkingSlot = new ParkingSlotComplex();
		int vehicleDimension = vehicle.getDimensionSpotNeeded(); // din aceasta variabila o sa scad dimensiunea
		// incepem cautarea
		for (Map.Entry<Integer, List<ParkingSlot>> entry : parkingSpace.getParkingSlotMap().entrySet()) {
			List<ParkingSlot> parkingSlotList = entry.getValue();
			for (Iterator<ParkingSlot> iter = parkingSlotList.listIterator(); iter.hasNext();) {
				ParkingSlot slot = iter.next();
				int slotDimension = slot.getParkingSlotType().getDimension();
				if (slot.isAvailability() == true) {
					if (slotDimension <= vehicleDimension) {
						int dif = vehicleDimension - slotDimension;
						if (dif < 0) {
							vehicleDimension = vehicle.getDimensionSpotNeeded();
							complexParkingSlot = null; // am intalnit un obstacol sau diferenta nu se pliaza perfect
						} else if (dif == 0) { // am reusit sa gasesc un complexSpot
							complexParkingSlot.addSlot(slot);
							complexParkingSlot.setDimension(complexParkingSlot.getDimension() + slotDimension);
							return complexParkingSlot;
						} else {
							complexParkingSlot.addSlot(slot);
							complexParkingSlot.setDimension(complexParkingSlot.getDimension() + slotDimension);
							vehicleDimension = dif;
						}
					} else {
						vehicleDimension = vehicle.getDimensionSpotNeeded();
						complexParkingSlot.setComplexSlot(new ArrayList<>());
						complexParkingSlot.setDimension(0);
					}
				}
			}
		}
		return null;
	}

	boolean requestToPark(Vehicle vehicle, ParkingSpace parkingSpace) {
		if (vehicle.getDimensionSpotNeeded() > 2) {
			ParkingSlotComplex complexSlot = searchForParkingSlotComplex(vehicle, parkingSpace);
			if (complexSlot != null) {
				return true;
			}
		} else {
			ParkingSlot parkingSlot = searchForParkingSlot(vehicle, parkingSpace);
			if (parkingSlot != null) {
				return true;
			}
		}
		return false;
	}

	ParkingSlot searchForParkingSlot(Vehicle vehicle, ParkingSpace parkingSpace) {
		for(Map.Entry<Integer, List<ParkingSlot>> entry:parkingSpace.getParkingSlotMap().entrySet()) {
					List<ParkingSlot> parkingSlotList = entry.getValue();
					for (Iterator<ParkingSlot> iter = parkingSlotList.listIterator(); iter.hasNext();) {
						ParkingSlot slot = iter.next();
						if (slot.isAvailability() == true && vehicle.canFit(slot)) {
							slot.park(vehicle);
							System.out.println(slot);
							return slot;
						}
					}
		}
		return null;
	}
	
}
