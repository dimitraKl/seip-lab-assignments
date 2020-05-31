package codeanalyzer;

public class SourceFileReaderFactory {

	public SourceFileReader createSourceFileReader(String fileReaderType) {
		SourceFileReader reader;
		if (fileReaderType.contentEquals("local")) {
			// read a locally stored file
			reader = new LocalFile();
		} else if (fileReaderType.contentEquals("web")) {
			// read a file stored in the web
			reader = new WebFile();
		} else {
			throw new IllegalArgumentException("Unknown reader type: " + fileReaderType);
		}
		return reader;
	}

}
