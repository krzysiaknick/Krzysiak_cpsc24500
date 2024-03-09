/*
Nicholas Krzysiak
03/08/2024
Assignment 4

This program reads a text file and generates a 2D array which can be used to find values such as...
-The longest row (findLongestRow)
-The max within a row (findMaxInRow)
-The max in the whole file (findMax)
 */






package Assignment4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Assignment4 {

	/**
	 * @param filename
	 * @return number of lines in a text file
	 * @throws Exception
	 */
	public static int getNoLines(String filename) throws Exception {
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
			return (int) fileStream.count();
		}
	}

	/**
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception IO Exception e
	 */
	public static int[][] create2DArray(String filename) throws Exception {
		int lines = getNoLines(filename);
		int[][] arr = new int[lines][];

		try {
			Scanner scan = new Scanner(new File(filename));
			int currentRow = 0;

			while (scan.hasNextLine() && currentRow < lines) {
				String[] nums = scan.nextLine().trim().split("\\s+");


				arr[currentRow] = new int[nums.length];

				for (int i = 0; i < nums.length; i++) {
					arr[currentRow][i] = Integer.parseInt(nums[i]);
				}
				currentRow++;
			}
			scan.close();
		} catch (IOException e) {
			throw new Exception("Failed to read file: " + e.getMessage());
		}

		return arr;
	}


	/**
	 * @param arr array created in create2DArray
	 * @return longest row in the text file
	 *
	 */

	public static int findLongestRow(int[][] arr){
		int max = 0;
		int longestRow = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length > max){
				max = arr[i].length;
				longestRow = i;
			}

		}
return longestRow;
	}



	/**
	 * @param arr array created in create2DArray
	 * @param rowIndex the line in which you want to find the max in
	 * @return max number in row
	 *
	 */

public static int findMaxInRow(int[][] arr , int rowIndex){

		int max = arr[rowIndex][0];

	for (int i = 1; i < arr[rowIndex].length; i++) {
		if (arr[rowIndex][i] > max) {
			max = arr[rowIndex][i];
		}
	}

	return max;
	}



	/**
	 * @param arr array created in create2DArray
	 * @return max number in file
	 *
	 */
public static int findMax(int[][] arr){
		int max = arr[0][0];

	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			if (arr[i][j] > max){
				max = arr[i][j];
			}
		}
	}
	return max;
}








	public static void main(String[] args) {
		String filename = "assignment4Data.txt";
		if (args.length <1) {
			System.out.println("usage: Assignment4 inputFilename ");
			System.exit(0);

		}

		filename = args[0];
		int arr[][] = null;
		try {
			System.out.println("Number of lines in the file ="+ getNoLines(filename));
			arr = create2DArray(filename);
			int longestRow = findLongestRow(arr);
			System.out.println("Longest row in the file is: "+ (longestRow+1 )+" ,with length of: "
			                      +arr[longestRow].length);
			System.out.println("Max value in first row = "+ findMaxInRow(arr, 0));
			System.out.println("Max value in file = "+ findMax(arr));
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}

