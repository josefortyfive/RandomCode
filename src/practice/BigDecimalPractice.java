package practice;

import java.math.BigDecimal;

public class BigDecimalPractice {

	public static void main(String args[]) {
		
		double a1 = 0.02;
		double a2 = 0.03;
		double a3 = a2 - a1;
		
		BigDecimal p1 = new BigDecimal("0.02");
		BigDecimal p2 = new BigDecimal("0.03");
		
		BigDecimal p3;
		
		p3 = p2.subtract(p1);
		
		System.out.println(p3);
		
		System.out.println(a3);
		
	}
}
