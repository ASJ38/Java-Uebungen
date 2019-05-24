import java.util.*;

public class Ubungen01 {

	// In this Kata, you will implement the Luhn Algorithm, which is used to help
	// validate credit card numbers.
	// Given a positive integer of up to 16 digits, return true if it is a valid
	// credit card number, and false if it is not.

	// Here is the algorithm:

	// Double every other digit, scanning from right to left, starting from the
	// second digit (from the right).
	// Another way to think about it is: if there are an even number of digits,
	// double every other digit starting with the first;
	// if there are an odd number of digits, double every other digit starting with
	// the second:
	// If a resulting number is greater than 9, replace it with the sum of its own
	// digits
	// (which is the same as subtracting 9 from it):Sum all of the final
	// digits:Finally,
	// take that sum and divide it by 10. If the remainder equals zero, the original
	// credit card number is valid.

	public static boolean validate(String n) {
		int val = 0;
		String valString = "";
		if (n.length() > 1 && n.length() <= 16) {
			if (n.length() % 2 == 0) {
				for (int i = 0; i < n.length() - 1; i += 2) {
					val = 2 * Integer.parseInt(n.substring(i, i + 1));
					if (val > 9) {
						val = val - 9;
					}
					valString = valString + val + n.substring(i + 1, i + 2);
				}
			} else if (!(n.length() % 2 == 0)) {
				for (int i = 1; i < n.length(); i += 2) {
					val = 2 * Integer.parseInt(n.substring(i, i + 1));
					if (val > 9) {
						val = val - 9;
					}
					valString = valString + n.substring(i - 1, i) + val;
				}
			}

			val = 0;
			for (int i = 0; i < valString.length(); i++) {
				val = val + Integer.parseInt(valString.substring(i, i + 1));
			}
			if (val % 10 == 0) {
				return true;
			}
		}
		return false;

	}

	// Given a string of words, you need to find the highest scoring word.
	// Each letter of a word scores points according to it's position in the
	// alphabet: a = 1, b = 2, c = 3 etc.
	// You need to return the highest scoring word as a string.
	// If two words score the same, return the word that appears earliest in the
	// original string.
	// All letters will be lowercase and all inputs will be valid.

	public static String high(String s) {

		String alp = "abcdefghijklmnopqrstuvwxyz";

		HashMap<String, Integer> hsi = new HashMap<String, Integer>();
		int found = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals(" ")) {
				hsi.put(s.substring(found, i), 0);
				found = i + 1;
			} else if (i == s.length() - 1) {
				hsi.put(s.substring(found, s.length()), 0);
			}
		}

		int value = 0;
		// jedes Wort wird einmal durchgegangen
		for (String wort : hsi.keySet()) {
			value = 0;
			// jeder Buchstabe des String wird durchgegangen
			for (int i = 0; i < wort.length(); i++) {
				// für buchstaben i wird bei alp nach dem gleichen wert gesucht
				for (int j = 0; j < alp.length(); j++) {
					if (wort.substring(i, i + 1).equals(alp.substring(j, j + 1))) {
						value = value + j + 1;
					}

				}

			}
			hsi.put(wort, value);
		}

		String highVal = "";
		int min = 0;

		for (String wort : hsi.keySet()) {
			if (hsi.get(wort) > min) {
				highVal = wort;
				min = hsi.get(wort);
			}
		}

		return highVal;
	}

	// Write simple .camelCase method (camel_case function in PHP, CamelCase in C#
	// or camelCase in Java) for strings.
	// All words must have their first letter capitalized without spaces.

	public static String camelCase(String str) {
		String camel = "";
		int found = 1;
		str = str.trim();
		str = str.replaceAll("\\s+", " ");

		if (str != null && !str.isEmpty()) {
			camel = str.substring(0, 1).toUpperCase();
			for (int i = 1; i < str.length(); i++) {
				if ((str.substring(i, i + 1).equals(" "))) {
					camel = camel + str.substring(found, i) + str.substring(i + 1, i + 2).toUpperCase();

					found = i + 2;
				}

				else if (i + 1 == str.length()) {
					camel = camel + str.substring(found, str.length());
				}
			}
		}
		return camel;

	}

	// Write a function that takes an array of numbers (integers for the tests) and
	// a target number.
	// It should find two different items in the array that, when added together,
	// give the target value.
	// The indices of these items should then be returned in an array like so:
	// [index1, index2].
	// For the purposes of this kata, some tests may have multiple answers; any
	// valid solutions will be accepted.
	// The input will always be valid (numbers will be an array of length 2 or
	// greater,
	// and all of the items will be numbers; target will always be the sum of two
	// different items from that array).

	public static int[] twoSum(int[] numbers, int target) {
		int[] index = new int[2];
		if (numbers.length >= 2) {

			for (int i = 0; i < numbers.length; i++) {

				for (int j = 1; j < numbers.length; j++) {
					if (numbers[i] + numbers[j] == target) {
						index[0] = i;
						index[1] = j;
					}
				}
			}
		}
		return index;
	}

	// Given an array of ints, we'll say that a triple is a value appearing 3 times
	// in a row in the array.
	// Return true if the array does not contain any triples.

	public static boolean noTriples(int[] nums) {
		int algomax = 0;

		for (int i = 0; i < nums.length; i++) {

			if (algomax < nums.length && !(nums.length < 3)) {
				algomax += 2;
				if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
					return false;
				}

			}
		}

		return true;

	}

//Mr. Scrooge has a sum of money 'P' that wants to invest, and he wants to 
//know how many years 'Y' this sum has to be kept in the bank in order for this sum of money to amount to 'D'.
//The sum is kept for 'Y' years in the bank where interest 'I' is paid yearly, 
//and the new sum is re-invested yearly after paying tax 'T'
//Note that the principal is not taxed but only the year's accrued interest

	public static int calculateYears(double principal, double interest, double tax, double desired) {
		int years = 0;
		double moneyPY = 0;

		while (principal < desired) {
			moneyPY = (principal * interest) - ((principal * interest) * tax);
			principal = principal + moneyPY;
			years++;
		}
		return years;

	}
}
