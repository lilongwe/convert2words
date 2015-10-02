/**
 * 
 */
package com.worldpay.number;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author lawrence
 *
 */
class SixDigits extends AbstractDigits {

	final static NumberFormat FORMAT = new DecimalFormat("000000");
	final static String THOUSAND = " thousand";
	
	private ThreeDigits firstThree;
	private ThreeDigits lastThree;
	private String words;
	
	protected SixDigits(int number) {
		super(number);
	}
	
	protected ThreeDigits getFirstThree() {
		if (firstThree == null) {
			String c = getCharacters().substring(0, 3);
			firstThree = new ThreeDigits(Integer.valueOf(c));
		}
		
		return firstThree;
	}
	
	protected ThreeDigits getLastThree() {
		if (lastThree == null) {
			String c = getCharacters().substring(3);
			lastThree = new ThreeDigits(Integer.valueOf(c));
		}
		
		return lastThree;
	}
	
	/* (non-Javadoc)
	 * @see test.Number2Words#getWords()
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
	 * @see test.AbstractDigits#getFormat()
	 */
	@Override
	protected NumberFormat getFormat() {
		// TODO Auto-generated method stub
		return FORMAT;
	}
}
