package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class FileExporterFactoryTest {
	FileExporterFactory fexFact = new FileExporterFactory();

	@Test
	public void createScvExporterTest() {
		String type = "csv";
		Assert.assertEquals(true, fexFact.createFileExporter(type) instanceof CsvExporter);
	}

	@Test
	public void createJsonExporterTest() {
		String type = "json";
		Assert.assertEquals(true, fexFact.createFileExporter(type) instanceof JsonExporter);
	}

	@Test
	public void createNullExporterTest() {
		String type = "non-existing-type";
		Assert.assertEquals(true, fexFact.createFileExporter(type) instanceof NullExporter);
	}

}
