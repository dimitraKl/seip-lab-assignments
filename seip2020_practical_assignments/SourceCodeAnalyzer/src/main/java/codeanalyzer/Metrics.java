package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Metrics {

	public static void calculateMetrics(String filepath, String analyzerType, String fileLocation, String outputFilePath, String outputFileType) throws IOException {

		SourceCodeAnalyzerFactory analyzerFactory = new SourceCodeAnalyzerFactory();
		SourceCodeAnalyzer analyzer = analyzerFactory.createSourceCodeAnalyzer(analyzerType, fileLocation);
		int loc = analyzer.calculateLOC(filepath);
		int nom = analyzer.calculateNOM(filepath);
		int noc = analyzer.calculateNOC(filepath);
		
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",loc);
		metrics.put("nom",nom);
		metrics.put("noc",noc);
		
		FileExporterFactory fileExporterFactory = new FileExporterFactory();
		FileExporter exporter = fileExporterFactory.createFileExporter(outputFileType);
		exporter.writeFile(metrics, outputFilePath);

	}
}
