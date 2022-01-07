package mt.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockWithTime {

	public static void main(String[] args) {
		MyThread4 t1 = new MyThread4("Parent Thread");
		MyThread4 t2 = new MyThread4("Child Thread");
		
		t1.start(); t2.start();
	}
}

class MyThread4 extends Thread{
	
	static ReentrantLock l = new ReentrantLock();
	
	MyThread4(String name){super(name);}
	
	public void run() {
		
		do {
			try {
				if(l.tryLock(2, TimeUnit.SECONDS)) {
					System.out.println(Thread.currentThread().getName()+" has got the lock...");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					l.unlock();
					System.out.println(Thread.currentThread().getName()+" has unlocked...");
					break;
				}
				else {
					System.out.println(Thread.currentThread().getName()+" try again...");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(true);
	}
}