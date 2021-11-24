package com.dp.tabulation;

import java.util.ArrayList;
import java.util.List;

/*
 * write a function 'howSum(targetSum, numbers)' that takes in a targetSum
 * and a array of numbers as arguments.
 * 
 * The function should return an array containing any combination of
 * elements that add up to exactly the targetSum. If there is no 
 * combination that adds up to targetSum, then return null. 
 * 
 *  If there are multiple combination possible, you may return any single one *  
 *  
 */

public class HowSum {

	public static void main(String[] args) {
		
		System.out.println(howSum(new int[] {5, 3, 2}, 8));
	}
	
	static List<Integer> howSum(int[] array, int sum){
		
		List<List<Integer>> list = new ArrayList<List<Integer>>(sum + 1);
		for(int i=0 ; i<=sum ; i++)list.add(null);
		list.set(0, new ArrayList<>());
		
		for(int i=0 ; i<=sum ; i++) {
			if(list.get(i) != null) {
			   for(int j=0 ; j<array.length ; j++) {
				   if(i + array[j] <= sum) {
					   
					   int index = i + array[j];
                       list.set(index, new ArrayList<Integer>(list.get(i)));	
					   list.get(index).add(array[j]);
				   }
			   }
			}
		}
		
//		System.out.println(list);
		return list.get(sum);
	}
}
