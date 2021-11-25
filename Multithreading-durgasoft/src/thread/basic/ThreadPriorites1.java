package thread.basic;


public class ThreadPriorites1 {

	public static void main(String[] args) {
		
		MyThread3 t = new MyThread3();
		t.setPriority(Thread.MAX_PRIORITY); //10
		/*
		 * even though we set thread priority, some OS doesn't properly support thread priorites, so we will get mixed output
		 * to solve this issue we need to send mail to OS origanisation (microsoft for windows) and they will send one batch
		 * file after installing that, it will work fine;
		 */
		t.start();
		
		for(int i = 1 ; i<=10 ; i++)
			System.out.println("Parent thread");
	}
}

class MyThread3 extends Thread{
	
	public void run() {
		for(int i = 1 ; i<=10 ; i++)
			System.out.println("Child thread");
	}
}