package chapter1;

/*
String Rotation:Assume you have a method isSubstring which checks if one word is a substring of another. 
Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to 
isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
*/


public class Question8_sol {

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		if (isRotation(s1,s2)) {
			System.out.println("s2 is rotation of s1");
		} else {
			System.out.println("Not a rotation");
		}
	}
	/*  s1 = xy
	 *  s2 = yx (rotated)
	 *  yx is always a substring of xyxy
	 */
	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String s1s1 = s1+s1;
			return isSubString(s1s1,s2);
		}
		return false;
	}
	
	private static boolean isSubString (String s1, String s2) {
		if (s1.toLowerCase().contains(s2.toLowerCase())) {
			return true;
		}
		return false;
	}

}
