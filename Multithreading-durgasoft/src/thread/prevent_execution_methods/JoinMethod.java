package thread.prevent_execution_methods;

/*
 * Join method is used when one thread has to wait until the completion of other thread.
 * 
 * The thread which has to wait wants to call join method
 * 
 * Eg : If t1 wants to wait until the completion of t2, then t1 has to call t2.join();
 * 
 */
                  //Child thread waiting for parent thread;
/*
public class JoinMethod {

	static Thread thread = null;
	public static void main(String[] args) {
		thread = Thread.currentThread();
		
		MyThread1 t = new MyThread1();
		t.start();
		
		for(int i=1 ;i<=10 ; i++)
			System.out.println("Parent method");
	}
}

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		
		for(int i=1 ; i<=10 ; i++) {
			
			System.out.println("Child method");
			try {
				JoinMethod.thread.join(); //this thread is waiting for main thread to complete its execution
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

*/

			//Parent thread waiting for childThread

public class JoinMethod{
	public static void main(String[] args) throws InterruptedException {
		
		MyThread1 t = new MyThread1();
		t.start();
		
		// t.join(); //main thread waits for child thread
		t.join(5000); //main thread will wait for child thread for maximum of 5 seconds
		for (int i = 1; i <= 10; i++)
		System.out.println("Parent Thread");
	}
}

class MyThread1 extends Thread{
	
	public void run() {
		for(int i=1 ; i<=10 ; i++) {
			System.out.println("Child Thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}