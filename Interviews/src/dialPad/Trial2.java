package dialPad;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Trial2 {
	
	// data-structures needed to solve this problem
	public static LinkedHashSet<String> result = new LinkedHashSet<String>();
	public static List<String []> luckyPairs = new ArrayList<String[]>();
	public static int doubleDigitNums;
	public static int singleDigitNums;
	public static int count_1;
	public static int count_2;
	public static String [] cache = new String[2];
	public static List<String []> cache2 = new ArrayList<String[]>();
	
	public static String input = "4938532894754";
	
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
	    // printPairs(luckyPairs);
		
		// get combos
		//createCombinations(luckyPairs);
		
		createCombinations2(luckyPairs);
		
		printResult(result);
	}
	
	
	/**
	 * Creates the combinations
	 * @param pairs - the list of options for each position
	 * @param a - num of single digit numbers
	 * @param b - num of double digit numbers
	 */
	public static void createCombinations(List<String[]> pairs) {
		// base case
		System.out.println("List Size: " + pairs.size());
		if (pairs.size() == 1) {
			String [] currPair = pairs.get(0);
			int numericVal_1 = Integer.parseInt(currPair[0]);
			if (!result.contains(currPair[0]) && count_1 < singleDigitNums && numericVal_1 > 0 ) {
				result.add(currPair[0]);
				count_1++;
			}
			System.out.println("Base Case");
			return;
		} 
        
		for (int i = 0; i < pairs.size(); i++) {
			String [] currPair = pairs.get(i);
			System.out.println("For Current Pair: " + currPair[0] + "," + currPair[1]);
			System.out.println("Current Cache: " + cache[0] + "," + cache[1]);
			int numericVal_1 = Integer.parseInt(currPair[0]);
			int numericVal_2 = Integer.parseInt(currPair[1]);	
			//handleSelection(currPair);
			if (!result.contains(currPair[0]) && count_1 < singleDigitNums && numericVal_1 > 0 ) {
				// select 1st one
				System.out.println("  -->Selecting first one: " + currPair[0]);
				result.add(currPair[0]);
				count_1++;
				cache[0] = currPair[0];
				cache[1] = currPair[1];
				pairs.remove(currPair);
				System.out.println("  ----> recursing here: ");
				createCombinations(pairs);
			} else if (!result.contains(currPair[1]) && count_2 < doubleDigitNums && numericVal_2 < 60 && numericVal_2 > 0) {
				// if 1st can't be selected, select 2nd one
				System.out.println("  -->Selecting second one: " + currPair[1]);
				result.add(currPair[1]);
				count_2++;
			    pairs.remove(currPair);
			    System.out.println("  ----> recursing here2: ");
			    createCombinations(pairs);
			} else {
				// 1st one cannot be selected because its either 0 or we have reached limit
				// 2nd of next pair cannot be selected beacause it already exists or is greater than 70
				// so select 2nd of 1st pair
				 System.out.println("  -->Selecting from cache: " + cache[1]);
				 result.remove(cache[0]);
				 count_1--;
				 int numericVal = Integer.parseInt(cache[1]);
				 if (!result.contains(cache[1]) && count_2 < doubleDigitNums && numericVal < 60) {
					 result.add(cache[1]);
					 count_2++;
					 //pairs.add(0, cache);
					 //createCombinations(pairs);
				 }
			}
		}
	}
	
	public static void createCombinations2(List<String[]> pairs) {
		while (pairs.size() != 1) {
			String [] currPair = pairs.get(0);
			int num1 = Integer.parseInt(currPair[0]);
			int num2 = Integer.parseInt(currPair[1]);
			System.out.println("For Current Pair: " + currPair[0] + "," + currPair[1]);
			if (!result.contains(currPair[0]) && count_1 < singleDigitNums && num1 > 0) {
				System.out.println("  -->Selecting first one: " + currPair[0]);
				result.add(currPair[0]);
				count_1++;
				cache[0] = currPair[0];
				cache[1] = currPair[1];
				cache2.add(currPair);
				pairs.remove(currPair);
				createCombinations2(pairs);
			} else if (!result.contains(currPair[1]) && count_2 < doubleDigitNums && num2 > 0 && num2 < 60) {
				System.out.println("  -->Selecting 2nd one: " + currPair[1]);
				result.add(currPair[1]);
				count_2++;
				cache2.add(currPair);
				pairs.remove(currPair);
				createCombinations2(pairs);
			} else {
				// need to do course correction
				result.remove(cache[0]);
				count_1--;
				int numericVal = Integer.parseInt(cache[1]);
				if (!result.contains(cache[1]) && count_2 < doubleDigitNums && numericVal < 60 && numericVal > 0) {
					System.out.println("  -->Selecting From Cache: " + cache[1]);
					result.add(cache[1]);
					count_2++;
					System.out.println("  -->Cache2 size:  " + cache2.size());
					//pairs.remove(currPair);
					for (int i = cache2.size()-1; i >=0 ; i--) {
						pairs.add(cache2.get(i));
					}
					createCombinations2(pairs);
				 }
			}
		}
		
		if (pairs.size() == 1) {
			String [] currPair = pairs.get(0);
			int numericVal_1 = Integer.parseInt(currPair[0]);
			if (!result.contains(currPair[0]) && count_1 < singleDigitNums && numericVal_1 > 0 ) {
				result.add(currPair[0]);
				count_1++;
			}
			//System.out.println("Base Case");
			return;
		} 
	}
	
	public static void handleSelection(String [] currPair) {
		int numericVal_1 = Integer.parseInt(currPair[0]);
		int numericVal_2 = Integer.parseInt(currPair[1]);	
		// check single digit
		if (!result.contains(currPair[0]) && count_1 < singleDigitNums && numericVal_1 > 0) {
			result.add(currPair[0]);
			cache[0] = currPair[0];
			cache[1] = currPair[1];
			
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
