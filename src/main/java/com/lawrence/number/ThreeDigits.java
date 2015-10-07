/**
 * 
 */
package com.lawrence.number;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 
 * This class represents36 digits, essentially a zero upwards to 
 * 1 thousand - 1
 * 
 * i.e.
 * 		> 0 && < 10^3 -1
 * 
 * The class represents the basics of representing numbers as words and
 * any digits greater that three are composed of multiples of this class.
 * 
 * For example, a million would be represented by three ThreeDigits.
 * 
 * @author lawrence
 *
 */
class ThreeDigits extends AbstractDigits {
	
	
	protected final static String UP_TO_19[] = {"zero","one","two","three","four","five","six","seven","eight","nine",
			"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

	protected final static String MULTIPLES_OF_10[] = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

	protected final static String HUNDRED = " hundred";
	
	private final static NumberFormat FORMAT = new DecimalFormat("000");
	
	private String words;
	
	protected ThreeDigits(int number) {
		super(number);	
	}
	

	/* (non-Javadoc)
	 * @see com.lawrence.number.Number2Words#getWords()
	 */
	public String getWords() {
		
		if (words == null) {
			StringBuilder toWords = new StringBuilder();
		
			createWords(toWords, getNumber());
			
			words = toWords.toString();
		}
		
		return words;
	}
	
	/**
	 * Converts the number to words recursively. 
	 * 
	 * @param toWords	the builder to append to
	 * @param number	the number to convert
	 */
	protected void createWords(StringBuilder toWords, int number) {
		if (number > 0) {
			
			if (number > 99) {
				int s = number / 100;
				toWords.append(UP_TO_19[s]).append(HUNDRED);
				createWords(toWords, number - (s * 100));
			}
			else if (number > 19) {
				int s = number / 10;
				if (toWords.length() > 0) toWords.append(AND);
				toWords.append(MULTIPLES_OF_10[s]);
				
				int reminder = number - (s * 10);
				
				if (reminder > 0) {
					toWords.append(SPACE).append(UP_TO_19[reminder]);
				}
			}
			else {
				if (toWords.length() > 0) {
					toWords.append(AND);
				}
				toWords.append(UP_TO_19[number]);
			}
		} else if (number == getNumber()) {
			toWords.append(UP_TO_19[number]);
		}
	}


	/* (non-Javadoc)
	 * @see com.lawrence.number.AbstractDigits#getFormat()
	 */
	@Override
	protected NumberFormat getFormat() {

		return FORMAT;
	}	
}
