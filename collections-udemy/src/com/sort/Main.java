package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		
		Product p1 = new Product(1, 33.33, "wheat");
		Product p2 = new Product(2, 44.33, "sugar");
		Product p3 = new Product(3, 66.34, "rice");
		Product p4 = new Product(4, 33.33, "wheat");
		Product p5 = new Product(5, 33.01, "wheat");
		
		List<Product> list = Arrays.asList(p1, p2, p3, p4, p5);
//		list.sort(new Comparator<Product>() {
//			@Override
//			public int compare(Product o1, Product o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
		
		//Collections.sort(list);
		
		List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		
		Iterator<Integer> ite  = ints.iterator();
		
		while(ite.hasNext()) {
			int i = ite.next();
			if(i == 4) {
				ite.remove();
			}
		}
		
		System.out.println(ints);
	}
	
}
