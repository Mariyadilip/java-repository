package mt.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		MyCallable[] callables = {new MyCallable(10), new MyCallable(20), new MyCallable(30), new MyCallable(40), new MyCallable(50)};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(MyCallable task : callables)
		{
			Future f = service.submit(task);
			System.out.println(f.get());
		}
		service.shutdown();
	}
}
class MyCallable implements Callable<Object>{
	
	int num;
	public MyCallable(int num) {
		this.num = num;
	}
	
	public Object call() throws InterruptedException {
	  int sum = 0;
	  for(int i=1 ; i<=num ; i++) sum += i;
	  Thread.sleep(2000);
	  System.out.print(Thread.currentThread().getName()+" ... finished, sum : ");
	  return sum;
	}
}