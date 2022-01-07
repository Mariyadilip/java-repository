package mt.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		
		MyRunnable[] runnables = {new MyRunnable("dilip"), new MyRunnable("rahul"), new MyRunnable("lakshmibathy"),
				                  new MyRunnable("manikandan"), new MyRunnable("Dinesh"), new MyRunnable("anand")};
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for(MyRunnable runnable : runnables)
		service.submit(runnable);
		
		service.shutdown();
	}
}

class MyRunnable implements Runnable{
	
	String name;
	MyRunnable(String name){
		this.name = name;
	}
	public void run() {		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+"... work completed by ... "+Thread.currentThread().getName());
	}
}
