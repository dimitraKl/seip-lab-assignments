package math;

/**
* The MyMath provides simple math operations
* that serve as hands-on practice on Unit Testing.
*
* @author  dimitrakallini
* @version 1.0
* @since   2020-04-19
*/
public class MyMath {

	/**
	 * Calculates and returns the factorial of a given number.
	 * @param n the input number
	 * @return the factorial of the given number n
	 * @exception IllegalArgumentException when n is less than zero or greater than 12
	 */
	public int factorial(int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException("n should be > 0 and < 12");
		} else if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	/**
	 * Checks if a given number is prime or not.
	 * @param n the input number
	 * @return true if n is prime
	 * @return false if n is not prime
	 * @exception IllegalArgumentException when n is less than 2
	 */
	public boolean isPrime(int n) {
		if (n < 2)
			throw new IllegalArgumentException("n should be > 2");

		for (int i=2; i<n; i++) {
	        if(n%i == 0)
	            return false;
	    }
	    return true;
	}

}
