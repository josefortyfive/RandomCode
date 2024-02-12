package abstraction.example;


abstract class Mammal extends Animal{

	public Mammal(String type, String size, double weight) {
		super(type, size, weight);
		// TODO Auto-generated constructor stub
	}
	
	public void move(String speed) {

		System.out.print(getExplicitType()+ " ");
		System.out.println(speed.equals("slow") ? "walks" : "runs");
	}
	
	public abstract void shedHair();
	
}
public abstract class Animal {

	protected String type;
	private String size;
	private double weight;
	
	public Animal(String type, String size, double weight) {
		super();
		this.type = type;
		this.size = size;
		this.weight = weight;
	}

	public abstract void move(String speed);
	public abstract void makeNoise();
	
	public final String getExplicitType() {
		return getClass().getSimpleName() + " (" +type+ ")";
	}
}
