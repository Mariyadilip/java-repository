package thread.basic;

/*
 * By default every thread will have default priority
 * priority range 1 - 10
 * 
 * if priority is not within range then, IllegalArgumentException is thrown
 * 
 * by default main will have priority 5
 * then all threads will have the priority of its parent thread(the thread which creates this thread)
 * 
 */
class MyThread2 extends Thread{
	
}

public class ThreadPriorties {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getPriority()); //main thread priority
		
		//Thread.currentThread().setPriority(11); //Exception
		Thread.currentThread().setPriority(8); //the threads created by main thread will have priority 8;
		
		MyThread2 t = new MyThread2();
		t.start();
		
		System.out.println(t.getPriority());
	}
}
