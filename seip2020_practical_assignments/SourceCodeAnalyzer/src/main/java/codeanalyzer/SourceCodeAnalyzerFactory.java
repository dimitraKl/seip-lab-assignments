package codeanalyzer;

/**
 * Creates the appropriate source code analyzer based on the given analyzer
 * type in order to calculate the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes.
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison).
 * @author dimitrakallini
 *
 */
public class SourceCodeAnalyzerFactory {
	
	public SourceCodeAnalyzer createSourceCodeAnalyzer(String analyzerType, String fileLocation) {
		SourceCodeAnalyzer analyzer;
		if(analyzerType.equals("regex")) {
			analyzer = new RegexAnalyzer(fileLocation);
		} else if (analyzerType.equals("strcomp")) {
			analyzer = new StrcompAnalyzer(fileLocation);
		} else {
			throw new IllegalArgumentException("Unknown analyzer type: " + analyzerType);
		}
		
		return analyzer;
	}

}
