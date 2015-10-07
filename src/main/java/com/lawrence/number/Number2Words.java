package com.lawrence.number;

public interface Number2Words {

	/**
	 * A representation of the number as words using the English vernacular
	 * e.g.
	 * Input		Output
	 *	0			zero
	 *	1			one
	 *	21			twenty one
	 *	105			one hundred and five
	 *	123			one hundred and twenty three
	 *	1005		one thousand and five
	 *	1042		one thousand and forty two
	 *	1105		one thousand one hundred and five
	 *	56945781	fifty six million nine hundred and forty five thousand seven hundred and eighty one
	 *	999999999	nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine.
	 *
	 * @author lawrence
	 * 
	 **/
	
	/**
	 * The number converted to words using the english vernacular
	 * 
	 * @return the words as a string
	 */
	String getWords();

	/**
	 * The representation of the number as the raw integer
	 * 
	 * @return the number as an integer
	 */
	int getNumber();
}