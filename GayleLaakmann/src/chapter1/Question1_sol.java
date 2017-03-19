package chapter1;
import java.util.*;

public class Question1_sol {

	public static void main(String[] args) {
		String someString = createARandomString();
		System.out.println("Random String : " + someString);
		System.out.println("\nLength: " + someString.length());
		if (isUniqueString(someString)) {
			System.out.println("String has unique characters");
		} else {
			System.out.println("String has non-unique characters");
		}
		// test for a unique character
		/*
		if (isUniqueString("IamGoD")) {
			System.out.println("String has unique characters");
		} else {
			System.out.println("String has non-unique characters");
		}
		*/
	}
	
	public static boolean isUniqueString(String str){
		if (str.length() > 256) {
			return false;
		}
		
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			//System.out.println("\nCharacter is: " + str.charAt(i));
			//System.out.println("\nInt Value is: " + (int)str.charAt(i));
			int val = str.charAt(i);
			if (char_set[val]) {
				System.out.println("\nDuplicate character is: " + str.charAt(i));
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	public static String createARandomString() {
		Random rng = new Random();
		int len = rng.nextInt(255);
		char[] text = new char[len];
		for (int i = 0; i < len; i++){
			text[i] = (char)(rng.nextInt(255));
		}
		return new String(text);
	}
}
