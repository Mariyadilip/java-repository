package thread.prevent_execution_methods;

/*
 * Yield method stop's the execution of current thread
 * And the waiting threads will be executed if they have the same priority of executing thread
 * If all the waiting thread having low priority than executing thread, then the executing thread continue it's process
 * If many waiting thread having same priority of the executing thread, then the next thread will be chosen by Thread Scheduler based on alogrithm
 * 
 * Once the thread yielded(executed yield()), then it goes to runnable state, it will get a chance based on Thread Scheduler
 * 
 * public void native yield();
 */
public class YieldMethod {

	public static void main(String[] args) {
		
		MyThread mt = new MyThread();
				mt.start();
		
		for(int i = 1 ; i<=10 ; i++)
			System.out.println("Parent thread");
	}
}

class MyThread extends Thread{
	
	public void run() {
		for(int i = 1 ; i<=10 ; i++) {
			System.out.println("Child thread");
			Thread.yield();
		}
	}
}
