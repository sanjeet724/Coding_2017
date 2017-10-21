package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
The longest increasing subsequence problem is a problem where we want to find a longest subsequence
of a given sequence in which the subsequence elements are in sorted order. Note that
a subsequence can skip elements in the original sequence.
e.g :
Input -  8,3,5,2,4,9,7,11
Sol - 4, we have 2 such sequences(3,5,9,11 & 2,4,9,11)
See MIT 6.006 Fall 2011 recitation 20
*/

public class LongestSubsequence {
	static Integer [] input = {8,3,5,2,4,9,7,11};
	
	public static void main(String[] args) {
		// start from the end
		Integer [] dp = new Integer[input.length];
		for (int i = input.length-1; i >= 0; i--) {
			List<Integer> choices = new ArrayList<Integer>();
			choices.add(1); // if nothing can be selected for that number
			for (int j = i+1; j < input.length; j++) {
				if (input[j] > input[i]) {
					choices.add(dp[j]+1);
				}
			}
			dp[i] = Collections.max(choices);
		}
		int sol = Collections.max(Arrays.asList(dp));
		System.out.println("Longest Subsequence is: " + sol);
	}

}
