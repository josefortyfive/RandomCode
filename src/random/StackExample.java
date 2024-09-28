package random;
import java.util.Stack;
public class StackExample {

	public static void main(String[] args) {
		Stack<String> sample = new Stack<>();
		
		sample.push("Jack");
		sample.push("Amy");
		sample.push("John");
		sample.push("Nancy");
		sample.push("Binay");
		sample.push("This");
		
		while(!sample.isEmpty()) {

			System.out.println(sample.pop());
		}

	}

}
