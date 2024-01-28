package polymorphismchallenge;

public class Car {

	private String description;
	
	
	public Car(String description) {
		this.description = description;
	}

	public void startEngine() {
		System.out.println("Car -> startEngine");
	}
	
	public void drive() {
		System.out.println("Car -> Driving, type is "+getClass().getSimpleName());
		runEngine();
	}
	
	protected void runEngine() {
		System.out.println("Car -> runEngine");
	}
}

class GasPoweredCar extends Car{

	private double avgKmPerLitre;
	private int cylinders = 6;
	
	public GasPoweredCar(String description) {
		super(description);
	}

	public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
		super(description);
		this.avgKmPerLitre = avgKmPerLitre;
		this.cylinders = cylinders;
	}

	@Override
	public void startEngine() {

		System.out.printf("Gas -> All %d cylinders are fired up, Ready!%n", cylinders);
	}

	@Override
	protected void runEngine() {

		System.out.printf("Gas -> usage exceeds the average %.2f %n", avgKmPerLitre);
	}
	
	
}

class ElectricCar extends Car{

	private double avgKmPerCharge;
	
	public ElectricCar(String description) {
		super(description);
		
	}
}

class HybridCar extends Car{

	private double avgKmPerLitre;
	private int batterySize; 
	private int cylinders;
	
	public HybridCar(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
}


