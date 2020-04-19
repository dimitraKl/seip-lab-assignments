package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FactorialParameterizedTest {

	@Parameter (value = 0)
	public int n;
	@Parameter (value = 1)
	public int result;
	
	MyMath mm = new MyMath();
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{0, 1},{1, 1},{2, 2},{12, 479001600}};
		
		return Arrays.asList(data);
	}
	
	@Test
	public void test_factorial() {
		Assert.assertEquals(result, mm.factorial(n));
	}

}
