package thread.workingbasics;

class MyThread5 implements Runnable{

	int count = 0;
	@Override
	public void run() {
		for(int i=1 ; i<=1000000 ; i++)
			count++;
		System.out.println(Thread.currentThread().getName()+" finished , count : "+count);
	}
	
}

public class Memory {

	public static void main(String[] args) {
		
	/*	Runnable run1 = new MyThread5();
		Runnable run2 = new MyThread5();
		
		//I have two different runnable's so two copies of instance is created i.e 2 count variable is created 
		//and each thread has it's own copy, so the count will be the Max(i) for each thread;
		
		
		Thread t1 = new Thread(run1, "Thread 1");
		Thread t2 = new Thread(run2, "Thread 2");
		
		t1.start();
		t2.start();		
		
		*/
		
	 Runnable run = new MyThread5();
	 
	 //Here we have only one runnable so single of instance is shared by two threads i.e 1 count variable is created
	 //and each have common copy, so the count value is indefined, because when value of count is pulled from heap, there is a
	 //chance that, at the same time two thread's can pick a value and update it, so the value will not be precise\
	 
	 Thread thread1 = new Thread(run, "Thread 1");
	Thread thread2 = new Thread(run, "Thread 2");
	
	thread1.start();
	thread2.start();
	
	}
}
