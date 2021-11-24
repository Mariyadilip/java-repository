package com.dp.tabulation;

import java.util.ArrayList;
import java.util.List;

					   //CAN CONSTRUCT

/*                   
 * write a function 'canConstruct(target, wordBank)' that accepts
 * a target String and an array of Strings.
 * 
 * The function should return a boolean indicating whether or not 
 * the 'target' can be constructed by concatenating elements of the 
 * 'wordBank' array.
 * 
 * you may reuse elements of 'wordBank' as many times as needed.
 * 
 */
 
                         //COUNT CONSTRUCT
/*
 * write a function 'countConstruct(target, wordBank)' that accepts a target String
 *and an array of Strings.
 *
 * 
 * The function should return the number of ways that the 'target' can
 * be constructed by concatenating elements of the 'wordBank' array
 * 
 * 
 * You may reuse elements of 'wordBank' as many times as needed.
 * 
 */

						//ALL CONSTRUCT
/*
 * write a function 'allConstruct(target, wordBank)' that accepts a target String and an array of Strings.
 * 
 * The function should return a 2D Array containing all of the ways that the 'target'
 * can be constructed by concatenating elements of the 'wordBank' array.
 * Each element of the 2D array should represent one combination that constructs the 'target'
 * 
 * 
 * you may reuse elements of 'wordBank' as may times as neeeded.
 */

public class CanConstruct {

	public static void main(String[] args) {
	
		System.out.println(canConstruct("aabc", List.of("a", "b", "d")));
//		System.out.println(canConstruct("aabc",  List.of("a", "bc")));
//		System.out.println(canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
//		System.out.println(canConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
//		System.out.println(canConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
//		
//		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
//				List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
//		
//		System.out.println(countConstruct("aabc",  List.of("a", "bc")));
//		System.out.println(countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
//		System.out.println(countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
//		System.out.println(countConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
//		
//		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
//				List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
//		
		//System.out.println(countConstruct("aabc", List.of("a", "aa", "bc")));
		
		
		System.out.println(allConstruct("aabc",  List.of("a", "bc")));
		System.out.println(allConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
		System.out.println(allConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
		System.out.println(allConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
		
		System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
				List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
		
		//System.out.println(allConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef", "c")));
		
		
	}
	
	static boolean canConstruct(String target, List<String> wordBank) {
		
		boolean[] dp = new boolean[target.length() + 1];
		dp[0] = true;
		
		for(int i=0 ; i<=target.length() ; i++) {
			
			if(dp[i])
			for(String word : wordBank) {
			if(i + word.length() <= target.length())
			  if(target.substring(i, i + word.length()).equals(word)) {				 
				  dp[i + word.length()] = true;
			  }
			}
		}
		return dp[target.length()];
	}
	
	static int countConstruct(String target, List<String> wordBank) {
		int[] count = new int[target.length() + 1];
		count[0] = 1;
		
		for(int i=0 ; i<=target.length() ; i++) {
			if(count[i] != 0) {				
				for(String word : wordBank) {
					if(i + word.length() <= target.length()) {
					 String temp = target.substring(i, i + word.length());
					 if(temp.equals(word)) {
						 count[i + word.length()] += count[i];
					 }
					}
				}
			}
		}
		
		return count[target.length()];
	}
	
	static List<List<String>> allConstruct(String target, List<String> wordBank){
         
       List<List<List<String>>> dp = new ArrayList<>(target.length() + 1);
       //System.out.println(dp);
       
       for(int i = 0 ;i<=target.length() ; i++)dp.add(new ArrayList<List<String>>());
      // System.out.println(dp);

       for(int i=0 ; i<=target.length() ; i++)dp.get(i).add(null);
      // System.out.println(dp);

       dp.get(0).set(0, new ArrayList<>());
      // System.out.println(dp);
       
       
       for(int i=0 ; i<=target.length() ; i++) {
    	   
    	  if(dp.get(i).get(0) != null)
    	  for(String word : wordBank) {
    		  if(i + word.length() <= target.length()) {
    		   String temp = target.substring(i, i + word.length());
    		   if(temp.equals(word)) {
    			  // System.out.println(word);
    			 List<List<String>> t = new ArrayList<List<String>>();
    			 
    			 for(List<String> tt : dp.get(i)) 
    				 t.add(new ArrayList<String>(tt));
    			 
//    			 System.out.println("Before T : "+t);
//    			 System.out.println(dp);
    			 for(List<String> tt : t) tt.add(word);
    			 //System.out.println("After T : "+t);
    		
    			// System.out.println(dp.get(i + word.length()));
    			 if(dp.get(i + word.length()).get(0) == null) dp.set(i + word.length(), t);
    			 
    			 else
    			 for(List<String> tt : t)dp.get( i + word.length()).add(tt);
    			 
    			 //System.out.println("After DP : "+dp);
    		   }
    		  }
    	  }
       }
		return dp.get(target.length());
	
}
}