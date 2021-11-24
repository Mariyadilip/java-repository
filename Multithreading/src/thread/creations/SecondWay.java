package thread.creations;

class MyThread1 extends Thread{	
	@Override
	public void run() {
		System.out.println(" "+Thread.currentThread().getName()+" running ");
	}
}

public class SecondWay {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new MyThread1());
		thread1.start();
		System.out.println(" "+Thread.currentThread().getName()+" running ");
	}
}
