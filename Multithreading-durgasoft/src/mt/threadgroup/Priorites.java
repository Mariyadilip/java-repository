package mt.threadgroup;

public class Priorites {

	public static void main(String[] args) {

		ThreadGroup g1 = new ThreadGroup("firstgroup");
		Thread t1 = new Thread(g1, "Thread 1");
		Thread t2 = new Thread(g1, "Thread 2");
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(g1.getMaxPriority());
		
		g1.setMaxPriority(3);
		Thread t3 = new Thread(g1, "Thread 3");
		System.out.println(g1.getMaxPriority());
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
				
	}
}
