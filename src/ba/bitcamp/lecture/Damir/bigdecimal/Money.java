package ba.bitcamp.lecture.Damir.bigdecimal;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Scanner;

public class Money {

	private BigDecimal value;
	private Currency currency;
	
	/**
	 * Constructor for Money with two parameters
	 * @param value -  value of Money that we are forwarding
	 * @param currency - current currency.
	 */
	public Money(BigDecimal value, Currency currency ){
		this.value = value;
		this.currency = currency;
	}
	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}
	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}
	
	/**
	 * Converts all parameters to String.
	 */
	public String toString(){
		return String.format("%s %s", value, currency.getSymbol());
	}
	
	public static Money parse(String moneyString){
		Scanner s =  new Scanner( moneyString);
		String valueString = s.next();
		String currencyString = s.next();
		
		BigDecimal value = new BigDecimal(valueString);
		Currency currency  =Currency.getInstance(currencyString);
		
		return new Money(value,currency);
		
	}
	
	
	
	
}
