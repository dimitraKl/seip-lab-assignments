# Source Code Analyzer Project

Source Code Analyzer project contains a software system that reads a java source code file, calculates the LOC, NOM and NOC metrics and exports them to an output file. The system will be used for practicing code refactoring and design patterns.

## Design Patterns

### Factory Strategy Pattern

Factory strategy pattern appears 2 times in this project. The factories are used to hide the instantiation logic from the clients and make the clients more independent. Through the use of the interfaces, classes of the same kind implement the same functionality.

**Benefits**
* Separation of concerns, because the logic for class instantiations is separated from the main functionality.
* Flexibility to extend the hierarchy without affecting the functionality implemented in the clients.

The pattern is implemented in:

**Source Code Analyzer System**

Consists of:
* SourceCodeAnalyzerFactory: The factory that creates the appropriate analyzer based on the analyzer type that the user has given as input.
* SourceCodeAnalyzer: The interface that contains the methods needed to be implemented for any analyzer type.
* RegexAnalyzer: The class that implements the functionality for *regex* analyzer type.
* StrcompAnalyzer: The class that implements the functionality for *strcomp* analyzer type.

**Source File Reader System**

Consists of:
* SourceFileReaderFactory: The factory that creates the appropriate file reader based on the file reader type that the user has given as input.
* SourceFileReader: The interface that contains the methods needed to be implemented for any file reader.
* LocalFile: The class that implements the functionality for reading a *local* file.
* WebFile: The class that implements the functionality for reading a *web* file.

### Null Object Pattern

Null object pattern appears 1 time in this project. The implementation of an interface that does nothing is used to handle the error if a user input is unknown.

**Benefits**
* Remove the responsibility from the client to handle the null or incorrect cases.
* Simplifies the client code, because there is no need to test the null case.

**Trade offs**
* There is a possibility to cause harm, since errors can be hidden and testing can become more complicated.

The pattern is implemented in:

**File Exporter System**

Consists of:
* FileExporterFactory: The factory that creates the appropriate file exporter based on the file exporter type that the user has given as input.
* FileExporter: The interface that contains the methods needed to be implemented for any file exporter.
* CsvExporter: The class that implements the functionality for exporting to a *csv* file.
* JsonExporter: The class that implements the functionality for exporting to a *json* file.
* NullExporter: The class that shows an error message if the file exporter type is unknown.

### Facade Pattern

Facade pattern appears 1 time in this project. The facade class is used as a front-face interface mask in order to hide from the client any complex functionalities. It reads a file with Source File Reader System, calculates the LOC, NOM and NOC metrics with the Source Code Analyzer System and finally exports the metrics with File Exporter System.

**Benefits**
* Provides a simple interface to a more complex system
* De-couples the subsystems for the clients

The pattern is implemented in:

**Metrics System**

Consists of:
* Metrics: The facade class that handles all the appropriate functionalities that are implemented in all the systems mentioned above. 

## Setup

### Build with

1. Build the executable Java application with: `mvn package jacoco:report`

2. Run the executable by executing `java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4` were args translate to: 	
	```
	arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	arg2 = “SourceCodeLocationType” [local|web]
	arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	arg4 = “OutputFileType” [csv|json]
	```
Example: 

`java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv`
	
## Licence

Released under the [MIT Licence](https://github.com/dimitraKl/seip-lab-assignments/blob/master/LICENSE).	