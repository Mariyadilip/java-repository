package mt.threadlocal;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		
		//The initial value will be null for all thread, if we want our own initial value we have to override the method;
		ThreadLocal<Object> tl = new ThreadLocal<>();
		System.out.println(tl.get()); //this line executed by main thread, so the main thread will get its own associated value;
		tl.set("Hai Main thread"); //this line is executed by main thread, so the value will be set to main thread;;
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());
		
		System.out.println("--------------");
		//overriding the initial value 
		ThreadLocal<Object> t2 = new ThreadLocal<Object>() {
			public Object initialValue() {
				return "initial value";
			}
		};
		System.out.println(t2.get()); //initial value, as this is the new initial value;
		t2.set("hello");;
		System.out.println(t2.get());
		t2.remove();
		System.out.println(t2.get());
	}
}
