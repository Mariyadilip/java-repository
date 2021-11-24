package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class vaibhav {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(6, 2, 4, 10);
				//Arrays.asList(4, 2, 1, 3);
		closestNumbers(numbers);
	}

	public static void closestNumbers(List<Integer> numbers) {

		int min = numbers.get(0);

		for (int i = 0; i < numbers.size(); i++)
			for (int j = i + 1; j < numbers.size(); j++)
					min = Math.min(Math.abs(numbers.get(i) - numbers.get(j)), min);

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < numbers.size(); i++)
			for (int j = i + 1; j < numbers.size(); j++)
				if ( Math.abs(numbers.get(i) - numbers.get(j)) == min) {
					List<Integer> temp = new ArrayList<>();
					if(numbers.get(i) > numbers.get(j))
					{ temp.add(numbers.get(j)); temp.add(numbers.get(i));}
					else
					{ temp.add(numbers.get(i)); temp.add(numbers.get(j));}

					list.add(temp);
				}

		for (int i = 0; i < list.size(); i++) {
			int x = (list.get(i).get(0) * 10) + list.get(i).get(1);
			for (int j = i + 1; j < list.size(); j++) {
				int y = (list.get(j).get(0) * 10) + list.get(j).get(1);
				if (y < x) {
					List<Integer> temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
                   x = (list.get(i).get(0) * 10) + list.get(i).get(1);

				}
				
			}
		}
		
		
		for(List<Integer> l1 : list) {
			for(Integer i : l1) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
