package list.arraylist;

import java.util.Arrays;
import java.util.AbstractList;
import java.util.ArrayList;

record GroceryItem(String name, String type, int count) {
	public GroceryItem(String name) {
		this(name, "DAIRY", 1);
	}
	
	@Override
	public String toString() {
		return String.format("%d %s in %s", count, name.toUpperCase(), type);
	}
}
public class ArrayList1 {
	
	public static void main(String args[]) {
		GroceryItem[] groceryArray = new GroceryItem[3];
		groceryArray[0] = new GroceryItem("milk");
		groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
		groceryArray[2] = new GroceryItem ("oranges", "PRODUCE", 5);
		System.out.println(Arrays.toString(groceryArray));
		
		
		ArrayList objectList = new ArrayList();
		objectList.add(new GroceryItem("Butter"));
		objectList.add("Yogurt");
		
		ArrayList<GroceryItem> groceryList = new ArrayList<>();
		groceryList.add(new GroceryItem("Butter"));
		groceryList.add(new GroceryItem("Milk"));
		groceryList.add(new GroceryItem("oranges", "Produce", 5));
		groceryList.add(0, new GroceryItem("Apples" ,"PRODUCE", 6));
		groceryList.remove(1);
		System.out.println(groceryList); 
		
		ArrayList<GroceryItem> groceryList1 = new ArrayList<>();
		groceryList.add(new GroceryItem("Butter"));
		groceryList.add(new GroceryItem("Milk"));
		groceryList.add(new GroceryItem("oranges", "Produce", 5));
		groceryList.add(0, new GroceryItem("Apples" ,"PRODUCE", 6));
		groceryList.remove(1);
		System.out.println(groceryList); 
		
		
		
 	}

}
