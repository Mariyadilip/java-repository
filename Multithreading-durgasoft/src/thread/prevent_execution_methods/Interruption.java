package thread.prevent_execution_methods;

/*
 * A thread can interrupt sleeping or waiting thread 
 * 
 * public void interrupt(); present in Thread Class
 * 
 * Where we call interrupt() method, if the target thread is not in sleeping or waiting state, then interrupt call will 
 * wait until the target thread goes to sleeping or waiting state;
 * 
 * If the target thread is died before going to sleeping or waiting state, then this is only place where interrupt call will be wasted
 * 
 * The thread which call interrupt() method will continue to perform its own operation, where JVM takes care of interrupt call
 */
public class Interruption {

	public static void main(String[] args) {
		
		MyThread2 t = new MyThread2();
		t.start();
		
		t.interrupt(); //main thread interrupting child thread
		
		if(t.isInterrupted())System.out.println("Yes ");
		else
			System.out.println("No");
		System.out.println("Main ends ");
	}
}

class MyThread2 extends Thread{
	
	public void run() {
		try {
			for(int i = 1; i <= 10; i++) {
				System.out.println("Child Thread ");
			}
			//interrupt call will wait until the target thread goes to sleep or wait state 
			System.out.println("Sleeping state ");
			Thread.sleep(5000); //The interrupt call will not allow to sleep
			System.out.println("finished sleeping");
		}
		catch(Exception ie) {
			System.out.println("I got interrupted");
		}
	}
}