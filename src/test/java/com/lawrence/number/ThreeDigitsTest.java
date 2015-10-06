/**
 * 
 */
package com.lawrence.number;

import org.junit.Assert;
import org.junit.Test;

import com.lawrence.number.ThreeDigits;

/**
 * @author lawrence
 *
 */
public class ThreeDigitsTest {
	
	@Test
	public void test0() {
		Assert.assertEquals("zero", new ThreeDigits(0).getWords());
	}
	
	@Test
	public void test7() {
		Assert.assertEquals("seven", new ThreeDigits(7).getWords());
	}
	
	@Test
	public void test14() {
		Assert.assertEquals("fourteen", new ThreeDigits(14).getWords());
	}
	
	@Test
	public void test25() {
		Assert.assertEquals("twenty five", new ThreeDigits(25).getWords());
	}
	
	@Test
	public void test90() {
		Assert.assertEquals("ninety", new ThreeDigits(90).getWords());
	}
	
	@Test
	public void test134() {
		Assert.assertEquals("one hundred and thirty four", new ThreeDigits(134).getWords());
	}

	@Test
	public void test506() {
		Assert.assertEquals("five hundred and six", new ThreeDigits(506).getWords());
	}
	
	@Test
	public void test777() {
		Assert.assertEquals("seven hundred and seventy seven", new ThreeDigits(777).getWords());
	}
	
	@Test
	public void test980() {
		Assert.assertEquals("nine hundred and eighty", new ThreeDigits(980).getWords());
	}
}
