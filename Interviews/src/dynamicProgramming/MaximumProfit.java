package dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 */

//  Profit array is - [0,-6,4,-2,3,-2] for Input: [7, 1, 5, 3, 6, 4]
//  Question reduces to find max subarray of profit array

public class MaximumProfit {
	static Integer [] input = {7, 1, 5, 3, 6, 4};
	//static Integer [] input = {7, 6, 4, 3, 1};
	
	public static void main(String[] args) {
		Integer dp [] = new Integer[input.length];
		dp[0] = 0; // initialize dp
		// dp[i] holds the profit if sold on day i
		for (int i = 1; i < input.length; i++) {
			int profit = input[i] - input[i-1];
			if (dp[i-1] + profit > profit) {
				dp[i] = dp[i-1] + profit;
			} else {
				dp[i] = profit; // don't sell
			}
		}
		Integer sol = Collections.max(Arrays.asList(dp));
		System.out.println("Max profit is : " + sol);
	}

}
