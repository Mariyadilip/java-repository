package thread.workingbasics;

//The JVM will alive even after the completion of main thread but some other threads are running;

//Demon thread : 
//It's a thread it will stop it's work after the main executes completely

class MyThread4 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "   ::   " + i);

		}

	}
}

public class DemonThread {

	public static void main(String[] args) throws InterruptedException {

		MyThread4 my1 = new MyThread4();
		MyThread4 my2 = new MyThread4();

		Thread thread1 = new Thread(my1, "Thread 1");
		thread1.start();

		Thread thread2 = new Thread(my2, "Thread 2");
		thread2.setDaemon(true);
		thread2.start();

		Thread.sleep(5000);

		System.out.println("\n\nMain Thread completed\n");
	}
}
