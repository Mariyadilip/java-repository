package com.hackerrank;

import java.util.Arrays;
import java.util.List;

//problem statement; given an array [3, 4, 6, 6, 3] we need to make every element same in minimum move
//constraint 1 : in each move every element must be incremented by 1 expect one element;

//[3, 4, 6, 6, 3]  ------ o/p - 7 ,(10, 10, 10, 10, 10)
//[5, 6, 8, 8, 5) --------      7 ,(12, 12, 12, 12, 12)

public class EquateEveryElement {

	public static void main(String[] args) {
		
		List<Integer> numbers  = Arrays.asList(3, 1, 2, 3);
		System.out.println("\ncount : " +new EquateEveryElement().findMinimumMove(numbers));
		System.out.println("\n\nresult : "+numbers);
		
	  
	}
	
	public int findMinimumMove(List<Integer> numbers) {
		int count = 0;
		
		while(true) {
			int[][] array = findMinAndMax(numbers);
			
			for(int i=0 ; i<numbers.size() ; i++) 
				if(array[0][2] != i)
					numbers.set(i, numbers.get(i) + (array[0][0] - array[0][1])) ;		
			
			if((Math.abs(array[0][0] - array[0][1])) == 1)
				return count + 1;
			
			count = count + (array[0][0] - array[0][1]);
		
		}
	}
	
	public int[][] findMinAndMax(List<Integer> numbers){
		int[][] array = new int[1][3];
		int max = numbers.get(0), min = numbers.get(0), index = 0;
		
		for(int i=0 ; i<numbers.size() ; i++) {
			int element = numbers.get(i);
			if(element > max) {
				max = element;
				index = i;
			}
			min = Math.min(min, element);
		}
		
		array[0][0] = max;
		array[0][1] = min;
		array[0][2] = index;
		
		return array;
	}

}
