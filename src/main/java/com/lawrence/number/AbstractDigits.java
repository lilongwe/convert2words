/**
 * 
 */
package com.lawrence.number;

import java.text.Format;
import java.text.NumberFormat;

/**
 * AbstractDigits is an abstract class for all Digits. Digits are a combination of
 * numbers starting with 0 and the then increasing by 10^3.
 * 
 * e.g 
 * 		0
 * 		10^3 = 1000
 * 		10^6 = 1000000
 * 		10^9 = 1000000000
 * 
 * 
 * This class represents the actual number and also the representation of the numbers
 * as characters. 
 * 
 * AbstractDigits implements Number2Words which facilitates the conversion of the 
 * numbers to words in English
 * 
 * @author lawrence
 *
 */
abstract class AbstractDigits implements Number2Words {

	// a space separator
	protected final static String SPACE = " ";
	protected final static String DOUBLE_SPACE = "  ";
	// the and separator
	protected final static String AND = " and ";
	
	//the number to be converted
	private final int number;
	//the number as a string
	private String characters;

	
	/**
	 * Default constructor with an argument of the number to be used
	 * Protected so it cannot be used outside of context.
	 * 
	 * @param	number 	the number or digits to be represented
	 */
	protected AbstractDigits(int number) {
		this.number = number;
	}


	/* (non-Javadoc)
	 * @see com.lawrence.number.Number2Words#getNumber()
	 */
	public int getNumber() {

		return number;
	}
	
	/**
	 * The number needs to be padded in case it is smaller than the maximum size of the digits.
	 * Formatting it to a string aids that and makes it easier to traverse the individual digits.
	 * 
	 * @return the NumberFormat to be used for formatting the number
	 */
	protected abstract NumberFormat getFormat();
		
	
	/**
	 * A cached representation of the number as a string formatted using getFormat()
	 * 
	 * @return	the number as a sring
	 */
	protected String getCharacters() {
		
		if (characters == null) {
			Format format = getFormat();
			synchronized (format) {
				setCharacters(format.format(getNumber()));
			}
		}
		return characters;
	}
	
	
	/**
	 * Setter for the characters
	 * 
	 * @param characters the number as characters
	 */
	protected final void setCharacters(String characters) {

		this.characters = characters;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getName());
		builder.append(" [number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractDigits other = (AbstractDigits) obj;
		if (number != other.number)
			return false;
		return true;
	}
}
