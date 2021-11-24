package com.timemeasurement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedLvsArrayL {
 
	 public static void addElementsToBeginning(List<Integer> list, int numberOfElementsToAdd) {
		 
		 for(int i=0 ; i<=numberOfElementsToAdd ; i++)
			list.add(0, i);
	 }	 
	 
	 public static void addElementsToMiddle(List<Integer> list, int numberOfElementsToAdd) {
		 
		 for(int i=0 ; i<=numberOfElementsToAdd ; i++)
			list.add(i/2, i);
		 
	 }
	 
	 public static void addElementsToEnd(List<Integer> list, int numberOfElementsToAdd) {
		 
		 for(int i=0 ; i<=numberOfElementsToAdd ;i++)
			 list.add(i);
	 }
	 

	public static void removeElementsFromBeginning(List<Integer> list, int numberOfElementsToRemove) {
		
	}
	
	public static void removeElementsFromMiddle(List<Integer> list, int numberOfElementsToRemove) {
		
	}

	public static void removeElementsFromEnd(List<Integer> list, int numberOfElementsToRemove) {
		
	}
	
	
	 public static void main(String[] args) {
		
		 List<Integer> arrayList = new ArrayList<>();
		 List<Integer> linkedList = new LinkedList<>();
		 	
		 long mill = System.nanoTime();
		  //addElementsToBeginning(arrayList, 1000);
		  addElementsToBeginning(linkedList, 1000);
		 
		  //addElementsToEnd(linkedList,10000);
		 // addElementsToEnd(arrayList,10000);
		 long delta = (System.nanoTime() - mill) / 10000;
		 
		  System.out.println("ArrayList insertion at First time : "+delta); // 10El - 4ms, 100El - 9 , 1000El - 84, 10000El - 192
		 //System.out.println("LinkedList insertion at First time : "+delta); // 10El - 11ms, 100El - 16, 1000El - 58, 10000El - 227

		 
		 // System.out.println("ArrayList insertion at Last time : "+delta); // 10El - 4ms, 100El - 6 , 1000El - 39, 10000El - 192
		 //System.out.println("LinkedList insertion at Last time : "+delta); // 10El - 11ms, 100El - 14, 1000El - 58, 10000El - 227
		 

	}
	 
	 
	 
}

