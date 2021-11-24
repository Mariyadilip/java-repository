package thread.workingbasics;

public class JoinMethod {

	public static void main(String[] args) {
		
		Runnable runnable = ()->{ 
			
			for(int i=0 ;i<5 ;i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(i);
			}
				
		};
		
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
		
		//Now as soon as my main thread finished, my runnable thread will also be finished because I have set my runnable thread to Daemon
		// so now i want to execute all the statement in my thread, so my main thread have to wait until my thread completes, in this place 
		// we use ***join*** method
		
	  try {
		thread.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  
	  System.out.println("Main ends ");
	}
}
