package codeanalyzer;

public class SourceCodeAnalyzerFactory {
	
	public SourceCodeAnalyzer createSourceCodeAnalyzer(String analyzerType, String fileLocation) {
		SourceCodeAnalyzer analyzer;
		if(analyzerType.equals("regex")) {
			analyzer = new RegexAnalyzer(fileLocation);
		} else if (analyzerType.equals("strcomp")) {
			analyzer = new StrcopmAnalyzer(fileLocation);
		} else {
			throw new IllegalArgumentException("Unknown analyzer type: " + analyzerType);
		}
		
		return analyzer;
	}

}
