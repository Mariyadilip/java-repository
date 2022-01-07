package mt.threadlocal;

public class MultipleDefaultValuesForCustomThreads {

	public static void main(String[] args) {
		
		MyThread5 dilip = new MyThread5("dilip");
		MyThread5 subash = new MyThread5("subash");
		MyThread5 balaji = new MyThread5("balaji");
		MyThread5 soorya = new MyThread5("soorya");
		MyThread5 mahesh = new MyThread5("mahesh");
		
		dilip.start(); subash.start(); balaji.start(); soorya.start(); mahesh.start();
	}
}

class MyThread5 extends Thread{
	
	static int count = 0;
	static ThreadLocal<Object>  tg = new ThreadLocal<Object>() {
		public Object initialValue() {
			return ++count;
		}
	};
	
	MyThread5(String name){
		super(name);		 
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" thread, default value : "+tg.get());
	}
}
