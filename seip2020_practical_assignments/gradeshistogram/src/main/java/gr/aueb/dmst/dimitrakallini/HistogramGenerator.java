package gr.aueb.dmst.dimitrakallini;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class HistogramGenerator {

	public int[] readFromFile(String filename) {
		
		File fileWithGrades = new File(filename);
		ArrayList<Integer> tempGrades = new ArrayList<Integer>();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileWithGrades));
			while (br.readLine() != null) {
				int grade = Integer.parseInt(br.readLine());
				tempGrades.add(grade);
			}
			br.close();
		} catch (IOException e) {
			System.err.println("Something occured while reading from file.");
		}
		
		int[] grades = new int[tempGrades.size()];
		for (int i =0; i < tempGrades.size(); i++) 
			grades[i] = tempGrades.get(i);
		
		return grades;
	}
	
	public static void main(String[] args) {
		String filename = args[0];
		HistogramGenerator hm = new HistogramGenerator();
		
		int[] grades = hm.readFromFile(filename);

	}

}
