package mt.threadgroup;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getThreadGroup().getName()); //main is the thread group name
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName()); //system is the parent of all thread group
		
		ThreadGroup g1 = new ThreadGroup("FirstGroup"); //This line executed by main thread, so this group is the subgroup of
		                                                 //the main thread group;
		
		System.out.println(g1.getName());
		System.out.println(g1.getParent().getName());
		
		
		ThreadGroup g2 = new ThreadGroup(g1, "SecondGroup"); //g1 is the parent group of this current group
		System.out.println(g2.getName());
		System.out.println(g2.getParent().getName());
		
		System.out.println("-------");
	}
	

}
