package mt.interthreadcommunication;

public class WaitAndNotify {

	public static void main(String[] args) throws InterruptedException {
		ThreadA t1 = new ThreadA();
		t1.start();
		
		//case 1 : we assuming that main thread enters the processor first, if not then the main thread will be in waiting 
		 //		   state forever because the child thread finishes and notifies it process before the start of main thread, so
		//		   after no one will be there to notify the main thread, so it will be in waiting forever
		
		synchronized(t1) { // main thread acquired lock on t1 object
			System.out.println("Main thread requires updation "); //1st call
			t1.wait();
			System.out.println("Main thread get's notification and total : "+t1.total); //4th call
		}
		
		//case 2 : it will work even the child thread enters the processor first
		/*
		 * Thread.sleep(2000);
		 * synchronized(t1){
		 *   t1.wait(3000); //it wait only for 3sec
		 *   sysout(" total : "+t1.total);
		 * }
		 */
	}	
}

class ThreadA extends Thread{
	
	int total = 0;
	
	public void run() {
		
		synchronized(this) { //current acquires lock on object
			System.out.println("child thread executing"); //2nd call
			for(int i=1 ;i<=100 ; i++)
				total += i;
			System.out.println("child thread finished updation");
		    this.notify(); //notifies main thread //3rd call
		}		
	}
}