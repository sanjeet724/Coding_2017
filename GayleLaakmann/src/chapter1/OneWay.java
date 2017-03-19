package chapter1;
/*
One Away: There are three types of edits that can be performed on strings: 
1)insert a character
2)remove a character
3)replace a character. 
Given two strings, write a function to check if they are one edit (or zero edits) away.
EXAMPLE
pale, ple -> true 
pales, pale -> true 
pale, bale -> true 
pale, bake -> false
*/

public class OneWay {

	public static void main(String[] args) {
		String str1 = "pale";
		String str2 = "pales";
		if (oneWayEdit(str1,str2)){
			System.out.println("one way edit - true");
		} else {
			System.out.println("one way edit - false");
		}
	}
	
	public static boolean checkReplace(char [] A, char [] B) {
		boolean oneEdit = false;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != B[i]) {
				if (oneEdit) {
					return false;
				}
				oneEdit = true;
			}
		}
		return oneEdit;
	}
	
	public static boolean checkInsert(char[] longer, char [] shorter) {
		int index1 = 0; // to track index of longer
		int index2 = 0; // to track index of shorter
		while (index2 < shorter.length && index1 < longer.length) {
			if (longer[index1] != shorter[index2]) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	public static boolean oneWayEdit(String str1, String str2) {
		boolean checkOneEdit = false;
		if (str1.length() == str2.length()) {
			checkOneEdit = checkReplace(str1.toCharArray(),str2.toCharArray());
		} else if (str1.length() + 1 == str2.length()) {
			checkOneEdit = checkInsert(str1.toCharArray(),str2.toCharArray());
		} else if (str1.length() - 1 == str2.length()) {
			checkOneEdit = checkInsert(str2.toCharArray(),str1.toCharArray());
		}
		return checkOneEdit;
	}

}
