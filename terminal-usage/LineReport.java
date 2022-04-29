package pa0;

import java.util.*;
import java.io.*;

public class LineReport {
	public static final int terminals = 500;					// max # of terminals		
	private LineUsage[] lines = new LineUsage[terminals];		// array of LineUsage objects

	// Constructor
	public LineReport() {
	    // creates an array of 500 lists representing each terminal
		for (int i = 1; i < terminals; i++) {
			lines[i] = new LineUsage();
		}
	}

	@SuppressWarnings("resource")
	// read input data, put facts into lines array
	void loadData(String fname) throws FileNotFoundException {
		File file = new File(fname);
		Scanner scanner = new Scanner(file);
		int lineNum;			// terminal used
		String user;			// name of user
		
		// reading input line by line
		while (scanner.hasNext()) {
			String input = scanner.nextLine();
			// parsing input, including whitespace characters 
			// (in case the rules for usernames change in the future)
			String[] username = input.split("\\s+");
			lineNum = Integer.parseInt(username[0]);
			user = username[1];
			// add the observed user to the array
			lines[lineNum - 1].addObservation(user);		
		}
	}
		
	// given loaded lines array, generate report on lines
	void generateReport() {
		System.out.println("Line" + "     " + "Most Common User" + "     " + "Count");
		// for each terminal, find user who used it the most
		for (int i = 1; i < terminals; i++) {
			Usage max = lines[i].findMaxUsage();
			System.out.println((i + 1) + "\t\t" + max.getUser() + "\t\t" + max.getCount());
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		String input = args[0];
		LineReport report = new LineReport();
		report.loadData(input);
		report.generateReport();
	}
}

