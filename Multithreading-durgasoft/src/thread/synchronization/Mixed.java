package thread.synchronization;

public class Mixed {

	public static void main(String[] args) {
		
		Display1 d = new Display1();
		
		TThread1 t1 = new TThread1(); //sync static display()
		TThread2 t2 = new TThread2(); //sync static print()
		TThread3 t3 = new TThread3(); //non-sync static noramlStatic();
		
		TThread4 t4 = new TThread4(d); //sync non-static displayNS();
		TThread5 t5 = new TThread5(d); //sync non-static printNS();
		TThread6 t6 = new TThread6(d); //non-sync non-static normalNS();
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		System.out.println("Main thread completed");
	}
}

class Display1{
	
	static synchronized void display() throws InterruptedException {
		for(int i=1 ; i<=10 ; i++) {
			System.out.println("Synchronized static display method "+i);
			Thread.sleep(1000);
		}
	}
	
	static synchronized void print() throws InterruptedException {
		for(int i=1 ; i<=10 ; i++) {
			System.out.println("Synchronized static print method "+i);
			Thread.sleep(1000);
		}
	}
	
	static  void normalStatic() throws InterruptedException {
		for(int i=1 ; i<=10 ; i++) {
			System.out.println("Normal static method "+i);
			Thread.sleep(1000);
		}
	}
	
	 synchronized void displayNS() throws InterruptedException {
		for(int i=1 ; i<=10 ; i++) {
			System.out.println("Synchronized NS display method "+i);
			Thread.sleep(1000);
		}
	}
	 
	 synchronized void printNS() throws InterruptedException {
			for(int i=1 ; i<=10 ; i++) {
				System.out.println("Synchronized NS print method "+i);
				Thread.sleep(1000);
			}
		}
	 
	  void normalNS() throws InterruptedException {
			for(int i=1 ; i<=10 ; i++) {
				System.out.println("Normal NS method "+i);
				Thread.sleep(1000);
			}
		}
}

class TThread1 extends Thread{
	public void run() {
		try {
			Display1.display();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class TThread2 extends Thread{
	public void run() {
		try {
			Display1.print();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class TThread3 extends Thread{
	public void run() {
		try {
			Display1.normalStatic();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class TThread4 extends Thread{
	Display1 d;
	
	public TThread4(Display1 d) {
		this.d = d;
	}
	
	public void run() {
		try {
			d.displayNS();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class TThread5 extends Thread{
	Display1 d;
	
	public TThread5(Display1 d) {
		this.d = d;
	}
	
	public void run() {
		try {
			d.printNS();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class TThread6 extends Thread{
	Display1 d;
	
	public TThread6(Display1 d) {
		this.d = d;
	}
	
	public void run() {
		try {
			d.normalNS();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}