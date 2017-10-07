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


package dynamicProgramming;

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
				"3423189"
				} ;
		List<String> luckyNumbers = generateLuckyNumbers(numbers);
		printNumbers(luckyNumbers);
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
	
	 public static List<String> generateLuckyNumbers(String [] nums) {
		 List<String> LuckyList = new ArrayList<String>();
		 for (String num : nums) {
			 String lucky = getUniqueNumFromString(num);
			 LuckyList.add(lucky);
		 }
		 return LuckyList;
	}
	 
	/**
	 * Helper function to get unique numbers from a string
	 * @param num - the string 
	 */
	public static String getUniqueNumFromString(String num) {
		int lenOfInput = num.length();		
		// invalid case
		if (lenOfInput < 7 || lenOfInput > 14) {
			return num + " -> " + "Hard Luck";
		} 
		
		if (lenOfInput == 7) {
			return getSingleDigitUniqueNums(num);
		} else if (lenOfInput == 14) {
			return getDoubleDigitUniqueNums(num);
		} else {
			return getUniqueNums(num);
		}
	}
	
	/**
	 * Exactly Single Digit
	 * @param s
	 * @return
	 */
	public static String getSingleDigitUniqueNums(String s) {
		HashSet<Character> uniqueSet = new HashSet<Character>(); // to check dups
		List<Character> res = new ArrayList<Character>(); // to maintain the order
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) { // only if its a digit
				int numericValue = Character.getNumericValue(s.charAt(i));
				if (numericValue != 0) {
					if (!uniqueSet.contains(s.charAt(i))) {
						uniqueSet.add(s.charAt(i));
						res.add(s.charAt(i));
					}
				}
			}
		}
		
		if (res.size() == 7) {
			StringBuilder result = new StringBuilder();
			for (Character c : res) {
				result.append(c);
				result.append(" ");
			}
			return s + " -> " + new String(result).trim();
		} else {
			return s + " -> " + "Hard Luck";
		}
		
	}
	
	/**
	 * Exactly double digits
	 * @param s
	 * @return
	 */
	public static String getDoubleDigitUniqueNums(String s) {
		return  s + " -> " + "To Do(exactly double digits)";
	}
	
	/**
	 * Mix of single an double digits
	 * @param s
	 * @return
	 */
	public static String getUniqueNums(String s) {
		return s + " -> " + "To Do(Mix of Digits)";
	}
	


}
