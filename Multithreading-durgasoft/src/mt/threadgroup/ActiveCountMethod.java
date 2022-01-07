package mt.threadgroup;

public class ActiveCountMethod {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup g1 = new ThreadGroup("parentgroup");
		ThreadGroup g2 = new ThreadGroup(g1, "childgroup");
		
		MyThread t1 = new MyThread(g1, "Thread -1");
		MyThread t2 = new MyThread(g1, "Thread -2");
		MyThread t3 = new MyThread(g2, "Thread -3");
		
		t1.start(); t2.start(); t3.start();
		System.out.println(g1.activeCount()); //2 (Thread -1, Thread -2)
		System.out.println(g1.activeGroupCount()); //1 (childgroup)
		
		g1.list();
		
		Thread.sleep(10000);
		System.out.println(g1.activeCount()); //0
		System.out.println(g1.activeGroupCount()); //1
		
		g1.list();
		
	}
	
}

class MyThread extends Thread{
	
	MyThread(ThreadGroup g, String name){
		super(g, name);
	}
	
	public void run() {
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());

	}
}
