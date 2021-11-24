package com.dp.tabulation;

/*
 * say that you are a traveler on a 2D grid. You begin in 
 * the top-left corner and your goal is to travel to the 
 * bottom-right corner. you may only move down or right.
 * 
 * In how many ways can you travel to the goal on a grid
 * with dimensions m * n?
 * 
 * write a function 'gridTraveler(m, n)' that calculates this.
 * 
 * 
 */

public class GridTraveller {

	public static void main(String[] args) {
		System.out.println(gridTraveller(3, 3));
		System.out.println(gridTraveller(18, 18)); //2333606220
		
		System.out.println(gridTraveller1(3, 3));
		System.out.println(gridTraveller1(18, 18)); //2333606220
	}
	
	     //My approach
	static long gridTraveller(int m, int n) {
		long[][] grid = new long[m + 1][n + 1];
		grid[1][1] = 1;
		
		for(int i=1 ; i<=m ; i++) {
			for(int j=1 ; j<=n ; j++) {
				 grid[i][j] += grid[i-1][j] + grid[i][j - 1];
			}
		}
		return grid[m][n];
	}
	
	
	 //youtube approach
	static long gridTraveller1(int m, int n) {
		long[][] grid = new long[m + 1][n + 1];
		grid[1][1] = 1;
		
		for(int i=0 ; i<=m ; i++) {
			for(int j=0 ; j<=n ; j++) {
				if(j+1 <= n)
				grid[i][j + 1] += grid[i][j];
				if(i+1 <= m)
			    grid[i+1][j] += grid[i][j];
			}
		}
		return grid[m][n];
	}
}
