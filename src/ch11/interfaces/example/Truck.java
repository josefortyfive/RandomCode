package ch11.interfaces.example;

public class Truck implements Trackable{

	@Override
	public void track() {
		System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
	}

}
