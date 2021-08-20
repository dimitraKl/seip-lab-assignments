package codeanalyzer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class RegexAnalyzerTest {
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	RegexAnalyzer ra = new RegexAnalyzer("local");

	@Test
	public void testCalculateLOC() throws IOException {
		assertEquals(21, ra.calculateLOC(TEST_CLASS));
	}

	@Test
	public void testCalculateNOM() throws IOException {
		assertEquals(3, ra.calculateNOM(TEST_CLASS));
	}

	@Test
	public void testCalculateNOC() throws IOException {
		assertEquals(3, ra.calculateNOC(TEST_CLASS));
	}

}
