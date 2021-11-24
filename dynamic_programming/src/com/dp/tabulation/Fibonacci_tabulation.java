package com.dp.tabulation;

/*
 * write a function 'fib(n)' that takes in a number as an argument.
 * The function should return the n-th number of the fibonacci sequence.
 * 
 * The 0th number of the sequence is 0.
 * The 1st number of the sequence is 1.
 * 
 * To generate the next number of the sequence, we sum the previous two.
 * 
 * 
 * n       :0, 1, 2, 3, 4, 5, 6,  7,  8,  9, .....
 * fin(n)  :0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ......
 */
public class Fibonacci_tabulation {

	public static void main(String[] args) {
		
		System.out.println(fib(8));
	}
	
	static int fib(int n) {
		
		int[] array = new int[n + 1];
		
		array[1] = 1;
		
		for(int i=0 ; i<=n ; i++) {			
			if(i+1 <= n)
			array[i + 1] += array[i];
			if(i+2 <= n)
			array[i + 2] += array[i];
		}
		
		return array[n];
	}
}
