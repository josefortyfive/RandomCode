package ch11.interfaces.example;

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
	}
	
	private static void inFlight(FlightEnabled flier) {
		flier.takeoff();
		flier.fly();
		
		if(flier instanceof Trackable tracked) {
			tracked.track();
		}
		
		flier.land();
	}
}
