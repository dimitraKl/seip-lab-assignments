package math;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;

public class ArrayOperationsTest {
	ArrayOperations ao = new ArrayOperations();
	FileIO fio = new FileIO();
	MyMath mm = new MyMath();

	@Test
	public void testFindPrimesInFile() {
		int[] myArray = new int[]{2,29,53,17,97};
		
		String resourceName = "testFilePrimeNumbers.txt";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();

		Assert.assertArrayEquals(myArray, ao.findPrimesInFile(fio, absolutePath, mm));
	}

}
