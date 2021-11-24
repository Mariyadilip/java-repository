package com.dp.makeAsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * write a function 'howSum(targetSum, numbers)' that takes in a targetSum
 * and a array of numbers as arguments.
 * 
 * The function should return an array containing any combination of
 * elements that add up to exactly the targetSum. If there is no 
 * combination that adds up to targetSum, then return null. 
 * 
 *  If there are multiple combination possible, you may return any single one
 *  
 *  
 */

public class HowSum {

	public static void main(String[] args) {
		
//		System.out.println(addSum(new int[] {2, 3}, 7));
//		System.out.println(addSum(new int[] {5, 3, 4, 7}, 7));
//		System.out.println(addSum(new int[] {2, 4}, 7));
//		System.out.println(addSumDp(new int[] {2, 3, 5}, 8));
		System.out.println(addSumDp(new int[] {7, 14}, 300));
	}
	
	private static List<Integer> addSum(int[] array, int target){
		
		if(target == 0) return new ArrayList<>();
		if(target < 0) return null;
		
		for(Integer num : array) {
			
			int remainder = target - num;
			List<Integer> numbers = addSum(array, remainder);
			
			if(numbers != null) { numbers.add(num); return numbers;}
		}
		
		return null;
	}
	
	private static List<Integer> addSumDp(int[] array, int target){
		
		return dp(array, target, new HashMap<Integer, List<Integer>>());
	}
	
	private static List<Integer> dp(int[] array, int target, HashMap<Integer, List<Integer>> memo){
		
	    if(memo.containsKey(target))return memo.get(target);
		if(target == 0) return new ArrayList<>();
        if(target < 0) return null;
		
		for(Integer num : array) {
			
			int remainder = target - num;
			List<Integer> numbers = dp(array, remainder, memo);
			
			if(numbers != null) { 
				numbers.add(num);
				memo.put(target, numbers);
				return numbers;
				}
		}
		
		memo.put(target, null);
		return null;
	}
}
