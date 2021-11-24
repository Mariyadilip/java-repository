package thread.creations;

public class FourthWay {

	public static void main(String[] args) {
		
	/*	Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(" "+Thread.currentThread().getName()+" running ");
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
		System.out.println(" Main thread ");  */
		
		
		/*
	      Runnable runnable =
	       Thread thread = new Thread(runnable);
			thread.start();
			
			System.out.println(" Main thread ");
			*/
		
		Thread thread = new Thread( () -> System.out.println(" "+Thread.currentThread().getName()+" running "));
		thread.start();
		
		System.out.println(" Main thread ");
	}
}
