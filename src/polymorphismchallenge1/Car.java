package polymorphismchallenge1;

public class Car {
	private boolean startEngine;
	private int cylinders;
	private String name;
	private int wheels;
	
	public Car(int cylinders, String name) {
		super();
		this.cylinders = cylinders;
		this.name = name;
	}
	
	public int getCylinders() {
		return cylinders;
	}


	public String getName() {
		return name;
	}

	public String startEngine() {
		return "Car -> startEngine()";
	}
	

	public String accelerate() {
		return "Car -> Car is accelerate()";
	}
	
	public String brake() {
		return "Car -> Car is brake()";
		
	}
	

}

class Mitsubishi extends Car{

	public Mitsubishi(int cylinders, String name) {
		super(cylinders, name);
	}

	@Override
	public String startEngine() {
		// TODO Auto-generated method stub
		return "Mitsubishi -> startEngine()";
	}

	@Override
	public String accelerate() {
		// TODO Auto-generated method stub
		return "Mitsubishi -> accelerate()";
	}

	@Override
	public String brake() {
		// TODO Auto-generated method stub
		return "Mitsubishi -> brake()";
	}
	
	
}


class Holden extends Car{

	public Holden(int cylinders, String name) {
		super(cylinders, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String startEngine() {
		// TODO Auto-generated method stub
		return "Holden -> startEngine()";
	}

	@Override
	public String accelerate() {
		// TODO Auto-generated method stub
		return "Holden -> accelerate()";
	}

	@Override
	public String brake() {
		// TODO Auto-generated method stub
		return "Holden -> brake()";
	}
	
	
	
}

class Ford extends Car{

	public Ford(int cylinders, String name) {
		super(cylinders, name);
		// TODO Auto-generated constructor stub
	}



	@Override
	public String startEngine() {
		// TODO Auto-generated method stub
		return "Ford -> startEngine()";
	}

	@Override
	public String accelerate() {
		// TODO Auto-generated method stub
		return "Ford -> accelerate()";
	}
	
	@Override
	public String brake() {
		// TODO Auto-generated method stub
		return "Ford -> brake()";
	}
	
	
}