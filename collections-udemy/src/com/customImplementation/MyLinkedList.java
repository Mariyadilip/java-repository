package com.customImplementation;

public class MyLinkedList<T> implements MyList<T>{

	private class Node<T>{
		Node<T> prev;
		Node<T> next;
		T element;
		
		Node(T e){
			this.element = e;
			prev = null;
			next = null;
		}
		
	}
    
	Node<T> root = null;
	
	public void add(T e) {
		
		Node<T> newnode = new Node<>(e);
		if(root == null) 
			root = newnode;
		
		else {
			Node<T> temp = root;
			while(temp.next != null)
				temp = temp.next;
			temp.next = newnode;
			newnode.prev = temp;
		}
			
	}
	
	public String toString() {
		Node<T> t = root;
		StringBuffer result = new StringBuffer();
		while(t != null) {
			result.append(t.element.toString()+ ((t.next == null) ? "" : ", ") );
			t = t.next;
		}
		return "[ "+result+" ]";
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public boolean remove(T o) {
	    Node<T> temp = root;
	    
	    if(root.element.equals(o)) {
	    	root = root.next;
	    	return true;
	    }
	    
	    while(temp != null) {
	    	
	    	if(temp.element.equals(o) && temp.next != null) {
	    		Node<T> prev = temp.prev;
	    		Node<T> next = temp.next;
	    		
	    		prev.next = temp.next;
	    		next.prev = temp.prev;
	    		return true;
	    	}
	    	else if(temp.element.equals(o) && temp.next == null) {
	    		temp.prev.next = null;
	    		return true;
	    	}
	    	
	    	temp = temp.next;
	    }
	    
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(MyList<T> c) {
		// TODO Auto-generated method stub
		return false;
	}
}
