import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SieveTest {
	
	Random rng = new Random();
	String newLine = System.getProperty("line.separator");//get system specific newline
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStream() {
		System.setOut(new PrintStream(outContent));
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
	public void testEmptyPrintSieve() {
		
		//expected print
		String expectedOutput = "BLANK" + newLine;	
		
		int[] emptyArray = new int[0];
		int[] nullArray = null;
		
		outContent.reset();
		Sieve.printSieve(emptyArray);
		String output = outContent.toString();
		assertEquals(output, expectedOutput);
		
		outContent.reset();
		Sieve.printSieve(nullArray);
		output = outContent.toString();
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
			testRandomPrintSieve();
		}
	}
	

	/*
	 * Test printSieve using random input
	 * generate a randomly sized array with random integers in it
	 * all random numbers are 1-100 inclusive
	 */
	private void testRandomPrintSieve() {
		
		int arraySize = getNum();
		int[] input = new int[arraySize];
		String expectedOutput = "> ";
		
		
		for (int i = 0; i < arraySize; i++) {
			input[i] = getNum();
			expectedOutput += input[i] + " ";
		}
		
		outContent.reset();
		Sieve.printSieve(input);
		String output = outContent.toString();
		System.err.println(output);
		System.err.println(expectedOutput);
		assertEquals(output, expectedOutput);
	}
	
	// helper function generates a random int between 1 and 100 inclusive
	private int getNum() {
		return rng.nextInt(100) + 1;
	}

}
