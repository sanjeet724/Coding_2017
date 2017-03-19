package chapter1;
/*reverse a string*/

public class Question2 {

	public static void main(String[] args) {
		String someString = "I am a happy guy";
		String reversed = reverseString(someString);
		System.out.println("Reversed String: " + reversed);
		String reversedInPlace = stringReverseInPlace("DoghMa");
		System.out.println("In Place Reversed String: " + reversedInPlace);
	}
	
	public static String reverseString(String str) {
		char[] temp = new char[str.length()];
		int len = str.length()-1;
		for (int i = len; i >=0; i--) {
			temp[len-i] = str.charAt(i);
		}
		return new String(temp);
	}
	
	/**
	 * Reverse the specified string, in-place.
	 * @param string
	 * @return
	 */
	public static String stringReverseInPlace(String mystring) {
	  char [] string = mystring.toCharArray();
	  for(int i = 0, j = string.length - 1; i < string.length / 2; i++, j--) {
	    char c = string[i];
	    string[i] = string[j];
	    string[j] = c;
	  }
	  return new String(string);
	}

}
