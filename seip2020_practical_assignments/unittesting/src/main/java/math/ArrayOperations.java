package math;

import io.FileIO;
import java.util.ArrayList;

public class ArrayOperations {

	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		int[] array = fileIo.readFile(filepath);
		ArrayList<Integer> al = new ArrayList<Integer>();
		MyMath mm = new MyMath();

		for (int a : array) {
			if (mm.isPrime(a))
				al.add(a);
		}
		
		// Convert a List to an array using 
		return al.stream().mapToInt(i -> i).toArray();
	}

}
