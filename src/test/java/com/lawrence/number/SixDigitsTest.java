/**
 * 
 */
package com.lawrence.number;

import org.junit.Assert;
import org.junit.Test;

import com.lawrence.number.SixDigits;

/**
 * @author lawrence
 *
 */
public class SixDigitsTest {

	
	@Test
	public void test1000() {
		Assert.assertEquals("one thousand", new SixDigits(1000).getWords());
	}
	
	@Test
	public void test3001() {
		Assert.assertEquals("three thousand and one", new SixDigits(3001).getWords());
	}
	
	@Test
	public void test9549() {
		Assert.assertEquals("nine thousand five hundred and forty nine", new SixDigits(9549).getWords());
	}
	
	@Test
	public void test25000() {
		Assert.assertEquals("twenty five thousand", new SixDigits(25000).getWords());
	}
	
	@Test
	public void test70409() {
		Assert.assertEquals("seventy thousand four hundred and nine", new SixDigits(70409).getWords());
	}
	
	@Test
	public void test100000() {
		Assert.assertEquals("one hundred thousand", new SixDigits(100000).getWords());
	}

	@Test
	public void test300001() {
		Assert.assertEquals("three hundred thousand and one", new SixDigits(300001).getWords());
	}
	
	@Test
	public void test401015() {
		Assert.assertEquals("four hundred and one thousand and fifteen", new SixDigits(401015).getWords());
	}
	
	@Test
	public void test564019() {
		Assert.assertEquals("five hundred and sixty four thousand and nineteen", new SixDigits(564019).getWords());
	}
	
	@Test
	public void test720159() {
		Assert.assertEquals("seven hundred and twenty thousand one hundred and fifty nine", new SixDigits(720159).getWords());
	}
	
	@Test
	public void test999999() {
		Assert.assertEquals("nine hundred and ninety nine thousand nine hundred and ninety nine", new SixDigits(999999).getWords());
	}
}
