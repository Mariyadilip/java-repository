package thread.basic;

/*
 * UserDefinedClass -> Thread -> Runnable
 * 
 * Runnable is the functional interface which contains run()
 * 
 */
public class CreatingThreadUsingRunnableInterface {

	public static void main(String[] args) {
		
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		System.out.println("parent thread");
	}
}

 class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("child thread");
	}
	
}
