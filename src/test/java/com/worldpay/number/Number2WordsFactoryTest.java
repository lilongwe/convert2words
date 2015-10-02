/**
 * 
 */
package com.worldpay.number;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.worldpay.number.NineDigits;
import com.worldpay.number.Number2Words;
import com.worldpay.number.Number2WordsFactory;
import com.worldpay.number.SixDigits;
import com.worldpay.number.ThreeDigits;

/**
 * @author lawrence
 *
 */
public class Number2WordsFactoryTest {

	@Before
	public void clearCache() {
		Number2WordsFactory.CACHE.clear();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLowerLimit() {
		Number2WordsFactory.getNoneCachedConverter(Number2WordsFactory.LOWER_LIMI - 1);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUpperLimit() {
		Number2WordsFactory.getNoneCachedConverter(Number2WordsFactory.UPPER_LIMIT + 1);		
	}
	
	@Test
	public void testThreeDigitsClassReturned() {
		Number2Words result = Number2WordsFactory.getNoneCachedConverter(123);
		
		Assert.assertEquals(ThreeDigits.class, result.getClass());
	}
	
	@Test
	public void testSixDigitsClassReturned() {
		Number2Words result = Number2WordsFactory.getNoneCachedConverter(123456);
		
		Assert.assertEquals(SixDigits.class, result.getClass());
	}
	
	@Test
	public void testCache() {
				
		for (int i=0; i<50; i++) {
			Number2WordsFactory.getConverter(i);
		}
				
		for (int i=49; i>=0; i--) {
			Number2WordsFactory.getConverter(i);;
		}
		
		Assert.assertEquals(50, Number2WordsFactory.CACHE.size());
	}
	
	@Test
	public void testNonCache() {
				
		for (int i=0; i<50; i++) {
			Number2WordsFactory.getNoneCachedConverter(i);
		}
				
		for (int i=49; i>=0; i--) {
			Number2WordsFactory.getNoneCachedConverter(i);
		}
		
		Assert.assertEquals(0, Number2WordsFactory.CACHE.size());
	}
	
	@Test
	public void testNineDigitsClassReturned() {
		Number2Words result = Number2WordsFactory.getNoneCachedConverter(123456789);
		
		Assert.assertEquals(NineDigits.class, result.getClass());
	}
	
	@Test
	public void testNumberReturned() {
		Number2Words result = Number2WordsFactory.getNoneCachedConverter(987654321);
		
		Assert.assertEquals(987654321, result.getNumber());
	}
	
	@Test
	public void testWordsReturned() {
		Number2Words result = Number2WordsFactory.getNoneCachedConverter(987654321);
		
		Assert.assertEquals("nine hundred and eighty seven million six hundred and fifty four thousand three hundred and twenty one", result.getWords());
	}
}
