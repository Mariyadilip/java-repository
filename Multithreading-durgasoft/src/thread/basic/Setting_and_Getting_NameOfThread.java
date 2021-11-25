package thread.basic;

/*
 * Thread.currentThread() is used to get the current executing thread
 * 
 */
public class Setting_and_Getting_NameOfThread {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		MyThread1 mt = new MyThread1();
		Thread t = new Thread(mt);
		System.out.println(t.getName());
		
		Thread.currentThread().setName("Parent thread");
		t.setName("Child-thread");
		System.out.println(t.getName());
		System.out.println(Thread.currentThread().getName());
	}
}

 class MyThread1 implements Runnable{

	@Override
	public void run() {
      System.out.println(Thread.currentThread().getName());		
	}
	
}