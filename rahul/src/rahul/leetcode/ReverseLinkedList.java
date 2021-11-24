package rahul.leetcode;

import rahul.leetcode.LinkedList.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		
//		LinkedList list = new LinkedList();
//		list.add(4);
//		list.add(3);
//		list.add(2);
//		list.add(1);
//		System.out.println(list);
//		reverseLinkedList(list);
		
		int[] price = {3, 1, 2, 5, 2, 8, 7};
		int r = 0;
		for(int i=0 ; i<price.length-1 ; i++) {
			if(price[i] < price[i + 1])
				r += price[i - 1] - price[i];
		}
		System.out.println(r);
	}
	
	private static void reverseLinkedList(LinkedList list) {
		
		Node prev = null;
		Node curr = list.root;
		
		while(list.root != null) {
		 
			list.root = curr.next;
			curr.next = prev;
			prev = curr;
			curr = list.root;
		}
		
		print(prev);
	}
	
	private static void print(Node root) {
		String s = "[ ";
		Node temp = root;
		while(temp != null) {
			s = s + temp.data +", ";
			temp = temp.next;
		}
		s = s.substring(0, s.length() - 2);
		s = s + " ]";
		
		System.out.println(s);
	}
}
