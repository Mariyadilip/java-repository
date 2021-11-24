package com.dp.wordbank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class CanConstruct_WordBankProblem {

	public static void main(String[] args) {
		
//		System.out.println(myApproach("aabc",  List.of("a", "bc")));
//		System.out.println(myApproach("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
//		System.out.println(myApproach("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
//		System.out.println(myApproach("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
//		
//		System.out.println(myApproach("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
//				List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
		
		System.out.println(canConstruct("aabc",  List.of("a", "bc")));
		System.out.println(canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
		System.out.println(canConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
		System.out.println(canConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
		
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
				List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
		
		System.out.println(dp("aabc", List.of("a", "bc")));
		System.out.println(dp("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
		System.out.println(dp("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
		System.out.println(dp("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));

		System.out.println(dp("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
	}
	
	
	//My Approach
	public static boolean myApproach(String target, List<String> wordBank) {
		
		if(target.equals(""))
			return true;
		
		String r = "";
		for(int i=0 ; i<target.length() ; i++) {
			 r = r + target.charAt(i);
			 if(wordBank.contains(r)) {
				 //System.out.println("match : "+r+" remaining : "+target.substring(i+1));
				 if(myApproach(target.substring(i+1), wordBank))
					 return true;
			 }
		}
		
		return false;
	}
	
	//code from the video
	
	private static boolean canConstruct(String target, List<String> wordBank) {
		
		if(target.equals("")) return true;
		
		for(String word : wordBank) 			
			if(target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());
				if(canConstruct(suffix, wordBank))  return true;
			}
	
	return false;
}
	
	public static boolean dp(String target, List<String> wordBank) {
		return canConstructDP(target, wordBank, new HashMap<>());
	}

	public static boolean canConstructDP(String target, List<String> wordBank, HashMap<String, Boolean> memo) {

		if (memo.containsKey(target))
			return memo.get(target);
		if (target.equals(""))
			return true;

		for (String word : wordBank)
			if (target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());
				if (canConstructDP(suffix, wordBank, memo)) {
					memo.put(target, true);
					return true;
				}
			}
		
		memo.put(target, false);
		return false;

	}
}
