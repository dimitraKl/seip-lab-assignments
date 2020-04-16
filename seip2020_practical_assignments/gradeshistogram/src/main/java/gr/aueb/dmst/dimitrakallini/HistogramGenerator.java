package gr.aueb.dmst.dimitrakallini;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
 * 
 * @author dimitrakallini The purpose of this class is to receive a file with
 * 			students' grades and demonstrate their frequencies in a histogram.
 * @since March 2020 
 */
public class HistogramGenerator {

	/***
	 * Receives a file with students' grades. After reading all the grades
	 * from this file, a single dimension array that stores the grades
	 * is generated.
	 * 
	 * @param filename Single dimension integer array
	 */
	public int[] readFromFile(String filename) {
		
		File fileWithGrades = new File(filename);
		ArrayList<Integer> tempGrades = new ArrayList<Integer>();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileWithGrades));
			String line;
			while ((line = br.readLine()) != null) {
				int grade = Integer.parseInt(line);
				tempGrades.add(grade);
			}
			br.close();
		} catch (IOException e) {
			System.err.println("Something occured while reading from file.");
		} catch (NumberFormatException e) { 
	        System.err.println(e); 
	    }
		
		int[] grades = new int[tempGrades.size()];
		for (int i = 0; i < tempGrades.size(); i++)
			grades[i] = tempGrades.get(i);
		
		return grades;
	}


	/***
	 * Receives a single dimension array with students' grades. Then, creates
	 * another single dimension array containing the frequency of each grade.
	 * 
	 * @param grades Single dimension integer array
	 */
	public int[] findfrequencies(int[] grades) {
		int[] gradeFrequencies = new int[11];
		for (int i = 0; i < grades.length; i++) {
			gradeFrequencies[grades[i]]++ ;
		}
		return gradeFrequencies;
	}


	/***
	 * Receives a single dimension Integer array. From this array the dataset
	 * that will be used for the visualization is generated. Finally, The chart
	 * is generated with the use of the aforementioned dataset and then
	 * presented in the screen.
	 * 
	 * @param grades Single dimension integer array
	 */
	public void makeHistogram(int[] grades) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < grades.length; i++) {
			data.add(i, grades[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grades", "Students", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);

	}

	
	public static void main(String[] args) {
		String filename = args[0];
		HistogramGenerator hm = new HistogramGenerator();
		
		int[] grades = hm.readFromFile(filename);
		int[] gradeFrequencies = hm.findfrequencies(grades);
		hm.makeHistogram(gradeFrequencies);
	}

}
