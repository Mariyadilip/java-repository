package com.dp.wordbank;

import java.util.HashMap;
import java.util.List;

/*
 *write a function 'countConstruct(target, wordBank)' that accepts a target String
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

public class CountConstruct_WordBank {

	public static void main(String[] args) {
		
//		System.out.println(countCons("aabc", List.of("a", "aa", "bc")));
//        System.out.println(countCons("purple", List.of("purp", "p", "ur", "le", "purpl")));
//		System.out.println(countCons("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
//		System.out.println(countCons("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
//		System.out.println(countCons("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
//		
//		System.out.println(countCons("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
//			List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
		
		System.out.println(countConstruct("aabc",  List.of("a", "aa", "bc")));
      System.out.println(countCons("purple", List.of("purp", "p", "ur", "le", "purpl")));
		System.out.println(countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
		System.out.println(countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
		System.out.println(countConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
		
		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
				List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
		
	}
	
	private static int countCons(String target, List<String> wordBank) {
		
		if(target.equals("")) return 1;
		int count = 0;
		
		for(String word : wordBank) {
			if(target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());
				 int total = countCons(suffix, wordBank);
				 count += total;
			}
		}

	return count;
	}
	
	public static int countConstruct(String target, List<String> wordBank) {
		return dp(target, wordBank, new HashMap<>());
	}
	
	private static int dp(String target, List<String> wordBank, HashMap<String, Integer> memo) {
		
		if(memo.containsKey(target))return memo.get(target);
		if(target.equals("")) return 1;
		int count = 0;
		
		for(String word : wordBank) {
			if(target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());
				 int total = dp(suffix, wordBank, memo);
				 count += total;
			}
		}

	memo.put(target, count);
	return count;	
	}
}
