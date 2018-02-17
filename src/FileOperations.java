import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: FileOperations.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class FileOperations {
	private Scanner inputStream = null;
	private ArrayList<String> linesFromInputFile = null;
	
	/**
	 * Reads a file and calls the helper method populateLinesArrayList to populate an ArrayList
	 * with each line read in from the file.
	 * @param fileName = name of the file to read
	 */
	public void readFile(String fileName) {

	}
	
	/**
	 * Populates an ArrayList with Strings
	 * @param lineFromFile = The string to populate the ArrayList with
	 */
	private void populateLinesArrayList(String lineFromFile) {
		
	}
	
	/**
	 * Will return the String located at the index parameter from the 
	 * ArrayList<String> of Strings read in from the file. 
	 * @param indexOfArrayList = index of ArrayList<String> that is requested to be returned
	 * @return lineFromInputFile = The line of the input file that has been stored in the
	 * ArrayList<String>
	 */
	public String getLinesFromInputFile(int indexOfArrayList) {
		String lineFromInputFile = "";
		return lineFromInputFile;
	}
	
}
