package thread.basic;

/*
 * Thread is the light-weight process
 * 
 *  Thread based multitasking is process of executing multiple tasks simultaneously, where each task is a 
 *  separate independent flow of the same program;
 *  
 *  Multithreading is used to improve the performance of the system by reducing the idle time of process
 *  
 *  If we have multiple flows(threads), the execution order of these thread are dependent on Thread Schedular.
 *  As Thread Schedular using different alogirthm( First come First Serve, RoundRobin, Shortest job first)
 *  to allocate executing time, we cannot anticipate the output.
 *  
 *  start() vs run();
 *  If we call run() directly, then it will be considered as normal method and main thread start executes it.
 *  calling start() will create a new thread and executes it own flows, independently.
 *  
 */
public class CreatingThreadUsingThreadClass {

	public static void main(String[] args) {
		MyThread t  = new MyThread();
		t.start(); //main thread start or creates new child thread
		for(int i = 1  ; i<=10 ; i++)
			System.out.println("Main thread");
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		for(int i = 1; i<=10 ; i++)
			System.out.println("Child class");
	}
}