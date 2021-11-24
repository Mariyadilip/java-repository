package com.dp.tabulation;

import java.util.ArrayList;
import java.util.List;

/* 
 * write a function 'bestSum(targetSum, numbers)' that takes in a
 * targetSum and an array of numbers as arguments
 * 
 * The function should return an array containing the shortest combination
 * of numbers that add up to exactly the targetSum
 * 
 * If there is a tie for the shortest combination, you may return any
 * one of the shortest.
 * 
 */

public class BestSum {

	public static void main(String[] args) {
		System.out.println(bestSum(new int[] {5, 3, 2}, 8));
        System.out.println(bestSum(new int[] {2, 6, 7, 1}, 7));
	}
	
	static List<Integer> bestSum(int[] array, int sum){
		
		List<List<Integer>> list = new ArrayList<>(sum + 1);
		
		for(int i=0 ; i<=sum ; i++)list.add(null);
		list.set(0, new ArrayList<Integer>());
		
		for(int i=0 ; i<=sum ; i++) {
			if(list.get(i) != null) {
				for(int j=0 ; j<array.length ; j++) {
					int index = i + array[j];					
					if(index <= sum) {				
				      
						if(list.get(index) == null || list.get(i).size() < list.get(index).size()) {
							list.set(index, new ArrayList<Integer>(list.get(i)));
							list.get(index).add(array[j]);
						}
						
					}
				}
			}
			//System.out.println(list);
		}
		return list.get(sum);
	}
}
