package math;

import org.junit.Test;

public class MyMathTest {
	MyMath mm = new MyMath();

	@Test (expected = IllegalArgumentException.class)
	public void testFactorialBelowZeroException() {
		mm.factorial(-3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testFactorialAboveTwelveException() {
		mm.factorial(15);
	}

}
