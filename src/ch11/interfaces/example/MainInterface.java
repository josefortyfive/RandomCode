package ch11.interfaces.example;

import java.util.ArrayList;
import java.util.List;

public class MainInterface {

	public static void main(String args[]) {
		Bird bird = new Bird();
		Animal animal = bird;
		FlightEnabled flier = bird;
		Trackable tracked = bird;
		
		animal.move();
		//flier.move();
		//tracked.move();

		//bird.takeoff();
		//flier.fly();
		//tracked.track();
		//flier.land();
		
		inFlight(flier);
		inFlight(new Jet());
		Trackable truck = new Truck();
		truck.track();
		double kmsTraveled = 100;
		double milesTravaled = kmsTraveled * FlightEnabled.KM_TO_MILES;
		System.out.printf("The truck traveled %.2f km or %.2f miles %n", kmsTraveled, milesTravaled);
		
		ArrayList<FlightEnabled> fliers = new ArrayList<>();
		fliers.add(bird);
		
		List<FlightEnabled> betterFliers = new ArrayList<>();
		betterFliers.add(bird);
		
		triggerFliers(fliers);
		flyFliers(fliers);
		landFliers(fliers);
		
		//triggerFliers(betterFliers);
	}
	
	private static void inFlight(FlightEnabled flier) {
		flier.takeOff();
		flier.fly();
		
		if(flier instanceof Trackable tracked) {
			tracked.track();
		}
		
		flier.land();
	}
	
	
	private static void triggerFliers(ArrayList<FlightEnabled> fliers) {
		for(var flier : fliers) {
			flier.takeOff();
		}
	}
	
	private static void flyFliers(ArrayList<FlightEnabled> fliers) {
		for(var flier : fliers) {
			flier.fly();
		}
	}
	
	private static void landFliers(ArrayList<FlightEnabled> fliers) {
		for(var flier : fliers) {
			flier.land();
		}
	}
	
}
