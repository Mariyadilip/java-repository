package thread.creations;


class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println(" "+Thread.currentThread().getName()+" running ");
	}
}


public class FirstWay {
	
	public static void main(String[] args) {
		
		MyThread myThread = new MyThread();
		Thread thread1 = new Thread(myThread);
		thread1.start();
		System.out.println(" "+Thread.currentThread().getName()+" running ");
	}
}
