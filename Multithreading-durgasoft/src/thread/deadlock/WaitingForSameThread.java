package thread.deadlock;

/*
 * If same thread is waiting to its own process, then it will be in waiting state forever
 */
public class WaitingForSameThread {

	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().join();
		
	}
}
