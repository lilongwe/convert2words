/**
 * 
 */
package com.lawrence.number;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 
 * This class represents 6 digits, essentially a thousand upwards to 
 * 1 million - 1
 * 
 * i.e.
 * 		> 10^3 && < 10^6 -1
 * 
 * The class represents the digits by composing two ThreeDigits 
 * 
 * @author lawrence
 *
 */
class SixDigits extends AbstractDigits {

	private final static NumberFormat FORMAT = new DecimalFormat("000000");
	protected final static String THOUSAND = " thousand";
	
	private ThreeDigits firstThree;
	private ThreeDigits lastThree;
	private String words;
	
	protected SixDigits(int number) {
		super(number);
	}
	
	/**
	 * The first Three Digits os the number
	 * 
	 * @return the first ThreeDigits of the number
	 */
	protected ThreeDigits getFirstThree() {
		if (firstThree == null) {
			String c = getCharacters().substring(0, 3);
			firstThree = new ThreeDigits(Integer.valueOf(c));
		}
		
		return firstThree;
	}
	
	/**
	 * The last three digits represented as ThreeDigits
	 * 
	 * @return the last ThreDigits of the number
	 */
	protected ThreeDigits getLastThree() {
		if (lastThree == null) {
			String c = getCharacters().substring(3);
			lastThree = new ThreeDigits(Integer.valueOf(c));
		}
		
		return lastThree;
	}
	

	/* (non-Javadoc)
	 * @see com.lawrence.number.Number2Words#getWords()
	 */
	public String getWords() {
		if (words == null) {
		
			StringBuilder builder = new StringBuilder();
			
			if (getFirstThree().getNumber() > 0) {
				builder.append(getFirstThree().getWords());
				builder.append(THOUSAND);
			}
			
			if (getLastThree().getNumber() > 0) {
				
				if (getLastThree().getNumber() < 100) {
					builder.append(AND);
				} else {
					builder.append(SPACE);
				}
				
				builder.append(getLastThree().getWords());
			}
			
			words = builder.toString();
		}
		
		return words;
	}


	/* (non-Javadoc)
	 * @see com.lawrence.number.AbstractDigits#getFormat()
	 */
	@Override
	protected NumberFormat getFormat() {
		// TODO Auto-generated method stub
		return FORMAT;
	}
}
