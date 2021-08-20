package codeanalyzer;

/**
 * Creates the appropriate file reader based on the given file reader type
 * in order to retrieve the contents of a given file.
 * The file can be stored locally or exist on the web.
 * @author dimitrakallini
 * 
 */
public class SourceFileReaderFactory {

	/**
	 * @param fileReaderType the location of a file
	 * (<b>local</b> for locally stored files, 
	 * <b>web</b> for files stored on the web).
	 */
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
