package ch11.interfaces.example;

interface FlightEnabled {
	
	double MILES_TO_KIM = 1.60934;
	double KM_TO_MILES = 0.621371;
	
	void takeoff();
	void land();
	void fly();
}

interface Trackable {
	void track();
}

public abstract class Animal {

	public abstract void move();
	
}
