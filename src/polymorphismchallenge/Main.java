package polymorphismchallenge;

public class Main {
	
	public static void main(String args[]) {
		Car car = new Car ("2022 Blue Ferrari 296 GTS");
		runRace(car);
		
		Car ferrari = new GasPoweredCar("2022 Blue Ferrari 296 GTs", 15.4, 6);
		runRace(ferrari);
	}
	
	public static void runRace(Car car) {
		car.startEngine();
		car.drive();
	}
}
