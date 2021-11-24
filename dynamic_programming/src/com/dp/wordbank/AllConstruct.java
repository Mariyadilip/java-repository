package com.dp.wordbank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class AllConstruct {

	public static void main(String[] args) {
//     System.out.println(allConstruct("purple", List.of("purp", "p", "ur", "le", "purpl")));
//	   System.out.println(allConstruct("aabc",  List.of("a", "aa", "bc")));
//     System.out.println(allConstruct("cc", List.of("aaa", "ab")));
//     System.out.println(allConstruct("", List.of("a", "aa", "abc")));

		System.out.println(allConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef", "c")));
		System.out.println(allWord("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef", "c")));
		System.out.println(allWord("aaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a", "aa", "aaa", "aaaaa")));
	}

	private static List<List<String>> allConstruct(String target, List<String> wordBank) {

		if (target.equals("")) {
			List<List<String>> list = new ArrayList<>();
			list.add(new ArrayList<>());
			return list;
		}

		List<List<String>> dictionary = new ArrayList<List<String>>();

		for (String word : wordBank) {
			if (target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());
				List<List<String>> combinations = allConstruct(suffix, wordBank);

				if (combinations != null) {
					for (List<String> words : combinations)
						words.add(0, word);
					if (dictionary == null)
						dictionary = new ArrayList<List<String>>();
					for (List<String> words : combinations) // (or) dictionary.addAll(combinations)
						dictionary.add(words);
				}
			}
		}

		return dictionary;
	}

	private static List<List<String>> allWord(String target, List<String> wordBank) {
		HashMap<String, List<List<String>>> memo = new HashMap<String, List<List<String>>>();
		List<List<String>> list = dp(target, wordBank, memo);
		// System.out.println(memo);
		return list;
	}

	private static List<List<String>> dp(String target, List<String> wordBank,
			HashMap<String, List<List<String>>> memo) {

		if (memo.containsKey(target))
			return memo.get(target);
		
		if (target.equals("")) {
			List<List<String>> list = new ArrayList<>();
			list.add(new ArrayList<>());
			return list;
		}
		

		List<List<String>> dictionary = new ArrayList<List<String>>();

		for (String word : wordBank) {
			if (target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());
				List<List<String>> combinations = dp(suffix, wordBank, memo);

				if (combinations != null) {
					for (List<String> words : combinations)
						words.add(0, word);
					if (dictionary == null)
						dictionary = new ArrayList<List<String>>();
					for (List<String> words : combinations) // (or) dictionary.addAll(combinations)
						dictionary.add(words);
				}
			}
		}

		List<List<String>> temp = new ArrayList<List<String>>();
		for (List<String> t : dictionary)
			temp.add(new ArrayList<String>(t));

		memo.put(target, temp);
		return dictionary;
	}
}