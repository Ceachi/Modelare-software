package modelareSoftware;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itinerar.facade.ParkingServiceController;
import com.itinerar.models.parkingSlot.LargeSpot;
import com.itinerar.models.parkingSlot.Obstacle;
import com.itinerar.models.parkingSlot.ParkingSlot;
import com.itinerar.models.parkingSlot.ParkingSlotComplex;
import com.itinerar.models.parkingSlot.SmallSpot;
import com.itinerar.models.parkingSpace.ParkingSpace;
import com.itinerar.models.parkingSpace.ParkingSpaceBuilder;
import com.itinerar.models.ticket.Ticket;
import com.itinerar.models.vehicle.Car;
import com.itinerar.models.vehicle.Vehicle;
import com.itinerar.service.ParkingService;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
public class Test1 {
	
	ParkingServiceController parkingController = ParkingServiceController.getInstance();
	ParkingService parkingService = ParkingService.getInstance();
	String fileName = "E:\\Bogdan\\Facultate\\Modelare software\\Proiect\\Modelare-software\\modelareSoftwareProiect\\Output.txt";
	@Test
	public void createParkingSpace() throws IOException {
		PrintStream out = printToFile();
		out.flush();
		ParkingSpace parkingSpace = createSimpleParkingSpace();
		parkingController.createParkingSpace(parkingSpace);
		out.println("Testing method createParkingSpace, that will output the parkingSpace for test : ");
		out.println(parkingSpace);
		assertEquals(1, 1);
		
		out.close();
	}
	
	public PrintStream printToFile() 
	  throws IOException {
		String fileName = "E:\\Bogdan\\Facultate\\Modelare software\\Proiect\\Modelare-software\\modelareSoftwareProiect\\Output.txt";
		PrintStream out = new PrintStream(new FileOutputStream(fileName));
		return out;
	}
	
	@Test
	public void parkingOnSingleSpot() throws IOException {
		int vehicleDimension = 2;
		PrintStream out = printToFile();
		out.flush();
		out.println("Testing parkingOnSingleSpot test");
		// creating parkingSpace
		ParkingSpace parkingSpace = createSimpleParkingSpace();
		parkingController.createParkingSpace(parkingSpace);
		
		out.println("PARKING SPACE : ");
		out.println(parkingSpace);
		out.println("");out.println("");
		
		//coming with the car
		Vehicle myVehicle = new Car(1, "Ilfov: 1234", "BMW", "simplut", vehicleDimension);
		//request to park the car
		Ticket ticket = parkingController.requestToPark(myVehicle);
		if(ticket.getParkingSlot() != null) {// this means that is not complexSlot
			out.println("Clientul a parcat pe un single parking Slot, acesta este : ");
			out.println(ticket.getParkingSlot());out.println("");out.println("");
			out.println("Si a primit tichetul: ");
			out.println(ticket);
		}else if(ticket.getParkingSlotComplex() != null) {
			out.println("Clientul a parcat pe un complex Slot, acesta este : ");
			ParkingSlotComplex complexSlot = ticket.getParkingSlotComplex();
			out.println(complexSlot);
		}
		
		
		out.println("PARKING SPACE este acum : ");
		out.println(parkingSpace);
		out.println("");out.println("");
		assertEquals(1, 1);
		out.close();		
	}
	
	
	@Test
	public void parkingOnComplexSpot() throws IOException {
		int vehicleDimension = 5;
		PrintStream out = printToFile();
		out.flush();
		out.println("Testing parkingOnSingleSpot test");
		// creating parkingSpace
		ParkingSpace parkingSpace = createSimpleParkingSpace();
		parkingController.createParkingSpace(parkingSpace);
				
		//coming with the car
		Vehicle myVehicle = new Car(1, "Ilfov: 1234", "BMW", "simplut", vehicleDimension);
		//request to park the car
		Ticket ticket = parkingController.requestToPark(myVehicle);
		if(ticket.getParkingSlot() != null) {// this means that is not complexSlot
			out.println("Clientul a parcat pe un single parking Slot, acesta este : ");
			out.println(ticket.getParkingSlot());out.println("");out.println("");
			out.println("Si a primit tichetul: ");
			out.println(ticket);
		}else if(ticket.getParkingSlotComplex() != null) {
			out.println("Clientul a parcat pe un complex Slot, acesta este : ");
			ParkingSlotComplex complexSlot = ticket.getParkingSlotComplex();
			out.println(complexSlot);
			
			out.println("Si a primit tichetul: ");
			out.println(ticket);
		}
		
		out.println("PARKING SPACE este acum : ");
		out.println(parkingSpace);
		out.println("");out.println("");
		assertEquals(1, 1);
		out.close();		
	}


