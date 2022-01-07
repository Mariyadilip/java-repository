package mt.interthreadcommunication;

import java.util.Stack;

public class ProducerConsumer {

	public static void main(String[] args) {
		
		ProducerConsumerCode pc = new ProducerConsumerCode();
		Thread t1 = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start(); t2.start();
	}
}

class ProducerConsumerCode{
	Stack<Integer> stack = new Stack<>();
	int value;
	
	public void produce() throws InterruptedException {
		while(true) {
		   synchronized(this) {
			   
			   if(!stack.isEmpty())
				   wait();
			   
			  stack.push(value++);
			   System.out.println("proudcer : "+stack.peek());

			   notify();
			   Thread.sleep(1000);
		   }
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized(this) {
				
				if(stack.isEmpty())
					wait();
				System.out.println("consumer "+stack.peek());
                stack.pop();
				notify();
				   Thread.sleep(1000);

			}
		}
	}
}