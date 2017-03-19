package chapter1;

/*replace spaces with '%20' in string */

public class Question4_sol {

	public static void main(String[] args) {
		String givenString = "Mr  John Smith       ";
		System.out.println("Given String's length is: " + givenString.length());
		int len = 14;
		String replacement = "%20";
		String replaced = replaceWith(givenString,replacement, len);
		System.out.println("Replaced String is: " + replaced);
	}
	
	public static String replaceWith(String inputStr, String replacement, int len) {
		System.out.println("Actual length is: " + len);
		char [] inputStrChar = inputStr.toCharArray();
		int spaceCount = 0, newlength, i;
		for (i = 0; i < len; i++) {
			if (inputStrChar[i] == ' ') {
				spaceCount++;
			}
		}
		System.out.println("Space Count is: " + spaceCount);
		System.out.println("Replacement String's length: " + replacement.length());
		newlength = len + (spaceCount * (replacement.length()-1));
		System.out.println("New length is: " + newlength);
		inputStrChar[newlength] = '\0';
		for (i = len-1; i >= 0; i-- ) {
			if (inputStrChar[i] == ' ') {
				inputStrChar[newlength-1] = '0';
				inputStrChar[newlength-2] = '2';
				inputStrChar[newlength-3] = '%';
				newlength = newlength-3;
			} else {
				inputStrChar[newlength-1] = inputStrChar[i];
				newlength = newlength-1;
			}
		}
		return new String(inputStrChar);
	}

}
