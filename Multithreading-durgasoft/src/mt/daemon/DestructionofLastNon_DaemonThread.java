package mt.daemon;

/*
 * whenever the last non-daemon thread completed, then automatically all daemon thread will be terminated irrespective of their psoition 
 */
public class DestructionofLastNon_DaemonThread {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread t = new MyThread();
		t.setDaemon(true);
		t.start();
		
		Thread.sleep(2000);
		System.out.println("Main thread completed");
	}
}

class MyThread extends Thread{
	
	public void run() {
		
		for(int i=1 ; i<=10 ; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
