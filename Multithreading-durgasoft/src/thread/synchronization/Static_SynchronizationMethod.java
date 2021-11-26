package thread.synchronization;

/*
 * In object level the thread put lock on the object it is accessing, so remaining thread cannot access all the Non-static 
 * Synchronized method but can access
 *       - Static synchronized method 
 *       - static method
 *       - Non-synchronized instance method
 * 
 * In Class level the thread put lock on the class while it's accessing the synchronized static method, so the remaining thread
 * cannot access all the synchronized static method until it's lock has been released, but can access,
 * 		- Non-synchronized static method
 * 		- synchronized instance method
 * 		- Non-synchronized instance method  
 */

public class Static_SynchronizationMethod {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("print");
		MyThread1 t2 = new MyThread1("display");
		MyThread1 t3 = new MyThread1("static");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Main{
	
	static synchronized void display() throws InterruptedException {
		for(int i = 1 ; i<= 10 ; i++) {
			System.out.println("Display : "+i);
			Thread.sleep(1000);
		}
	}
	
	static synchronized void print() throws InterruptedException {
		for(int i = 1 ; i<= 10 ; i++) {
			System.out.println("Print : "+i);
			Thread.sleep(1000);
		}
	}
	
	static void displayStatic() throws InterruptedException {
		for(int i = 1 ; i<= 10 ; i++) {
			System.out.println("DisplayStatic : "+i);
			Thread.sleep(1000);
		}
	}
}

class MyThread1 extends Thread{
	String call = "";
	
	public MyThread1(String c) {
	   call = c;
	}
	
	public void run() {
		try {
			if(call.equals("print"))
			Main.print();
			else if(call.equals("display"))
			Main.display();
			else if(call.equals("static"))
			Main.displayStatic();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

