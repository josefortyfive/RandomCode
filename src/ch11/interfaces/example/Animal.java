package ch11.interfaces.example;

enum FlightStages implements Trackable {GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;
	public void track() {
		if(this != GROUNDED) {
			System.out.println("Monitoring " + this);
		}
	}
}

record DragonFly(String name, String type) implements FlightEnabled{

	@Override
	public void takeOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
	
}
class Satellite implements OrbitEarth{
	public void achieveOrbit() {
		System.out.println("Orbit achieved");
	}

	@Override
	public void takeOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
	
	
}
interface OrbitEarth extends FlightEnabled {
	void achieveOrbit();
}
interface FlightEnabled {
	
	double MILES_TO_KIM = 1.60934;
	double KM_TO_MILES = 0.621371;
	
	void takeOff();
	void land();
	void fly();

}

interface Trackable{
	void track();
}

public abstract class Animal {

	public abstract void move();
	
}
