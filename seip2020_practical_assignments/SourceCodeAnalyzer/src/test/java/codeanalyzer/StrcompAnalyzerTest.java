package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class StrcompAnalyzerTest {
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	StrcompAnalyzer sa = new StrcompAnalyzer("local");

	@Test
	public void testCalculateLOC() throws IOException {
		assertEquals(7, sa.calculateLOC(TEST_CLASS));
	}

	@Test
	public void testCalculateNOM() throws IOException {
		assertEquals(3, sa.calculateNOM(TEST_CLASS));
	}

	@Test
	public void testCalculateNOC() throws IOException {
		assertEquals(3, sa.calculateNOC(TEST_CLASS));
	}

}
