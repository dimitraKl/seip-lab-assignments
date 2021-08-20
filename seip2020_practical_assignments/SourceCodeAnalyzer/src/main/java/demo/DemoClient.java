package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.*;

/**
 * 
 * @author dimitrakallini
 *
 */
public class DemoClient {

	/**
	 * 
	 * @param filepath The source code file path
	 * @param sourceCodeAnalyzerType The analyzer type (regex or strcomp)
	 * @param sourceFileLocation The location of the file (local or web)
	 * @param outputFilePath The file path for the output file
	 * @param outputFileType The output file type (csv or json) 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		
		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}

		Metrics.calculateMetrics(filepath, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath, outputFileType);
	}

}
