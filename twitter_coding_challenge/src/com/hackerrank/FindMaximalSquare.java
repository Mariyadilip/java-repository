package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMaximalSquare {

	static int maxsize = 0;
	
	public static void main(String[] args) {
		
		List<List<Integer>> numbers = new ArrayList<>();
		List list1 = Arrays.asList(1, 1, 1, 1, 1);
		List list2 = Arrays.asList(1, 1, 1, 1, 1);
		List list3 = Arrays.asList(1, 1, 1, 1, 0);
		List list4 = Arrays.asList(1, 1, 1, 1, 1);
		List list5 = Arrays.asList(1, 1, 1, 0, 0);
		List list6 = Arrays.asList(1, 1, 1, 1, 1);
		
		numbers = Arrays.asList(list1, list2, list3, list4, list5, list6);
		
		for(List<Integer> l1 : numbers) {
			for(Integer i : l1)
				System.out.print(i+" ");
			System.out.println();
		}
		
		for(int i=0 ; i<numbers.size() ; i++) {
			for(int j=0 ; j<numbers.get(i).size() ; j++)
				if(numbers.get(i).get(j) == 1)
					maxsize = Math.max(findSquare(numbers, i, j, 1), maxsize);
		}
		
		System.out.println("\n\nMax size : "+maxsize);
	}
	
	public static int findSquare(List<List<Integer>> numbers, int row, int col, int size) {
		
		if(row + 1 < numbers.size() && col + 1 < numbers.get(0).size()) 
			if(numbers.get(row+1).get(col+1) == 1) 
				if(path(numbers, row+1, col+1, row-size+1 , col-size+1)) 
				   return findSquare(numbers, row+1, col+1, size+1);
		
		return size;
	}
	
	public static boolean path(List<List<Integer>> numbers, int row, int col, int r, int c) {
		
		for(int i=col ; i>=c ; i--) 
			if(numbers.get(row).get(i) == 0)
				return false;
		
		for(int i=row ; i>=r ;i--)
			if(numbers.get(i).get(col) == 0)
				return false;
		
		return true;
	}
}
