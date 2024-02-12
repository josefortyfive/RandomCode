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

		bird.takeoff();
		flier.fly();
		tracked.track();
		flier.land();
	}
}
