package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
	ArithmeticOperations ao = new ArithmeticOperations();

	@Test
	public void testDivide() {
		Assert.assertEquals(5, ao.divide(10, 2), 0);
	}

	@Test
	public void testDivideZeroNumerator() {
		Assert.assertEquals(0, ao.divide(0, 2), 0);
	}

	@Test (expected = ArithmeticException.class)
	public void testDivideByZeroException() {
		ao.divide(3, 0);
	}
	
	@Test
	public void testMultiply() {
		Assert.assertEquals(20, ao.multiply(10, 2), 0);
	}
	
	@Test
	public void testMultiplyBorderValues() {
		Assert.assertEquals(Integer.MAX_VALUE, ao.multiply(1, Integer.MAX_VALUE), 0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testMultiplyOneNegativeNumberException() {
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-10, 2);
	}
	
	@Test
	public void testMultiplyTwoNegativeNumbersException() {
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-10, -2);
	}
	
	@Test
	public void testMultiplyProductNotIntegerException() {
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

}
