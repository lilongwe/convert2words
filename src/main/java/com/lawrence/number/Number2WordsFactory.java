/**
 * 
 */
package com.lawrence.number;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 
 * A static factory that converts a numbers to words. The converted words are cached
 * to make retrieval of a second call quicker.
 * 
 * example:
 * 
 * 	Number2Words converter = Number2WordsFactory.getConverter(123456);
 * 
 * e.g.
 * 
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
 */
public class Number2WordsFactory {

	/* TODO the upper and lower limit that this cares for. ideally these would be resolved programmatically 
	 * but that has not been specified in the remit so this suffices for now
	 */
	protected static final int UPPER_LIMIT = 999999999;
	protected static final int LOWER_LIMI = 0;
	
	/*
	 * A rudimentary cache that can drastically be improved but it depends on future use of the class 
	 */
	protected static final Map<Number,Number2Words> CACHE = new ConcurrentHashMap<Number,Number2Words>();
	
	/**
	 * A default private constructor that is never called externally nor internally
	 */
	private Number2WordsFactory() {
	}
	
	
	/**
	 * A private utility method
	 * 
	 * @see Number2WordsFactory.convertToWords()
	 * 
	 * Converts the number to the words. A basic factory method that
	 * creates the right Number2Words implementation for the number
	 * provided using basic rudimentary deduction.
	 * 
	 * @param number 		the number to convert
	 * @param shouldCache	should use the cache
	 * @return
	 */
	private static Number2Words doGetConverter(int number, boolean shouldCache) {
		
		Number2Words result = null;
		
		if (shouldCache) {
			if (CACHE.containsKey(number)) {
				return CACHE.get(number);
			}
		}
		
		// TODO this again can be done in a more elegant fashion
		if (number <= 999999999 && number > 999999) {
			result = new NineDigits(number);
		}
		else if (number <= 999999 && number > 999 ) {
			result = new SixDigits(number);
		}
		else if (number <=999 && number >= 0) {
			result = new ThreeDigits(number);
		}
		else {
			throw new IllegalArgumentException("Integer must be between " + UPPER_LIMIT + " and " + LOWER_LIMI);
		}
		
		if (shouldCache) {
			CACHE.put(number, result);
		}
		
		return result;
	}
	
	/**
	 * Returns a Number2Words representation of a number as words. Given a number, the 
	 * Number2Words will return the representation of that number as words in English.
	 * 
	 * If the number has already been converted the object will be returned from a cache.
	 * NumberToWords is a thread safe class.
	 * 
	 * @param number to be converted
	 * @return a Number2Words
	 */
	public static Number2Words getConverter(int number) {
		
		return doGetConverter(number, true);
	}
	
	/**
	 * A wrapper for getConverter used for testing purposes only
	 * This call does not use the cache at all.
	 * 
	 * @see Number2WordsFactory.getConverter()
	 * @param number to be converted
	 * @return a Number2Words
	 */
	protected static Number2Words getNoneCachedConverter(int number) {
		
		return doGetConverter(number, false);
	}
}
