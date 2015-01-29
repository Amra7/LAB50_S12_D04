package ba.bitcamp.lecture.Damir.bigdecimal;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Scanner;

public class MoneyTest {

	public static void main(String[] args) {
//		printMoney();
		
		// moja varijnata
/*		String m = "12.34 BAM";
		System.out.println(Money.parse(m)); */
		
		parseAndPrintMoney();

	}

	private static void parseAndPrintMoney() {
		Scanner s = new Scanner(System.in);
		
		while (true){
			System.out.println("Show me the money: ");
			String str =  s.nextLine();
			if ( str.isEmpty()){
				break;
			}
			Money m = Money.parse(str);
			System.out.println(m);
		}
		
	}

	private static void printMoney() {
		Money m = new Money(new BigDecimal("10.15"),
				Currency.getInstance("BAM"));
		System.out.println(m);
	}
}
