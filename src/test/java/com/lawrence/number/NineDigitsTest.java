/**
 * 
 */
package com.lawrence.number;

import org.junit.Assert;
import org.junit.Test;

import com.lawrence.number.NineDigits;

/**
 * @author lawrence
 *
 */
public class NineDigitsTest {

	@Test
	public void test1000000() {
		Assert.assertEquals("one million", new NineDigits(1000000).getWords());
	}
	
	@Test
	public void test1000001() {
		Assert.assertEquals("one million and one", new NineDigits(1000001).getWords());
	}
	
	@Test
	public void test1000059() {
		Assert.assertEquals("one million and fifty nine", new NineDigits(1000059).getWords());
	}

	@Test
	public void test1000719() {
		Assert.assertEquals("one million seven hundred and nineteen", new NineDigits(1000719).getWords());
	}
	
	@Test
	public void test1001001() {
		Assert.assertEquals("one million one thousand and one", new NineDigits(1001001).getWords());
	}
	
	@Test
	public void test2802060() {
		Assert.assertEquals("two million eight hundred and two thousand and sixty", new NineDigits(2802060).getWords());
	}
	
	@Test
	public void test301004008() {
		Assert.assertEquals("three hundred and one million four thousand and eight", new NineDigits(301004008).getWords());
	}
	
	@Test
	public void test401000008() {
		Assert.assertEquals("four hundred and one million and eight", new NineDigits(401000008).getWords());
	}
	
	@Test
	public void test5673915() {
		Assert.assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", new NineDigits(56945781).getWords());
	}	
	
	@Test
	public void test999999999() {
		Assert.assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", new NineDigits(999999999).getWords());
	}
}
