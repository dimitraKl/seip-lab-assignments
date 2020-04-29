package math;

import org.junit.Assert;
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

	@Test
	public void testIsPrimeTrue() {
		Assert.assertEquals(true, mm.isPrime(11));
	}

	@Test
	public void testIsPrimeFalse() {
		Assert.assertEquals(false, mm.isPrime(15));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIsPrimeNumberBelowTwoException() {
		mm.factorial(-3);
	}

}
