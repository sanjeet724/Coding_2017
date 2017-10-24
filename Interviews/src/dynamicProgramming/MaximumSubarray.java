package dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
	//static Integer [] input = {-2,1,-3,4,-1,2,1,-5,4};
	//static Integer [] input = {-2,-1,-8,-5,4,-3,-7,-9};
	static Integer [] input = {0,-6,4,-2,3,-2};
	
	public static void main(String[] args) {
		Integer [] dp = new Integer[input.length]; // dp holds the continous sum for input[i]
		dp[0] = input[0]; // initialize the dp
		for (int i = 1; i < input.length; i++) {
			if (dp[i-1] + input[i] > input[i]) {
				dp[i] = dp[i-1] + input[i];
			} else {
				dp[i] = input[i];
			}
		}
		Integer sol = Collections.max(Arrays.asList(dp));
		System.out.println("Value of Max sub array is: " + sol);
	}

}
