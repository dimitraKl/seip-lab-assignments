package math;

import org.junit.Test;
import org.junit.Assert;

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
}
