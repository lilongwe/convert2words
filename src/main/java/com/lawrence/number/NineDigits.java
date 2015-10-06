/**
 * 
 */
package com.lawrence.number;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author lawrence
 *
 */
class NineDigits extends AbstractDigits {

	final static NumberFormat FORMAT = new DecimalFormat("000000000");
	final static String MILLION = " million";
	
	private String words;
	private ThreeDigits firstThree;
	private SixDigits lastSix;
	
	/**
	 * @param number
	 */
	protected NineDigits(int number) {
		super(number);
	}
	
	protected ThreeDigits getFirstThree() {
		if (firstThree == null) {
			String c = getCharacters().substring(0, 3);
			firstThree = new ThreeDigits(Integer.valueOf(c));
		}
		
		return firstThree;
	}
	
	protected SixDigits getLastSix() {
		if (lastSix == null) {
			String c = getCharacters().substring(3);
			lastSix = new SixDigits(Integer.valueOf(c));
		}
		
		return lastSix;
	}
	
	/* (non-Javadoc)
	 * @see test.Number2Words#getWords()
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
			
			words = builder.toString().replace("  ", " ");
		}

		return words;
	}

	/* (non-Javadoc)
	 * @see test.AbstractDigits#getFormat()
	 */
	@Override
	protected NumberFormat getFormat() {

		return FORMAT;
	}
}
