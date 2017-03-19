package chapter1;

/*
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin­drome. 
A palindrome is a word or phrase that is the same  forwards and backwards. 
A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)
*/

public class PermutationOfPalindrome {

	public static void main(String[] args) {
		String phrase = "Tact Coa";
		if (isPermutationOfPalindrome(phrase)) {
			System.out.println("String is permutation of palindrome");
		} else {
			System.out.println("String is not a permutation of palindrome");
		}
		// optimization 1
		if (isPermutationOfPalindrome_opt(phrase)) {
			System.out.println("OPT1 - String is permutation of palindrome");
		} else {
			System.out.println("OPT1 - String is not a permutation of palindrome");
		}
		// optimization 2
		// To do using bit vector method
	}
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		int [] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	public static boolean isPermutationOfPalindrome_opt(String phrase) {
		int countOdd = 0;
		int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c) ;
				if (x != -1) {
					table[x]++;
					if (table[x] % 2 == 1) {
						countOdd++;
					} else {
						countOdd--;
					}
				}
		}
		return countOdd <= 1;
	}
	
	/*
	 * Check that no more than one character has odd count
	 */
	public static boolean checkMaxOneOdd(int [] table) {
		boolean foundOdd =  false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

	
	/* Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
	 * This is case insensitive. Non-letter characters map to -1.
	 */
	
	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <=z ) {
			return val-a;
		}
		return -1;	
	}
	

	public static int [] buildCharFrequencyTable(String phrase) {
		int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}
	

}
