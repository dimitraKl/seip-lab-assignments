package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public interface FileExporter {
	public void writeFile(Map<String, Integer> metrics, String filepath);
}


class CsvExporter implements FileExporter {

	@Override
	public void writeFile(Map<String, Integer> metrics, String filepath) {
		File outputFile = new File(filepath + ".csv");
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();
		
		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue()+",");
		}
		
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			writer.close();
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


class JsonExporter implements FileExporter {

	@Override
	public void writeFile(Map<String, Integer> metrics, String filepath) {
		// Functionality not implemented yet
		// No need to implement it for the assignment
	}

}


class NullExporter implements FileExporter {

	private String outputType;

	public NullExporter(String outputType) {
		this.outputType = outputType;
	}

	@Override
	public void writeFile(Map<String, Integer> metrics, String filepath) {
		System.err.println("Unknown type: " + outputType);
	}

}