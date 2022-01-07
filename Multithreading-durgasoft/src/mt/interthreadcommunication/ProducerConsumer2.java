package mt.interthreadcommunication;

public class ProducerConsumer2 {
 
	public static void main(String[] args) {
		
		Producerconsumercode3 pc = new Producerconsumercode3();
		Thread t1 = new Thread(()->{
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(()->{
			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
	}
}

class Producerconsumercode3 extends Thread{
	
    boolean updated;
    int value;
    static final int TARGET = 10;
    
    
	public void produce() throws InterruptedException {
		
		while(value <= TARGET) {
			
			synchronized(this) {
				
				if(updated)
				 wait();
				
				value++;
				updated = true;
				System.out.println("Prodcer : "+value);
				notify();
				
				Thread.sleep(2000);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		
		while(value <= TARGET) {
			
			synchronized(this) {
				
				if(!updated)
					wait();
				
				updated = false;
				System.out.println("Consumer : "+value);
				notify();
				
				Thread.sleep(2000);
			}
		}
	}
}
