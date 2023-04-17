/*
Class: CMSC203 
Program: Assignment # 5
Instructor: Ashique Tanveer
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
*/

/**
* @author Harlene Kaur
*/

import java.io.*;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {

	/**
	 * Reads from a file and returns a ragged array of doubles. The maximum rows is
	 * 10 and the maximum columns for each row is 10. Each row in the file is
	 * separated by a new line and each element in the row is separated by a space.
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {

		if (file.exists() && file.length() == 0) { 
			return null;
		}

		String[][] temp = new String[10][10]; 
		int row = 0;
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String[] currentLine = scan.nextLine().trim().split(" "); 
				for (int i = 0; i < currentLine.length; i++) { 
					temp[row][i] = currentLine[i];
				}
				row++; 
			}
			scan.close(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		double[][] newArray = new double[row][];

		for (int i = 0; i < newArray.length; i++) {
			int col = 0;
			for (int k = 0; k < temp[i].length; k++) { 
				if (temp[i][k] == null) { 
					break;
				}
				col++;
			}
			newArray[i] = new double[col]; 
			}

		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < newArray[i].length; j++) {
				newArray[i][j] = Double.parseDouble(temp[i][j]); 
				}
		}

		return newArray;

	}

	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate
	 * line within the file, and each double is separated by a space.
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {

		try {
			FileWriter fwriter = new FileWriter(outputFile, false);
			PrintWriter pwriter = new PrintWriter(fwriter);
			for (int i = 0; i < data.length; i++) {
				for (int k = 0; k < data[i].length; k++) {
					pwriter.print(data[i][k] + " ");
				}
				pwriter.println();
			}
			pwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the total of all the elements of the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		double total = 0;

		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				total += data[i][k];
			}
		}

		return total;
	}

	/**
	 * Returns the average of the elements in the two dimensional array
	 */
	public static double getAverage(double[][] data) {
		double total = 0;
		int size = 0;

		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				total += data[i][k];
				size++;
			}
		}

		double average = total / size;

		return average;

	}

	/**
	 * Returns the total of the selected row in the two dimensional array (Index 0
	 * refers to the first row).
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;

		for (int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}

		return total;
	}

	/**
	 * Returns the total of the selected column in the two dimensional array(Index 0
	 * refers to the first column). If a row in the two dimensional array doesn't
	 * have this column index, it is not an error, it doesn't participate in this
	 * method.
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i].length <= col) {
				continue;
			}
			total += data[i][col];

		}

		return total;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index(0 refers to the first row)
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0];

		for (int i = 1; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
			}
		}

		return highest;
	}

	/**
	 * Returns the index of largest element of the selected row in the two
	 * dimensional array index (0 refers to the first row).
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = data[row][0];
		int index = 0;

		for (int i = 1; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
				index = i;
			}
		}

		return index;
	}

	/**
	 * Returns the smallest element of the selected row in the two dimensional array
	 * index (0 refers to the first row)
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];

		for (int i = 1; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}

		return lowest;
	}

	/**
	 * Returns the index of the smallest element of the selected row in the two
	 * dimensional array index 0 refers to the first row.
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = data[row][0];
		int index = 0;

		for (int i = 0; i < data[row].length - 1; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
				index = i;
			}
		}

		return index;
	}

	/**
	 * Returns the largest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i].length <= col) {
				continue;
			}
			if (data[i][col] > highest) {
				highest = data[i][col];
			}
		}

		return highest;
	}

	/**
	 * Returns index of the largest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = 0;
		int index = 0;

		for (int i = 1; i < data.length; i++) {
			if (data[i].length <= col) {
				continue;
			}
			if (data[i][col] > highest) {
				highest = data[i][col];
				index = i;
			}
		}

		return index;
	}

	/**
	 * Returns the smallest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = getHighestInColumn(data, col);

		for (int i = 0; i < data.length; i++) {
			if (data[i].length <= col) {
				continue;
			}
			if (data[i][col] < lowest) {
				lowest = data[i][col];
			}
		}

		return lowest;
	}

	/**
	 * Returns the index of the smallest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = getHighestInColumn(data, col);
		int index = 0;

		for (int i = 1; i < data.length; i++) {
			if (data[i].length <= col) {
				continue;
			}
			if (data[i][col] < lowest) {
				lowest = data[i][col];
				index = i;
			}
		}

		return index;
	}

	/**
	 * Returns the largest element in Array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];

		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				if (data[i][k] > highest) {
					highest = data[i][k];
				}
			}
		}

		return highest;
	}

	/**
	 * Returns the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];

		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				if (data[i][k] < lowest) {
					lowest = data[i][k];
				}
			}
		}

		return lowest;
	}

}