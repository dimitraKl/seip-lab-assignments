package codeanalyzer;

/**
 * Creates the appropriate exporter based on the given output
 * file type in order to export the metrics. 
 * The output can be CSV or JSON files, otherwise it will lead
 * to unknown output file type error.
 * @author dimitrakallini
 * 
 */
public class FileExporterFactory {
	
	public FileExporter createFileExporter(String outputType) {

		FileExporter exporter;
		if (outputType.equals("csv")) {
			exporter = new CsvExporter();
		} else if (outputType.equals("json")) {
			exporter = new JsonExporter();
		} else {
			exporter = new NullExporter(outputType);
		}

		return exporter;
	}

}
