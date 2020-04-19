package math;

import org.junit.Test;

public class MyMathTest {
	MyMath mm = new MyMath();

	@Test (expected = IllegalArgumentException.class)
	public void test_factorial_below_zero_exception() {
		mm.factorial(-3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_factorial_above_twelve_exception() {
		mm.factorial(15);
	}

}
