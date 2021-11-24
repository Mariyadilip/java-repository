package com.dp;

import java.util.HashMap;

/* say that you are grid traveller on 2d grid. you begin at the top-left corner and your goal is to travel to the bottom-right
    you can move only down or right
    
    ques : In how many ways you are able to travel to the goal in a m * n grid ?
    
     write a function gridTraveller(m, n) to this
*/
public class GridTraveller {

	public static void main(String[] args) {
		
		System.out.println(grid(1, 2));
		System.out.println(grid(2, 1));
		System.out.println(grid(3, 3));
		
		//System.out.println(grid(18, 18)); //time complexity : O(2^(m+n)) 
		System.out.println(gridDP(18, 18)); //time complexity : O(m*n)
	}
	
	private static int grid(int row, int col) {
		
		if(row == 0 || col == 0)
			return 0;
		if(row == 1 && col == 1)
			return 1;
		
		return grid(row - 1, col) + grid(row, col - 1);
	}
	
	private static long gridDP(int row, int col) {
		
		HashMap<String, Long> memo = new HashMap<>();
		return dp(row, col, memo);
	}
	
	private static long dp(int row, int col, HashMap<String, Long> memo) {
		
		String position = "";
		if(row < col) position = row+","+col;
		else position = col+","+row;
		
		if(memo.get(position) != null) return memo.get(position);
		if(row == 0 || col == 0) return 0;
		if(row == 1 && col == 1) return 1;
		
		memo.put(position, dp(row - 1, col, memo) + dp(row, col - 1, memo));
		return memo.get(position);
	}
}
