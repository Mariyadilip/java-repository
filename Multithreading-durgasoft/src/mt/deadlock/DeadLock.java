package mt.deadlock;

public class DeadLock extends Thread {

A a = new A();
B b = new B();

public void d() {
	this.start(); //This line executed by main thread
	a.d(b);
}

public void run() {
	b.d(a); //This line executed by child threads
}
	public static void main(String[] args) {
		
		DeadLock d = new DeadLock();
		d.d();
	}
}


class A{
	
	public synchronized void d(B b) {
		System.out.println("A class executing d()");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b.last();
	}
	
	public synchronized void last() {
		System.out.println("A class last() method");
	}
}

class B{
	
	public synchronized void d(A a) {
		System.out.println("B class executing d()");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.last();
	}
	
	public synchronized void last() {
		System.out.println("B class last() method");
	}
}