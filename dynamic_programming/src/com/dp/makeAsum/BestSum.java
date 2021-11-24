package com.dp.makeAsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 
 * write a function 'bestSum(targetSum, numbers)' that takes in a
 * targetSum and an array of numbers as arguments
 * 
 * The function should return an array containing the shortest combination
 * of numbers that add up to exactly the targetSum
 * 
 * If there is a tie for the shortest combination, you may return any
 * one of the shortest.
 * 
 *  */


public class BestSum {

	public static void main(String[] args) {
		
//		System.out.println(bestSum(new int[] {5, 3, 4, 7}, 7));
//		System.out.println(bestSum(new int[] {2, 3, 5}, 8));
//		System.out.println(bestSum(new int[] {1, 4, 5}, 8));
//		System.out.println(bestSumDP(new int[] {1, 4, 5}, 8, new HashMap<>()));
		//System.out.println(bestSum(new int[] {1, 2, 5, 25}, 100));
		
    	HashMap<Integer, List<Integer>> map = new HashMap<>();

		System.out.println(bestSumDP(new int[] {1, 2, 5, 25}, 100, map));
//		System.out.println(map);
//		
//		HashMap<Integer, List<Integer>> map = new HashMap<>();
//		System.out.println(map);
//		System.out.println(bestSumDP(new int[] {1, 2}, 4, map));
//		System.out.println(map);
		
	}
	
	private static List<Integer> bestSum(int[] array, int target) {
		
		if(target == 0) return new ArrayList<>();
		if(target < 0) return null;
		
		List<Integer> shortest = null;
		
		for(int num : array) {
			int remainder = target - num;
			List<Integer> combination =  bestSum(array, remainder);
			
			if(combination != null) {
				combination.add(num);
				if(shortest == null) shortest = new ArrayList<>();
				if(shortest.isEmpty() || combination.size() < shortest.size()) 
					shortest = combination;
			}
		}
		
		return shortest;
	}
	
	private static List<Integer> bestSumDP(int[] array, int target, HashMap<Integer, List<Integer>> memo){
		
		if(memo.containsKey(target))return new ArrayList<>(memo.get(target)); 
		if(target == 0) return new ArrayList<>();
		if(target < 0) return null;
		
		List<Integer> shortest = null;
		
		for(int num : array) {
			int remainder = target - num;
			List<Integer> combination =  bestSumDP(array, remainder, memo);
			
			if(combination != null) {
				combination.add(num);

				if(shortest == null) shortest = new ArrayList<>();
				if( (shortest.isEmpty()) || (combination.size() < shortest.size()) ) 
					shortest = combination;				     	
			}						

		}	
	 
	    memo.put(target, (shortest == null) ? null : new ArrayList<>(shortest));
	    
		return shortest;		
	}
}
