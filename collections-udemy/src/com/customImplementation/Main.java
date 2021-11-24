package com.customImplementation;

public class Main {

	public static void main(String[] args) {
		
		MyList<Integer> list = new MyLinkedList<>();
		
		list.add(1);
		list.add(3);
		list.add(2);
		System.out.println(list.remove(2));
		list.add(4);
		list.remove(4);
		System.out.println(list);
	}
}
