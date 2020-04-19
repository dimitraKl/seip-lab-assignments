package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
	ArithmeticOperations ao = new ArithmeticOperations();

	@Test
	public void test_divide() {
		Assert.assertEquals(5, ao.divide(10, 2), 0);
	}
	
	@Test (expected = ArithmeticException.class)
	public void test_divide_by_zero() {
		ao.divide(3, 0);
	}
	
	@Test
	public void test_multiply() {
		Assert.assertEquals(20, ao.multiply(10, 2), 0);
	}
	
	@Test
	public void test_multiply_border_values() {
		Assert.assertEquals(Integer.MAX_VALUE, ao.multiply(1, Integer.MAX_VALUE), 0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_multiply_one_negative_number_exception() {
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-10, 2);
	}
	
	@Test
	public void test_multiply_two_negative_numbers_exception() {
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-10, -2);
	}
	
	@Test
	public void test_multiply_product_not_integer_exception() {
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

}
