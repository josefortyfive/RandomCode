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
	private int batterySize = 6;
	
	public ElectricCar(String description) {
		super(description);
		
	}

	public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
		super(description);
		this.avgKmPerCharge = avgKmPerCharge;
		this.batterySize = batterySize;
	}

	@Override
	public void startEngine() {

		System.out.printf("BEV -> switch %d kWh battery on, Ready!%n", batterySize);
	}

	@Override
	protected void runEngine() {

		System.out.printf("BEV -> usage under the average %.2f %n", avgKmPerCharge);
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
	
	
	
	public HybridCar(String description, double avgKmPerLitre, int batterySize, int cylinders) {
		super(description);
		this.avgKmPerLitre = avgKmPerLitre;
		this.batterySize = batterySize;
		this.cylinders = cylinders;
	}



	@Override
	public void startEngine() {
		
		// This calls the Car class and override to for Hybrid type car

		System.out.printf("Hybrid -> %d cylinders are fired up.%n", cylinders); // Hybrid car has Gas
		System.out.printf("Hybrid -> switch %d kWh battery on, Ready!%n", batterySize);
	}

	@Override
	protected void runEngine() {

		System.out.printf("Hybrid -> usage below average: %.2f %n", avgKmPerLitre);
	}

	
}


