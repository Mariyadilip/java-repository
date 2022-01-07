package mt.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock {

	public static void main(String[] args) {
		
		Display3 d = new Display3();
		MyThread3 t1 = new MyThread3(d, "manikandan");
		MyThread3 t2 = new MyThread3(d, "mariya dilip");
		
		t1.start(); t2.start();
	}
}

class MyThread3 extends Thread{
	
Display3 d;
String name;
MyThread3(Display3 d, String name){super(name); this.d = d;this.name = name;}

 public void run() {
	d.show(name); 
 }
}

class Display3{
	
	ReentrantLock l  = new ReentrantLock();
	public void show(String name) {
		
		if(l.tryLock()) {
			System.out.println(Thread.currentThread().getName()+" has got the lock");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			l.unlock();
			System.out.println(Thread.currentThread().getName()+" has unlocked the object");
		}
		else {
			System.out.println(Thread.currentThread().getName()+" is executing some other task");
		}
	}
}