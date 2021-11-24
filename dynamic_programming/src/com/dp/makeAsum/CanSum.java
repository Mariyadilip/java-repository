package com.dp.makeAsum;

import java.util.HashMap;

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
		
		int a[] = {5, 3, 4, 7};
		
		//System.out.println(isSum(a, 7));
		
		System.out.println(cansum(new int[]{5, 3, 4, 7}, 7));
		System.out.println(cansum(new int[] {2, 4}, 7));
		System.out.println(cansum(new int[] {2, 3, 5}, 8));
		//System.out.println(cansum(new int[] {7, 14}, 300));
		System.out.println(canSumDp(new int[] {7, 14}, 300));
		//System.out.println(cansum(new int[] {7, 14}, 300));
	}
	
	private static boolean cansum(int[] array, int target) {
		
		if(target == 0) return true;
		
		for(int i : array) {
			int remainder = target - i;
			if( (remainder >= 0) && (cansum(array, remainder)) ) return true;
		}
		
		return false;
	}
	
	private static boolean canSumDp(int[] array, int target) {
		
	     return dp(array, target, new HashMap<>());
	}
	
	private static boolean dp(int[] array, int target, HashMap<Integer, Boolean> dp) {
		
		if(dp.get(target) != null) return dp.get(target);
		if(target  == 0) return true;
		
		for(Integer i : array) {
			int remainder = target - i;
			if( (remainder >= 0) && dp(array, remainder, dp)) {
				dp.put(remainder, true); 
				return true;
			}
		}
		
		dp.put(target, false);
		return false;
	}
	
	/*       			 My Solution
	 * 
	 * 
	private static boolean isSum(int[] array, int target) {
		return canSum(array, 0, target, 0);
	}
	
	public static boolean canSum(int[] array, int sum, int target, int index) {
		
		if(sum == target)
			return true;
		
		if(index < array.length)
		return canSum(array, sum+array[index], target, index + 1) || canSum(array, sum, target, index + 1);
		
		return false;
	}
	*/
}
