package thread.synchronization;

public class SynchronizedBlock_ClassLevel {
	
	public static void main(String[] args) {
		
		Display3 d1 = new Display3();
		Display3 d2 = new Display3();
		
		MyThread4 t1 = new MyThread4(d1);
		t1.setName("First Thread");
		
		MyThread4 t2 = new MyThread4(d2);
		t2.setName("Second Thread");
		
		/*
		 * Even though 2 threads are accessing 2 different objects, the lock is acquired in class, so
		 * only one thread can process that block at a time
		 */
		t1.start();t2.start();
	}
}

class Display3{
	
	public void display() throws InterruptedException {
		
		for(int i=1 ; i<=10 ; i++) {
			Thread.sleep(1000);
		  System.out.println("Before synchronized "+Thread.currentThread().getName()+" "+i);
		  
		}
		
		synchronized(Display3.class){ //class level lock
			for(int i=1 ; i<=10 ; i++)
			{
				Thread.sleep(1000);
				System.out.println("In synchronized "+Thread.currentThread().getName()+" "+i);
			}
		}
		
		for(int i=1; i<=10 ; i++) {
			Thread.sleep(1000);
			System.out.println("After synchronized "+Thread.currentThread().getName()+" "+i);
		}
	}
}

class MyThread4 extends Thread{
	Display3 d;
	public MyThread4(Display3 d) {
		this.d = d;
	}
	
	public void run() {
		try {
			d.display();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
