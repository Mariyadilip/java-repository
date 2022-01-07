package mt.threadgroup;

public class ActiveThreadsInSystemGroup {

	public static void main(String[] args) {
		
		ThreadGroup systemGroup = Thread.currentThread().getThreadGroup().getParent();
		Thread[] activeThreadNamesInSystemGroup = new Thread[systemGroup.activeCount()];
		
		systemGroup.enumerate(activeThreadNamesInSystemGroup);
		System.out.println("active count : "+systemGroup.activeCount());
		System.out.println("active groups : "+systemGroup.activeGroupCount());
		systemGroup.list();
		
		for(Thread thread : activeThreadNamesInSystemGroup)
		System.out.println(thread.getName()+" === daemon : "+thread.isDaemon()+" === priority : "+thread.getPriority());
	}
}
