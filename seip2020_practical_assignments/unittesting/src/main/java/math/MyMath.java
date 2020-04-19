package math;

public class MyMath {

	public int factorial (int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException("n should be > 0 and < 12");
		} else if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}
