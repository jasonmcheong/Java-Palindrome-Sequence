/**
 * 
 * The Palindrome class handles all the logic to find the nearest palindrome.
 * 
 * @author Jason Cheong
 * @version 1.0
 * @since 2021-06-21
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
		Palindrome palindrome = new Palindrome();
		Scanner scanner = new Scanner(System.in);

		System.out.println("You may type 'exit' at any time to leave the program.");
		boolean exit = false;
		while (!exit) {
			System.out.println("Please enter a number:");
			String input = scanner.nextLine();
			if (input.equals("exit")) {
				System.out.println("The program has been terminated...");
				exit = !exit;
				scanner.close();
				break;
			}
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
		if (isValid(string)) {
			return string;
		}

		int strLen = string.length();
		int halfIndex = strLen / 2;
		boolean isOdd = strLen % 2 == 1;
		String palindrome = "";

		for (int i = 0; i < halfIndex; i++) {
			palindrome += string.charAt(i);
		}

		if (isOdd) {
			palindrome += string.charAt(halfIndex);
		}

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
		if (string == null || string.isEmpty() || string.trim().isEmpty()) {
			return "Please enter a number";
		}

		if (!string.matches("-?[0-9]+")) {
			return "Please enter a valid number";
		}

		int length = string.length();
		int number = Integer.parseInt(string);

		if (number < 0) {
			return "Negative numbers cannot be a palindrome";
		}

		if (number == 0) {
			return "Cannot return a palindrome that is less than zero";
		}

		if (number > 0 && length < 2) {
			return Integer.toString(number - 1);
		}

		int power = length / 2;
		int calcPow = (int) Math.pow(10, power);
		String low = Integer.toString(number - calcPow);
		String reg = string;
		String high = Integer.toString(number + calcPow);

		if (length % 2 == 0 && low.length() != reg.length()) {
			low = "9".repeat(low.length());
		}

		String lowerBound = convert(low);
		String regBound = convert(reg);
		String upperBound = convert(high);

		ArrayList<String> boundaries = new ArrayList<String>();
		boundaries.add(lowerBound);
		if (!isValid(reg)) {
			boundaries.add(regBound);
		}
		boundaries.add(upperBound);

		int index = 0;
		int value = Math.abs(number - Integer.parseInt(boundaries.get(0)));
		for (int i = 0; i < boundaries.size(); i++) {
			int diff = Math.abs(number - Integer.parseInt(boundaries.get(i)));
			if (diff < value) {
				value = diff;
				index = i;
			}
		}
		return boundaries.get(index);
	}
}
