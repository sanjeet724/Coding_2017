package dialPad;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trial2 {
	
	// data-structures needed to solve this problem
	public static LinkedHashSet<String> result = new LinkedHashSet<String>();
	public static List<String []> luckyPairs = new ArrayList<String[]>();
	public static int doubleDigitNums;
	public static int singleDigitNums;
	public static int count_1;
	public static int count_2;
	public static String [] cache = new String[2];

	
	//public static String input = "4938532894754";
	
	public static String input = "12345678";
	
	public static void main(String[] args) {
		doubleDigitNums = input.length() % 7;
		singleDigitNums = 7 - doubleDigitNums;
		System.out.println("Number of double digit numbers : " + doubleDigitNums);
		System.out.println("Number of single digit numbers : " + singleDigitNums);
		
		// create the pairs
		for (int i = 0; i < input.length(); i++) {
			String [] pair = new String[2];
			pair[0] = Character.toString(input.charAt(i));
			if (i != input.length()-1) {
				pair[1] = input.substring(i, i+2);
			} else {
				pair[1] = "0"; // last one's double digit will be null
			}
			luckyPairs.add(pair);
		}
	    printPairs(luckyPairs);
		
		// get combos
		createCombinations(luckyPairs);
		
		printResult(result);
	}
	
	
	
	public static void createCombinations(List<String[]> pairs) {
		while (pairs.size() != 1) {
			String [] currPair = pairs.get(0);
			int num1 = Integer.parseInt(currPair[0]);
			int num2 = Integer.parseInt(currPair[1]);
			System.out.println("For Current Pair: " + currPair[0] + "," + currPair[1]);
			if (!result.contains(currPair[0]) && count_1 < singleDigitNums && num1 > 0) {
				System.out.println("  -->Selecting first one: " + currPair[0]);
				result.add(currPair[0]);
				count_1++;
				// only add to cache if eligible
				if (!result.contains(currPair[1]) && count_2 < doubleDigitNums && num2 > 0 && num2 < 60) {
					cache[0] = currPair[0];
					cache[1] = currPair[1];
				}
				pairs.remove(currPair);
				createCombinations(pairs);
			} else if (!result.contains(currPair[1]) && count_2 < doubleDigitNums && num2 > 0 && num2 < 60) {
				System.out.println("  -->Selecting 2nd one: " + currPair[1]);
				result.add(currPair[1]);
				count_2++;
				pairs.remove(currPair);
				if (pairs.size() > 1) {
					String [] nextPair = pairs.get(0);
					pairs.remove(nextPair);
				}
				createCombinations(pairs);
			} else {
				// need to do course correction
				System.out.println("  -->Discarding : " + cache[0]);
				result.remove(cache[0]);
				count_1--;
				int numericVal = Integer.parseInt(cache[1]);
				if (!result.contains(cache[1]) && count_2 < doubleDigitNums && numericVal < 60 && numericVal > 0) {
					System.out.println("  -->Selecting From Cache: " + cache[1]);
					result.add(cache[1]);
					count_2++;
					//pairs.remove(currPair);
					createCombinations(pairs);
				 }
				else {
					// invalid 
				}
			}
		}
		
		if (pairs.size() == 1) {
			String [] currPair = pairs.get(0);
			int numericVal_1 = Integer.parseInt(currPair[0]);
			int numericVal_2 = Integer.parseInt(currPair[1]);
			//System.out.println("Base Case");
			if (!result.contains(currPair[0]) && count_1 < singleDigitNums && numericVal_1 > 0 ) {
				result.add(currPair[0]);
				count_1++;
			} else if (!result.contains(currPair[1]) && count_2 < doubleDigitNums && numericVal_2 > 0) {
				result.add(currPair[1]);
				count_2++;
			}
			return;
		} 
	}
	

	
	public static void printPairs(List<String[]> pairs) {
		for (String [] pair : pairs) {
			System.out.println(pair[0] + " " + pair[1]);
		}
	}
	
	
	public static void printResult(LinkedHashSet<String> res) {
		System.out.println("Result size: " + res.size());
		for (String s : res) {
			System.out.println(s);
		}
	}
}
