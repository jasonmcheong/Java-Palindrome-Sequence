/**
 * 
 * The PalindromeTest class tests the majority of the use cases that I've come across
 * 
 * @author Jason Cheong
 * @version 1.0
 * @since 2021-06-22
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.Palindrome;

public class PalindromeTest {
	private Palindrome palindrome;
	private String input;
	private String output;

	@Before
	public void setUp() throws Exception {
		input = null;
		palindrome = new Palindrome();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void nullStringTest() throws Exception {
		input = null;
		output = palindrome.findNearest(input);
		assertEquals("An input must be specified", output);
	}

	@Test
	public void emptyStringTest() throws Exception {
		input = "";
		output = palindrome.findNearest(input);
		assertEquals("An input must be specified", output);
	}

	@Test
	public void whiteSpaceTest() throws Exception {
		input = " ";
		output = palindrome.findNearest(input);
		assertEquals("An input must be specified", output);
	}

	@Test
	public void alphabetTest() throws Exception {
		input = "abc";
		output = palindrome.findNearest(input);
		assertEquals("A valid number must be provided", output);
	}

	@Test
	public void numberFormatTest() throws Exception {
		input = "-123-?456";
		output = palindrome.findNearest(input);
		assertEquals("A valid number must be provided", output);
	}

	@Test
	public void numberIsNegativeTest() throws Exception {
		input = "-12";
		output = palindrome.findNearest(input);
		assertEquals("Negative numbers cannot be a palindrome", output);
	}

	@Test
	public void numberIsZeroTest() throws Exception {
		input = "0";
		output = palindrome.findNearest(input);
		assertEquals("Cannot return a palindrome that is less than zero", output);
	}

	@Test
	public void singleDigitTest() throws Exception {
		input = "8";
		output = palindrome.findNearest(input);
		assertEquals("7", output);
	}

	@Test
	public void doubleDigitTest() throws Exception {
		input = "77";
		output = palindrome.findNearest(input);
		assertEquals("66", output);
	}

	@Test
	public void evenStringLengthTest() throws Exception {
		input = "1001";
		output = palindrome.findNearest(input);
		assertEquals("999", output);
	}

	@Test
	public void oddStringLengthTest() throws Exception {
		input = "10001";
		output = palindrome.findNearest(input);
		assertEquals("9999", output);
	}

	@Test
	public void tiedDifferenceTest() throws Exception {
		input = "1056";
		output = palindrome.findNearest(input);
		assertEquals("1001", output);
	}
}