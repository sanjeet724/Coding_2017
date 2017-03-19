package chapter1;

import java.util.Arrays;
import java.util.HashMap;

/*check if one string is permutation of the other */

public class Question3 {

	public static void main(String[] args) {
		String str1 = "someString";
		String str2 = "Stringsome";
		if (isAnagram(str1,str2)) {
			System.out.println("Strings are permutations");
		} else {
			System.out.println("Strings are not permutations");
		}
		// method 2
		if (testPermutation("yoyooo", "oooooy")) {
			System.out.println("2nd Method - Strings are permutations");
		} else {
			System.out.println("2nd Method - Strings are not permutations");
		}
	}
	
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		char [] str1Array = str1.toCharArray();
		char [] str2Array = str2.toCharArray();
		Arrays.sort(str1Array);
		Arrays.sort(str2Array);
		String sortedStr1 = new String(str1Array);
		String sortedStr2 = new String(str2Array);
		if (sortedStr1.equals(sortedStr2)) {
			return true;
		}
		return false;
	}
	
	// method 2
	
	public static boolean testPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		HashMap<Character, Integer> str1CountMap = setCharacterCounts(str1);
		HashMap<Character, Integer> str2CountMap = setCharacterCounts(str2);
		if (str1CountMap.equals(str2CountMap)) {
			return true;
		}
		return false;
	}
	
	private static HashMap<Character,Integer> setCharacterCounts(String str) {
		HashMap <Character, Integer> charCounts = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			Integer count = charCounts.get(str.charAt(i));
			if (count != null) {
				count++;
				charCounts.put(str.charAt(i), count);
			} else {
				charCounts.put(str.charAt(i), 1);
			}
		}
		return charCounts;
	}

}
