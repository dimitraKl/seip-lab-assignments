package math;

import io.FileIO;
import java.util.ArrayList;

/**
* The ArrayOperations provides simple array operations
* that serve as hands-on practice on Unit Testing.
*
* @author  dimitrakallini
* @version 1.0
* @since   2020-04-21
*/
public class ArrayOperations {

	/**
	 * Reads numbers from a file and returns an array with the prime numbers.
	 * @param fileIo the object of FileIO
	 * @param filepath the input file
	 * @param myMath the object of MyMath
	 * @return the integer array with the prime numbers
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		int[] array = fileIo.readFile(filepath);
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int a : array) {
			if (myMath.isPrime(a))
				al.add(a);
		}
		
		// Convert a List to an array using 
		return al.stream().mapToInt(i -> i).toArray();
	}

}
