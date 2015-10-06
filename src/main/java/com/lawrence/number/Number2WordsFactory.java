/**
 * 
 */
package com.lawrence.number;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lawrence
 *
 */
public class Number2WordsFactory {

	protected static final int UPPER_LIMIT = 999999999;
	protected static final int LOWER_LIMI = 0;
	
	protected static final Map<Number,Number2Words> CACHE = new ConcurrentHashMap<Number,Number2Words>();
	
	/**
	 * 
	 */
	private Number2WordsFactory() {
	}
	
	private static Number2Words doGetConverter(int number, boolean shouldCache) {
		
		Number2Words result = null;
		
		if (shouldCache) {
			if (CACHE.containsKey(number)) {
				return CACHE.get(number);
			}
		}
		
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
	
	public static Number2Words getConverter(int number) {
		
		return doGetConverter(number, true);
	}
	
	protected static Number2Words getNoneCachedConverter(int number) {
		
		return doGetConverter(number, false);
	}
}
