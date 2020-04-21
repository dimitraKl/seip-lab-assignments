package io;

import java.io.File;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class FileIOTest {
	FileIO fio = new FileIO();

	@Test
	public void testReadFile() {
		int[] myArray = new int[]{5,21,6,18,35,2,14};
		
		String resourceName = "testFileNormal.txt";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();

		Assert.assertArrayEquals(myArray, fio.readFile(absolutePath));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testReadFileFileNotExistException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		fio.readFile("randomFile.txt");
	}
	
	@Test
	public void testReadFileEmptyFileException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");

		String resourceName = "testFileEmpty.txt";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();

		fio.readFile(absolutePath);
	}

	@Test
	public void testReadFileContainsInvalidEntries() {
		String resourceName = "testFileInvalidEntries.txt";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();

		try {
			fio.readFile(absolutePath);
		} catch(NumberFormatException e) {
			Assert.fail();
		}
	}

}
