package thread.creations;

class MyThread2 implements Runnable{	
	@Override
	public void run() {
		System.out.println(" "+Thread.currentThread().getName()+" running ");
	}
}

public class ThirdWay {

	public static void main(String[] args) {
		
		//MyThread2 myThread = new MyThread2();
		// thread1 = new Thread(myThread);
		
		// (or)
		
		Thread thread1 = new Thread(new MyThread2());
		thread1.start();
		System.out.println(" "+Thread.currentThread().getName()+" running ");
	}
}
