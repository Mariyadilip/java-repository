package mt.daemon;

public class Daemon {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().isDaemon());
		//Thread.currentThread().setDaemon(true); // throw Exception, because the daemon nature should be set before the start of thread
		
		Thread t = new Thread(() -> System.out.println("New Thread"));
		System.out.println(t.getPriority());
		System.out.println(t.isDaemon());
		t.setDaemon(true);
		
		t.start();
		System.out.println(t.getPriority());
		System.out.println(t.isDaemon());
	}
}
