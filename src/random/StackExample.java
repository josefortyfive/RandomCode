package random;
import java.util.Stack;
public class StackExample {

	public static void main(String[] args) {
		Stack<String> sample = new Stack<>();
		
		sample.push("JAck");
		sample.push("Amy");
		sample.push("John");
		
		while(!sample.isEmpty()) {

			System.out.println(sample.pop());
		}

	}

}
