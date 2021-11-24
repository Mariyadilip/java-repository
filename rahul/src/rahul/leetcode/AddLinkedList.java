package rahul.leetcode;

import rahul.leetcode.LinkedList.Node;

/*
 *  l1 -> 4    7    9
 *  l2 -> 3    8     
 *  
 *  result => 7  5  0  1
 *  
 *  4+3 = 7,  7+8 = 15 (5 is the remainder and 1 is the carry to next list)  
 *  
 */
class LinkedList{
	
	Node root ;
	
	{
		root = null;
	}
	
	class Node{		
		int data;
		Node next;		
	 Node(int d){ 
		 this.data = d;
		 }	 
	}
	
	public void add(int d) {
		
		Node newNode = new Node(d);
		if(root == null) {
			root = newNode;
			return;
		}
		
		Node temp = root;
		while(temp.next != null) temp = temp.next;
		temp.next = newNode;
		
	}
	
	
	public String toString() {
		String s = "[ ";
		Node temp = root;
		while(temp != null) {
			s = s + temp.data +", ";
			temp = temp.next;
		}
		s = s.substring(0, s.length() - 2);
		s = s + " ]";
		return s;
	}
}

public class AddLinkedList {


	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		list1.add(4);
		list1.add(8);
		list1.add(9);
		
		LinkedList list2 = new LinkedList();
        list2.add(2);
        list2.add(5);
        
		System.out.println(list1);
		System.out.println(list2);
		
		LinkedList list3 = addList(list1, list2);
		System.out.println(list3);
	}
	
	private static LinkedList addList(LinkedList list1, LinkedList list2) {
		
		int carry = 0;
		LinkedList list3 = new LinkedList();
		Node r1 = list1.root, r2 = list2.root;
		
		while(r1 != null || r2 != null) {
			
			int number = 0;
			
			if(r1 != null && r2 != null) {
				number = r1.data + r2.data;
				r1 = r1.next; r2 = r2.next;
			}
			
			else if(r1 != null) {
				number = r1.data;
				r1 = r1.next;
			}
			
			else {
				number = r2.data;
				r2 = r2.next;
			}
			
			number += carry;
			carry = number / 10;
			list3.add(number % 10);
		}
		
		if(carry > 0)list3.add(carry);
		return list3;
	}
}
