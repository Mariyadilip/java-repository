package com.dp;

import java.util.HashMap;

public class Fibonacci {

	public static void main(String[] args) {
		
		System.out.println(fib(6));
		System.out.println(fib(10));
		System.out.println(fib(15));
		//System.out.println(fib(50)); cannot solve using normal recursive approach :: time complexity : O(2^n) = exponential;
		
		System.out.println(fibDP(50)); //using DP :: time complexity : O(n) = linear;
		
	}
	
	private static int fib(int n) {
		if(n <= 2)
		return n;
		return fib(n - 1) + fib(n - 2);
	}
	
	private static int fibDP(int n) {
		HashMap<Integer, Integer> memo = new HashMap<>();
		return dp(n, memo);
	}
	
	private static int dp(int n, HashMap<Integer, Integer> memo) {
		
		if(memo.get(n) != null)return memo.get(n);
		if(n <= 2) return n;
        memo.put(n, dp(n - 1, memo) + dp(n - 2, memo));
        return memo.get(n);
	}
}
