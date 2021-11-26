package thread.synchronization;

/*
 * Synchronized is used to improve performance of the program
 * 
 * It is used when only few lines of code needs to synchronized, 
 *   eg. If a method contains 1lakh lines code but in which only 10lines of code need to synchronized, so if we use
 *       synchronized only method then all the thread has to wait until the executing thread release the lock, so it's 
 *       better to surround that 10lines of code with synchronized block;
 *       
 * Cases(i); current object lock
 *       Synchronized(this)
 * cases(ii); particular object lock say 'b' object of some class
 *       synchronized(b)
 * cases(iii); particular class lock say Display class
 *       synchronized(Display.class)
 *       
 * 
 */
public class SynchronizedBlock_CurrentObject {

	public static void main(String[] args) {
		Display2 d = new Display2();
		MyThread3 t1 = new MyThread3(d);
		t1.setName("First Thread");
		MyThread3 t2 = new MyThread3(d);
		t2.setName("Second Thread");
		
		t1.start();t2.start();
	}
}

class Display2{
	
	public void display() throws InterruptedException {
		
		for(int i=1 ; i<=10 ; i++) {
			Thread.sleep(1000);
		  System.out.println("Before synchronized "+Thread.currentThread().getName()+" "+i);
		  
		}
		
		synchronized(this){
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

class MyThread3 extends Thread{
	Display2 d;
	public MyThread3(Display2 d) {
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
