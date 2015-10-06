/**
 * 
 */
package com.lawrence.number;

import java.text.Format;
import java.text.NumberFormat;

/**
 * AbstractDigits is an abstract class for all Digits
 * 
 * @author lawrence
 *
 */
abstract class AbstractDigits implements Number2Words {

	// a space separator
	final static String SPACE = " ";
	final static String AND = " and ";
	
	//the number to be converted
	private final int number;
	//the number as a string
	private String characters;

	
	/**
	 * 
	 */
	protected AbstractDigits(int number) {
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see test.Number2Words#getNumber()
	 */
	public int getNumber() {

		return number;
	}
	
	/**
	 * @return the NumberFormat to be used for formatting the number
	 */
	protected abstract NumberFormat getFormat();
		
	protected String getCharacters() {
		
		if (characters == null) {
			Format format = getFormat();
			synchronized (format) {
				setCharacters(format.format(getNumber()));
			}
		}
		return characters;
	}
	
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
