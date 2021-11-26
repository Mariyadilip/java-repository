package thread.synchronization;

/*
 * Synchronized keyword is a modifier
 * It can be used only with methods and blocks, not with classes or variables;
 * 
 * Synchronization allows only one thread execute the synchronized method of the particular object
 * 
 * If multiple threads are executing on same object, then only one thread can be able to access a method at a time,
 * whereas the remaining threads cannot access the same or other synchronized method of the same object
 * 
 * 
 */
public class Non_Static_SynchronizationMethod {

	public static void main(String[] args) {
		
		Display d = new Display();
		MyThread t1 = new MyThread(d, "Dhoni");
		MyThread t2 = new MyThread(d, "Kohli");
		
		t1.start();
		t2.start();
	}
}

/*
 * There are two thread t1, t2 both are working on same object 'd'. And wish method in Display class is synchronized
 * which means one thread will put lock on the object 'd', so the other will wait until the executing thread releases the lock
 * 
 */
class Display{
	public synchronized void wish(String name) {
		for(int i=1 ; i<=10 ; i++) {
			System.out.print("Good morning : ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}

class MyThread extends Thread{
	Display d;
	String name;
	
	MyThread(Display d, String name){
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}