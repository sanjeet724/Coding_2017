package chapter1;

// String compression

public class Question5_sol {

	public static void main(String[] args) {
		String unCompressed = "aabccccaaaaa";
		String compressed = compressString_1(unCompressed);
		System.out.println("Compressed String is naive method is: " + compressed);
		String compressed2 = compressStringUsingBuffer(unCompressed);
		System.out.println("Compressed String is StringBuffer is: " + compressed2);
		String compressed3 = compressWithoutBuffer(unCompressed);
		System.out.println("Compressed String without StringBuffer is: " + compressed3);
	}
	
	// lets use string buffer
	public static String compressStringUsingBuffer(String str) {
		int size = countCompression(str);
		if (size > str.length()) {
			return str;
		}
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else { // insert char count and update last char
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		// last set of repeated characters won't be set in the loop
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}
	
	private static int countCompression(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	// without string buffer
	private static String compressWithoutBuffer(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str; 
		}
		char [] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				// update the repeated character count
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		// update last set of repeated characters
		index = setChar(array,last,index,count);
		return String.valueOf(array);
	}
	
	private static int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		char [] cnt = String.valueOf(count).toCharArray();
		for (char x: cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
	
	
	// naive method
	public static String compressString_1(String str) {
		String myStr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count ++;
			} else {
				myStr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return myStr;
	}
	
}
