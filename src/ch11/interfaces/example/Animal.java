package ch11.interfaces.example;

interface FlightEnabled {
	
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
