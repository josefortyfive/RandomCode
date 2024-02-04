package polymormasterchallenge;

public class DeluxeBurger extends Burger{

	Item deluxe1;
	Item deluxe2;
	public DeluxeBurger(String name, double price) {
		super(name, price);
	}
	
	public void addTopping(String extra1, String extra2, String extra3, String extra4, String extra5) {
		// TODO Auto-generated method stub
		super.addTopping(extra1, extra2, extra3);
		deluxe1 = new Item("TOPPING", extra4, 0);
		deluxe2 = new Item("TOPPING", extra4, 0);
		
	}
	@Override
	public void printItemizedList() {
		// TODO Auto-generated method stub
		super.printItemizedList();
		
		if(deluxe1 != null) {
			deluxe1.printItem();
		}
		if(deluxe2 != null) {
			deluxe2.printItem();
		}
	}

	@Override
	public double getExtraPrice(String toppingName) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

	
}
