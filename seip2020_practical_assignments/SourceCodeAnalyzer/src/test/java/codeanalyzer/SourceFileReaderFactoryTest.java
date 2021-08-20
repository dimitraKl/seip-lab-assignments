package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class SourceFileReaderFactoryTest {
	SourceFileReaderFactory sfFact = new SourceFileReaderFactory();

	@Test
	public void createLocalFileReaderTest() {
		String type = "local";
		Assert.assertEquals(true, sfFact.createSourceFileReader(type) instanceof LocalFile);
	}

	@Test
	public void createWebFileReaderTest() {
		String type = "web";
		Assert.assertEquals(true, sfFact.createSourceFileReader(type) instanceof WebFile);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createUnknownFileReaderTest() {
		String type = "unknown-type";
		sfFact.createSourceFileReader(type);
	}

}
