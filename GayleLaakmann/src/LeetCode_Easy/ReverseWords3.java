package LeetCode_Easy;

public class ReverseWords3 {
	
	public static void main(String[] args) {
		String str = "Let's take LeetCode contest";
		char [] strChar = str.toCharArray();
		for (int i = 0; i < strChar.length ; i++) {
			if (strChar[i] !=  ' ') {
				int j = i;
				while (j+1 < strChar.length && strChar[j+1] != ' ') {
					j++;
				}
				reverseWord(strChar, i,j);
				i = j;
			}
		}
		String reversed = new String(strChar);
		System.out.println("Original is : " + str);
		System.out.println("Reversed is : " + reversed);
	}
	
	public static void reverseWord (char [] strArray, int start, int end) {
		while (end > start) {
			char temp = strArray[start];
			strArray[start] = strArray[end];
			strArray[end] = temp;
			end--;
			start++;
		}
	}

}
