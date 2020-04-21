package math;

import java.io.File;
import io.FileIO;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ArrayOperationsTest {
	ArrayOperations ao = new ArrayOperations();

	@Test
	public void testFindPrimesInFile() {
		//Mock the dependencies
		FileIO fio = mock(FileIO.class);
		MyMath mm = mock(MyMath.class);

		int[] myArray = new int[]{2,29,53};
		
		String resourceName = "testFilePrimeNumbers.txt";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();

		int[] fileResultValues = new int[]{2,27,88,29,53};
		when(fio.readFile(absolutePath)).thenReturn(fileResultValues);

		when(mm.isPrime(2)).thenReturn(true);
		when(mm.isPrime(27)).thenReturn(false);
		when(mm.isPrime(88)).thenReturn(false);
		when(mm.isPrime(29)).thenReturn(true);
		when(mm.isPrime(53)).thenReturn(true);

		Assert.assertArrayEquals(myArray, ao.findPrimesInFile(fio, absolutePath, mm));
	}

}
