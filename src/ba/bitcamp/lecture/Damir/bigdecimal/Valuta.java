package ba.bitcamp.lecture.Damir.bigdecimal;

import java.util.Currency;
import java.util.Scanner;

public class Valuta {

	public static void main(String[] args) {
		System.out.println("Unesi valutu: ");
		Scanner scan =  new Scanner(System.in);
		
		String currencyCode = scan.nextLine();
		Currency c = Currency.getInstance(currencyCode);
		
		System.out.printf("Valuta: %s n" , c.getCurrencyCode());
		System.out.printf("");
	}
}
