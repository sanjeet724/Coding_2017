/*
Winning Ticket!
Your favorite uncle, Morty, is crazy about the lottery and even crazier about how he picks his “lucky” numbers. 
And even though his “never fail” strategy has yet to succeed, Uncle Morty doesn't let that get him down.
Every week he searches through the Sunday newspaper to find a string of digits that might be potential lottery picks. 
But this week the newspaper has moved to a new electronic format, and instead of a comfortable pile of papers, 
Uncle Morty receives a text file with the stories. Help your Uncle find his lotto picks. Given a large series of number strings, 
return each that might be suitable for a lottery ticket pick.

Note that a valid lottery ticket must have 7 unique numbers between 1 and 59, digits must be used in order, 
and every digit must be used exactly once. For example, given the following strings: 
[ "569815571556", “4938532894754”, “1234567”, “472844278465445”]
Your function should return :
4938532894754 -> 49 38 53 28 9 47 54
1234567 -> 1 2 3 4 5 6 7
*/

// initial try


package dialPad;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LotteryNumbers {

	public static void main(String[] args) {
		String [] numbers = {
				"569815571556", 
				"4938532894754", 
				"1234567",
				"472844278465445",
				"1234560",
				"3457192",
				"3378012",
				"8927138",
				"a678213",
				"as78231",
				"3423189",
				"49385328947546",
				"49385322143547",
				"47385322143547",
				"493853221435a7",
				"49385322143527",
				"49382722143527",
				"49382722143559",
				"49382722143560",
				"-4938272214355",
				"-12345678"
				} ;
		generateLuckyNumbers(numbers);
	}
	
	/**
	 * This function prints our result
	 * @param nums
	 */
	public static void printNumbers(List<String> nums) {
		for (int i = 0; i < nums.size(); i++) {
			System.out.println(nums.get(i));
		}
	}
	
	/**
	 * This function iterates over the input array of strings
	 * @param nums - The input array
	 * @return - A list of the result
	 */
	
	 public static void generateLuckyNumbers(String [] nums) {
		 List<String> LuckyList = new ArrayList<String>();
		 for (String num : nums) {
			 String lucky = getUniqueNumFromString(num);
			 LuckyList.add(lucky);
		 }
		 printNumbers(LuckyList);
	}
	 
	/**
	 * Helper function to get unique numbers from a string
	 * @param num - the string 
	 */
	public static String getUniqueNumFromString(String num) {
		int lenOfInput = num.length();		
		// invalid length
		if (lenOfInput < 7 || lenOfInput > 14) {
			return num + " -> " + "Invalid length of the String";
		} 
		try { 
		    BigInteger numericValue = new BigInteger(num); 
		    if (numericValue.compareTo(BigInteger.ZERO) > 0) { // only +ve numbers
				if (lenOfInput == 7) {
					return getSingleDigitUniqueNums(num);
				} else if (lenOfInput == 14) {
					return getDoubleDigitUniqueNums(num);
				} else {
					return getUniqueNums(num);
				}
		    } else {
		    	return num + " -> " + "Invalid Number";
		    }
		 } catch(NumberFormatException e) { 
		    return num + " -> " + "Not a numeric string";
		 } catch(NullPointerException e) {
		    return num + " -> " + "Null pointers found";
		 }
	}
	
	
	/**
	 * Helper function to create the result string from a list of unique numbers
	 * @param uniqueList - the list
	 * @return - a string or null
	 */
	public static String createLuckyNumString(List<String> uniqueList) {
		if (uniqueList.size() == 7) {
			StringBuilder result = new StringBuilder();
			for (String str : uniqueList) {
				result.append(str);
				result.append(" ");
			}
			return new String(result).trim();
		}
		return null;
	}
	
	/**
	 * Exactly Single Digit
	 * @param s - the input string
	 * @return - String containing the 7 unique numbers(all of which are one digit)
	 * if it satisfies the condition
	 */
	public static String getSingleDigitUniqueNums(String s) {
		HashSet<String> uniqueSet = new HashSet<String>(); // to check duplicates
		List<String> res = new ArrayList<String>(); // to maintain the order
		for (int i = 0; i < s.length(); i++) {
			int numericValue = Character.getNumericValue(s.charAt(i));
			if (numericValue != 0) { // cannot be a zero
				if (!uniqueSet.contains(Character.toString(s.charAt(i)))) {
					uniqueSet.add(Character.toString(s.charAt(i)));
					res.add(Character.toString(s.charAt(i)));
				}
			}
		}
		// check if there are 7 unique numbers
		String result = createLuckyNumString(res);
		if (result != null) {
			return s + " -> " + result;
		} 
		return s + " -> " + "Hard Luck(7 unique numbers not found)";
	}
	
	/**
	 * Exactly double digits
	 * @param s - the input string
	 * @return - String containing the 7 unique numbers(all of which are 2 digits) 
	 * if it satisfies the condition
	 */
	public static String getDoubleDigitUniqueNums(String s) {
		HashSet<String> uniqueSet = new HashSet<String>();
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < s.length(); i+=2) {
			String temp = s.substring(i, i+2); // take 2 digits at a time
			      int numericValue = Integer.parseInt(temp);  // guranteed to be an int
			      if (!uniqueSet.contains(temp) && numericValue < 60) {
			    	  uniqueSet.add(temp);
			    	  res.add(temp);
			      }
		}
		// check if there are 7 unique numbers
		String result = createLuckyNumString(res);
		if (result != null) {
			return s + " -> " + result;
		} 
		return s + " -> " + "Hard Luck(7 unique numbers not found)";
	}
	
	/**
	 * Mix of single an double digits
	 * @param s - the input string
	 * @return String containing the 7 unique numbers if it.
	 *  satisfies the condition
	 */
	public static String getUniqueNums(String s) {
		return s + " -> " + "To Do(Mix of Digits)";
	}
	


}
