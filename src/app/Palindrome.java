/**
 * 
 * The Palindrome class handles all the logic to find the nearest palindrome.
 * 
 * @author Jason Cheong
 * @version 1.0
 * @since 2021-06-22
 */
package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Palindrome {
	/**
	 * Main method that accepts a string of integers as input and outputs the
	 * nearest palindrome. The user may type 'exit' at any point to exit the
	 * program.
	 * 
	 * @param args Unused
	 * @exception Exception Throws exception if anything goes wrong
	 */
	public static void main(String[] args) {
		// Creating class instances
		Palindrome palindrome = new Palindrome();
		Scanner scanner = new Scanner(System.in);

		// User dialog
		System.out.println("You may type 'exit' at any time to leave the program.");
		boolean exit = false;
		while (!exit) {
			System.out.println("Please enter a number:");
			String input = scanner.nextLine();

			// If the user types exit it will terminate the program
			if (input.equals("exit")) {
				System.out.println("The program has been terminated...");
				exit = !exit;
				scanner.close();
				break;
			}

			// Will return the palindrome or a user friendly error message
			String output = palindrome.findNearest(input);
			System.out.println(output);
			System.out.println("");
		}
	}

	/**
	 * Loops through the characters within the string forwards and backwards
	 * consecutively to determine whether the string is a valid palindrome.
	 * 
	 * @param string A string of integers.
	 * @return boolean Returns true if the string argument is a palindrome otherwise
	 *         it returns false.
	 */
	public boolean isValid(String string) {
		int i = 0;
		int j = string.length() - 1;

		while (i < j) {
			// If at any point the characters don't match then it's not a palindrome
			if (string.charAt(i) != string.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}
		return true;
	}

	/**
	 * Converts the string argument to a valid palindrome.
	 * 
	 * @param string A string of integers.
	 * @return String A valid palindrome.
	 */
	public String convert(String string) {
		// If it's a palindrome already then we just want to return it
		if (isValid(string)) {
			return string;
		}

		// Getting the middle index of the string
		int strLen = string.length();
		int halfIndex = strLen / 2;
		boolean isOdd = strLen % 2 == 1;
		String palindrome = "";

		// Iterating through the string going from start to half and building the start
		// of the new string
		for (int i = 0; i < halfIndex; i++) {
			palindrome += string.charAt(i);
		}

		// We want to keep the number in the middle if it's odd
		if (isOdd) {
			palindrome += string.charAt(halfIndex);
		}

		// Iterating through the string going from half to start and building the end of
		// the new string
		for (int i = halfIndex - 1; i >= 0; i--) {
			palindrome += string.charAt(i);
		}

		return palindrome;
	}

	/**
	 * Converts the original string argument to a palindrome, creates two (preceding
	 * and succeeding) palindrome sequences and compares the difference between them
	 * all with the lowest being returned.
	 * 
	 * @param string A string of integers
	 * @return String The nearest palindrome. If the difference is equal between any
	 *         of palindrome sequences then it will return the lower one.
	 */
	public String findNearest(String string) {
		// Input validation
		if (string == null || string.isEmpty() || string.trim().isEmpty()) {
			return "An input must be specified";
		}

		if (!string.matches("-?[0-9]+")) {
			return "A valid number must be provided";
		}

		int length = string.length();
		int number = Integer.parseInt(string);

		if (number < 0) {
			return "Negative numbers cannot be a palindrome";
		}

		if (number == 0) {
			return "Cannot return a palindrome that is less than zero";
		}

		// Only two digits, we can just minus one from the input
		if (number > 0 && length < 2) {
			return Integer.toString(number - 1);
		}

		// Calculating the lower, regular and upper numbers so that we can later convert
		// them to a palindrome
		int power = length / 2;
		int calcPow = (int) Math.pow(10, power);
		String low = Integer.toString(number - calcPow);
		String reg = string;
		String high = Integer.toString(number + calcPow);

		// Catching edge case where the length of low goes below the length of regular
		// ie. 1000 -> 919
		// In this case, we want to return 9 x low length
		if (length % 2 == 0 && low.length() != reg.length()) {
			low = "9".repeat(low.length());
		}

		// Converting the three numbers to palindromes
		String lowerBound = convert(low);
		String regBound = convert(reg);
		String upperBound = convert(high);

		// Creating a new array list to iterate over which includes our palindromes that
		// we want to validate
		ArrayList<String> boundaries = new ArrayList<String>();
		boundaries.add(lowerBound);
		if (!isValid(reg)) {
			boundaries.add(regBound);
		}
		boundaries.add(upperBound);

		// Checking which palindrome has the lowest difference
		int index = 0;
		int value = Math.abs(number - Integer.parseInt(boundaries.get(0)));
		for (int i = 0; i < boundaries.size(); i++) {
			int diff = Math.abs(number - Integer.parseInt(boundaries.get(i)));
			if (diff < value) {
				value = diff;
				index = i;
			}
		}
		// Returning the palindrome with the lowest difference
		return boundaries.get(index);
	}
}
