package ba.bitcamp.lecture.Damir.bigdecimal;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigDecimalIntro {

	public static void main(String[] args) {
		BigDecimal dec;
		System.out.println("Unesdi veliki decimalni broj: ");
		Scanner s =  new Scanner(System.in);
		String decimalString = s.nextLine();
		
		dec =  new BigDecimal(decimalString);
		double decDouble = Double.parseDouble(decimalString);
		
		System.out.printf("Unijeli ste:  %s \n", dec);
		System.out.printf("Unijeli ste daouble: %f \n", decDouble);
	}
}
