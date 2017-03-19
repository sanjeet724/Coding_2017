/* Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */

package chapter1;

import java.util.*;

class Question1_try {

	public static void main(String[] args) {
		String someStr = "this is the new Shit";
		Hashtable<Character, Integer> myMap = new Hashtable<Character,Integer>();
		Boolean duplicate = false;
		for (int i = 0; i < someStr.length(); i++ ) {
			int count = 1;
			if (myMap.containsKey(someStr.charAt(i))) {
				myMap.put(someStr.charAt(i), count++);
				duplicate = true;
			} else {
				myMap.put(someStr.charAt(i), count);
			}
		}
		if (duplicate) {
			System.out.println("String has duplicate characters");
		}
	}

}