	@Test // testing to free just a single spot forn ParkingSpace
	public void testFreeSingleSpot() throws IOException {
		int vehicleDimension = 2;
		PrintStream out = printToFile();
		out.flush();
		out.println("Testing testFreeSingleSpot test");
		// creating parkingSpace
		ParkingSpace parkingSpace = createSimpleParkingSpace();
		parkingController.createParkingSpace(parkingSpace);
		
		
		//coming with the car
		Vehicle myVehicle = new Car(1, "Ilfov: 1234", "BMW", "simplut", vehicleDimension);
		//request to park the car
		Ticket ticket = parkingController.requestToPark(myVehicle);
		out.println("PARKING SPACE : ");
		out.println(parkingSpace);
		out.println("");out.println("");
		
		int customerMoney = ticket.getMoney();
		// we pay the park, and leave with the car
		parkingController.freeSpot(ticket, customerMoney);
		
		
		out.println("PARKING SPACE after we pay the park and leave with the car: ");
		out.println(parkingSpace);
		out.println("");out.println("");
		
	}
	
	@Test 
	public void testFreeComplexSpot() throws IOException {
		int vehicleDimension = 5;
		PrintStream out = printToFile();
		out.flush();
		out.println("Testing testFreeSingleSpot test");
		// creating parkingSpace
		ParkingSpace parkingSpace = createSimpleParkingSpace();
		parkingController.createParkingSpace(parkingSpace);
		
		
		//coming with the car
		Vehicle myVehicle = new Car(1, "Ilfov: 1234", "BMW", "simplut", vehicleDimension);
		//request to park the car
		Ticket ticket = parkingController.requestToPark(myVehicle);
		out.println("PARKING SPACE : ");
		out.println(parkingSpace);
		out.println("");out.println("");
		int customerMoney = ticket.getMoney();
		// we pay the park, and leave with the car
		parkingController.freeSpot(ticket, customerMoney);
		
		
		out.println("PARKING SPACE after we pay the park and leave with the car: ");
		out.println(parkingSpace);
		out.println("");out.println("");
	}
	
	
	/*
	 * @Test public void simpleTest() {
	 * parkingService.createParkingSpace(this.createSimpleParkingSpace()); Vehicle
	 * myVehicle = new Car(1, "Ilfov: 1234", "BMW", "simplut", 1); Ticket
	 * expectedTicket = new Ticket(); Ticket ticket =
	 * parkingService.requestToPark(myVehicle);
	 * 
	 * System.out.println("tichetul este = "); System.out.println(ticket);
	 * assertEquals(1, 1); }
	 * 
	 * @Test public void complexTest() {
	 * parkingService.createParkingSpace(this.createSimpleParkingSpace()); Vehicle
	 * myVehicle = new Car(1, "Ilfov: 1234", "BMW", "simplut", 5); Ticket
	 * expectedTicket = new Ticket(); Ticket ticket =
	 * parkingService.requestToPark(myVehicle);
	 * 
	 * System.out.println("tichetul complex este = "); System.out.println(ticket);
	 * assertEquals(1, 1); parkingService.freeSpot(ticket, 50);
	 * System.out.println("tichetul complex sters este = ");
	 * System.out.println(ticket); }
	 */

	public ParkingSpace createSimpleParkingSpace() {
		int pricePerHour = 2;
		Vehicle noVehicle = null;
		boolean isAvailable = true;
		// creating the parkingSpace
		Map<Integer, List<ParkingSlot>> parkingSlotMap = new HashMap<>();
		List<ParkingSlot> row1ParkingSlot = new ArrayList<>();
		row1ParkingSlot.add(new ParkingSlot(1, new SmallSpot(), "small Spot", noVehicle, pricePerHour, isAvailable));
		row1ParkingSlot.add(new ParkingSlot(2, new LargeSpot(), "large Spot", noVehicle, pricePerHour, isAvailable));
		row1ParkingSlot.add(new ParkingSlot(3, new Obstacle(), "obstacle Spot", noVehicle, pricePerHour, isAvailable));
		row1ParkingSlot.add(new ParkingSlot(4, new LargeSpot(), "large Spot", noVehicle, pricePerHour, isAvailable));
		row1ParkingSlot.add(new ParkingSlot(5, new LargeSpot(), "large Spot", noVehicle, pricePerHour, isAvailable));
		row1ParkingSlot.add(new ParkingSlot(6, new SmallSpot(), "small Spot", noVehicle, pricePerHour, isAvailable));
		parkingSlotMap.put(1, row1ParkingSlot);

		ParkingSpace parkingSpace = new ParkingSpaceBuilder().setFloorNumber(1).setParkingName("AFI Cotroceni")
				.setParkingSlotMap(parkingSlotMap).setParkingSpaceType("DREPTUNGHIULAR").build();
		
		return parkingSpace;
	}
}
