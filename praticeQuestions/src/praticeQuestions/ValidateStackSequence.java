package praticeQuestions;

import java.util.Stack;

public class ValidateStackSequence {

	public static void main(String[] args) {
		
		int push[] = {1, 2, 3, 4, 5};
		int pop[] = {4, 5, 3, 2, 1};
		
		System.out.println(validate1(push, pop));
	}
	
	//My solution
	public static boolean validate(int[] push, int[] pop) {
		
		if(push.length != pop.length)
			return false;
		
		Stack<Integer> stack = new Stack<>();
		int j=0;
		
		for(int i=0 ;i<push.length ; i++) {
		
			while(i<push.length && push[i] != pop[j])
				stack.push(push[i++]);
			
			j++;
		}
	
		while(j < pop.length && stack.peek() == pop[j++])
			stack.pop();
		
		if(stack.isEmpty())
			return true;
		
		return false;
	}
	
	//optimized
	public static boolean validate1(int[] push, int[] pop) {
		
		if(push.length != pop.length)
			return false;
		
		Stack<Integer> stack = new Stack<>();
		int j=0;
		
		for(int i=0 ; i<push.length ; i++) {
			stack.push(push[i]);
			while(j<pop.length && !stack.isEmpty() && stack.peek() == pop[j]) {
				stack.pop();
				j++;
			}
		}
		
		return stack.isEmpty();
	}
}
