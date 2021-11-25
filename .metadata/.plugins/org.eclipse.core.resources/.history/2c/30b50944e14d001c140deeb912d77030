package thread.deadlock;

/*
 * If t1 thread is waiting for t2 thread (t2.join()) to completes it process, and 
 * t2 is waiting for t1 (t1.join()) to completes it process, then they will wait forever;
 * Therefore deadlock;
 *  
 */
public class JoinMethod {

	public static void main(String[] args) throws InterruptedException {
		MyThread.thread = Thread.currentThread();
		MyThread t = new MyThread();
		t.start();
		t.join(); //main thread is waiting for child thread to completes its process;
	}
}

class MyThread extends Thread{
	
	static Thread thread;
	
	public void run() {
		try {
			thread.join(); //child thread is waiting for parent thread to completes it's process;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("child");
	}
}