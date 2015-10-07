/**
 * 
 */
package com.lawrence.number;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 
 * This class represents 9 digits, essentially a million upwards to 
 * 1 billion - 1
 * 
 * i.e.
 * 		> 10^6 && < 10^9 -1
 * 
 * The class represents the digits by composing one SixDigits and 
 * another ThreeDigits.
 * 
 * @author lawrence
 *
 */
class NineDigits extends AbstractDigits {

	private final static NumberFormat FORMAT = new DecimalFormat("000000000");
	// million descriptor as a string
	protected final static String MILLION = " million";
	
	private String words;
	private ThreeDigits firstThree;
	private SixDigits lastSix;
	
	/**
	 * Default constructor that calls the super constructor with the number
	 * 
	 * @param number	the real number
	 */
	protected NineDigits(int number) {
		super(number);
	}
	
	/**
	 * A representation of the first three digits of the number as AbstractDigits
	 * 
	 * @return the first three digits of the number
	 */
	protected ThreeDigits getFirstThree() {
		if (firstThree == null) {
			String c = getCharacters().substring(0, 3);
			firstThree = new ThreeDigits(Integer.valueOf(c));
		}
		
		return firstThree;
	}
	
	/**
	 * A representation of the last six digits of the number as AbstractDigits
	 * 
	 * @return the last six digits of the number
	 */
	protected SixDigits getLastSix() {
		if (lastSix == null) {
			String c = getCharacters().substring(3);
			lastSix = new SixDigits(Integer.valueOf(c));
		}
		
		return lastSix;
	}
	

	/* (non-Javadoc)
	 * @see com.lawrence.number.Number2Words#getWords()
	 */
	public String getWords() {
		
		if (words == null) {
			StringBuilder builder = new StringBuilder();
			
			if  (getFirstThree().getNumber() > 0) {
				builder.append(getFirstThree().getWords());
				builder.append(MILLION);
			}
			
			if (getLastSix().getNumber() > 0) {
			
				builder.append(SPACE);
			
				builder.append(getLastSix().getWords());
			}
			
			words = builder.toString().replace(DOUBLE_SPACE, SPACE);
		}

		return words;
	}


	/* (non-Javadoc)
	 * @see com.lawrence.number.AbstractDigits#getFormat()
	 */
	@Override
	protected NumberFormat getFormat() {

		return FORMAT;
	}
}
