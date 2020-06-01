package codeanalyzer;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class SourceCodeAnalyzerFactoryTest {
	SourceCodeAnalyzerFactory scaFact = new SourceCodeAnalyzerFactory();
	private final static String location = "local";

	@Test
	public void createRegexAnalyzerTest() {
		String type = "regex";
		Assert.assertEquals(true, scaFact.createSourceCodeAnalyzer(type, location) instanceof RegexAnalyzer);
	}

	@Test
	public void createStrcopmAnalyzerTest() {
		String type = "strcomp";
		Assert.assertEquals(true, scaFact.createSourceCodeAnalyzer(type, location) instanceof StrcompAnalyzer);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createUnknownAnalyzerTest() {
		String type = "unknown-type";
		scaFact.createSourceCodeAnalyzer(type, location);
	}

}
