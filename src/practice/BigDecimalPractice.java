package practice;

import java.math.BigDecimal;

public class BigDecimalPractice {

	public static void main(String args[]) {
		BigDecimal p1 = new BigDecimal("0.1");
		BigDecimal p2 = new BigDecimal("0.2");
		
		BigDecimal p3;
		
		p3 = p1.subtract(p2);
		
		System.out.println(p3);
		
	}
}
