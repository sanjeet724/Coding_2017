package dialPad;


import java.util.LinkedHashSet;

public class Trials {

	public static void main(String[] args) {
		String num = "4938532894754";
//		String num = "123456789";
		getUniqueNums(num);
	}
	
	public static void getUniqueNums(String num) {
		int doubleDigitNums = num.length() % 7;
		int singleDigitNums = 7 - doubleDigitNums;
		System.out.println("Number of double digit numbers : " + doubleDigitNums);
		System.out.println("Number of single digit numbers : " + singleDigitNums);
		LinkedHashSet<String> singles = new LinkedHashSet<String>(); 
		LinkedHashSet<String> doubles = new LinkedHashSet<String>(); 
		LinkedHashSet<String> combo = new LinkedHashSet<String>();

		for (int i = 0; i < num.length(); i++) {
			String curr = Character.toString(num.charAt(i));
			int numericValue = Integer.parseInt(curr);
			if (!singles.contains(curr) && numericValue != 0) { // single digit cannot be 0
				singles.add(curr);
				combo.add(curr);
			}
			for (int j = i; j < num.length()-1; j++) {
				String temp = num.substring(j, j+2);
				int doubleDigitNumericVal = Integer.parseInt(temp);
				if (!doubles.contains(temp) && doubleDigitNumericVal < 60) {
						doubles.add(temp);
						combo.add(temp);
				} 
				
			}
		}
		System.out.println("Single Digit Candidates: ");
		printCandidates(singles);
		System.out.println("Double Digit Candidates: ");
		printCandidates(doubles);
//		System.out.println("Candidates: ");
//		printCandidates(combo);
		
		String [] doubleArray = doubles.toArray(new String[0]);
		String [] singleArray = singles.toArray(new String[0]);
		
	}
	
	public static void printCandidates(LinkedHashSet<String> candidates) {
		for (String c : candidates) {
			System.out.println(c);
		}
	}
	
}
