package rahul.leetcode;

import rahul.leetcode.Tree.Node;

public class FindNearestAncestor {

	static Inorder inorder = new Inorder();
	static PostOrder postorder = new PostOrder();
	
	public static void main(String[] args) {
		
	    int lca = 0;
		
		Tree binaryTree1 = new Tree();
//		binaryTree1.insert(6);
//		binaryTree1.insert(9);
//		binaryTree1.insert(3);
//		binaryTree1.insert(7);
//		binaryTree1.insert(8);
//		binaryTree1.insert(11);
//		binaryTree1.insert(2);
//		
//		binaryTree1.traverse(inorder);
//		binaryTree1.traverse(postorder);
//		
//		lca = binaryTree1.LCA(7, 11);
//		System.out.println(lca);
//		lca = binaryTree1.LCA(3, 11);
//		System.out.println(lca);
		
		
		Tree binaryTree = new Tree();
		binaryTree.insert(3);
		binaryTree.insert(2);
		binaryTree.insert(1);
		
		lca = binaryTree.LCA(2, 1);
		System.out.println(lca);
	}
}

interface Traversal{
	void traverse(Node root);
}

class Inorder implements Traversal{

	String str = "";
	
	@Override
	public void traverse(Node current) {
		 System.out.print("\nINORDER : [ ");
		 t(current);
		 System.out.println(str.substring(0, str.length() - 2)+" ]");
	}
	
	
	public void t(Node current) {
		
		if(current.Left != null)
			t(current.Left);
		
		str = str + current.data + ", ";
		
		if(current.Right != null)
			t(current.Right);
	}
	
}

class PostOrder implements Traversal{

	String str = "";
	
	@Override
	public void traverse(Node current) {
		 System.out.print("\nPOSTORDER : [ ");
		 t(current);
		 System.out.println(str.substring(0, str.length() - 2)+" ]");
	}
	
	public void t(Node current) {

		if(current.Left != null)
			t(current.Left);
		if(current.Right != null)
			t(current.Right);
		str = str + current.data + ", ";
		}
}

class Tree{
	
	private Node root;
	
	 class Node{
		
		int data;
		Node Left;
		Node Right;
		
		Node(int data){this.data = data;}
		
	}
	
	public void traverse(Traversal t) {
		t.traverse(root);
	}
	
	public int LCA(int x, int y) {
		return LCA(root, x, y).data;
	}
	
	private Node LCA(Node root, int x, int y) {
		
		if(root == null)return null;
		if(root.data == x || root.data == y)return root;
		
		Node leftSearch = LCA(root.Left, x, y);
		Node rightSearch = LCA(root.Right, x, y);
				
		if(leftSearch == null)return rightSearch;
		if(rightSearch == null)return leftSearch;
		
		return root;
	}
	
	public void insert(int data) {
		
		Node newnode = new Node(data);
		if(root == null) {
			root = newnode;
			return;
		}
		Node current = root;
		while(true) {
			
			Node temp = current;
			String dir = "";
			
			if(data > current.data) {
				current = current.Right;
				dir = "right";
			}
			else {
				current = current.Left;
				dir = "left";
			}
			
			if(current == null && dir.equals("right")) {
				temp.Right = newnode;
				break;
			}
			else if(current == null && dir.equals("left")) {
				temp.Left = newnode;
				break;
			}
		}
	}
}