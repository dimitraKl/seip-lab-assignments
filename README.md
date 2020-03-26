# seip-lab-assignments

This repository will be used for my lab assignments in the lesson Software Engineering in practice.

## Grades Histogram

Grades Histogram is a Java application that reads a file with students’ grades and generates its histogram.

## Setup

### Dependencies

* [JFreeChart](https://mvnrepository.com/artifact/org.jfree/jfreechart) 1.0

### Build

* [Java](https://www.oracle.com/java/technologies/javase-downloads.html) 1.8 or higher
* [Apache Maven](https://maven.apache.org/) 3.6

In order to build the project you should run `mvn install`.

## Usage

Run the jar file and give a file with grades as a command-line argument.

For example:
```
java -jar gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar grades.txt
```

## Licence

Released under the [MIT Licence](https://choosealicense.com/licenses/mit/).