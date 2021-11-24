package com.dp.tabulation;

/*
 * write a function 'canSum(targetsum, array)' that takes in a targetSum
 * and array of numbers as arguments;
 * 
 * The function should return a boolean indicating whether or not it is 
 * possible to generate the targetSum using numbers from the array.
 * 
 * you may use an element of the array as many times as needed.
 * 
 * you may assume that all input numbers are non-negative;
 * 
 */

public class CanSum {

	public static void main(String[] args) {
		
		System.out.println(canSum(new int[] {5, 3, 4}, 7));
		System.out.println(canSum(new int[] {2, 3, 2}, 4));
		System.out.println(canSum(new int[] {4, 4}, 8));
		System.out.println(canSum(new int[] {7, 14}, 300));
	}
	
	static boolean canSum(int[] array, int sum) {
		
		boolean[] dp = new boolean[sum + 1];
		for(int i=0 ; i<=sum ;i++) dp[i] = false;		
		dp[0] = true;
		
		for(int i=0 ;i<=sum ; i++) {
			for(int j=0 ; j<array.length ; j++) {
				if(dp[i] && (i + array[j] <= sum) )
				 dp[i + array[j]] = dp[i];
			}
		}

		return dp[sum];
	}
}
