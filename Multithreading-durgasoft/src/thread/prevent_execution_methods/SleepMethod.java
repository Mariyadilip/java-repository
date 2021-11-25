package thread.prevent_execution_methods;

/*
 * This method is used when the running want to pause or it don't want to perform any operation for
 * a particular period of time;
 */
public class SleepMethod {

	public static void main(String[] args) throws InterruptedException {
		
		for(int i = 0 ; i<11 ; i++) {
			System.out.println("count "+i);
			Thread.sleep(1000);
		}
	}
}
