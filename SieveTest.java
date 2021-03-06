import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;


public class SieveTest {
	
	Random rng = new Random();
	String newLine = System.getProperty("line.separator");//get system specific newline
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStream() throws UnsupportedEncodingException {
		System.setOut(new PrintStream(outContent, false, "UTF-8"));
	}
	
	@After
	public void cleanUpStream() {
		System.setOut(null);
	}
	
	/*
	 * Ensure proper output of Sieve.printSieve()
	 * Tests empty and null array inputs
	 */
	
	@Test
	public void testEmptyPrintSieve() throws UnsupportedEncodingException {
		
		//expected print
		String expectedOutput = "BLANK" + newLine;	
		
		int[] emptyArray = new int[0];
		
		outContent.reset();
		Sieve.printSieve(emptyArray);
		String output = outContent.toString("UTF-8");
		assertEquals(output, expectedOutput);
		
		outContent.reset();
		Sieve.printSieve(null);
		output = outContent.toString("UTF-8");
		assertEquals(output, expectedOutput);
	}
	
	/*
	 * Test printSieve using many random inputs
	 * Uses restRandomPrintSieve() to test many random inputs
	 */
	@Test
	public void testManyRandomPrintSieve() {
		int maxReps = 100;
		for (int i = 0; i < maxReps; i++) {
			try {
				testRandomPrintSieve();
			} catch (UnsupportedEncodingException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}
	

	/*
	 * Test printSieve using random input
	 * generate a randomly sized array with random integers in it
	 * all random numbers are 1-100 inclusive
	 */
	private void testRandomPrintSieve() throws UnsupportedEncodingException {
		
		int arraySize = getNum();
		int[] input = new int[arraySize];
		String expectedOutput = "> ";
		
		
		for (int i = 0; i < arraySize; i++) {
			input[i] = getNum();
			expectedOutput = expectedOutput.concat(input[i] + " ");
		}
		
		outContent.reset();
		Sieve.printSieve(input);
		String output = outContent.toString("UTF-8");

		assertEquals(output, expectedOutput);
	}
	
	// helper function generates a random int between 1 and 100 inclusive
	private int getNum() {
		return rng.nextInt(100) + 1;
	}

}
