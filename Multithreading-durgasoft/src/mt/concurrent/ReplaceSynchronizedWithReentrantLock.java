package mt.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReplaceSynchronizedWithReentrantLock {

	public static void main(String[] args) {
		
		Display d = new Display();
		MyThread t1 = new MyThread(d, "dhoni");
		MyThread t2 = new MyThread(d, "kholi");
		MyThread t3 = new MyThread(d, "rohit");
		
		t1.start(); t2.start(); t3.start();
	}
	
}

class MyThread extends Thread{
	Display d;
	String  name;
	
	MyThread(Display d, String name){
		this.d = d;
		this.name = name;
	}
	
	//without synchronized or reentrant
	/*
	public void run() {
		d.display1(name);
	}
	*/
	
	//with synchronized
	/*
	public void run() {
		d.display2(name);
	}
	*/
	
	//with ReentrantLock
	public void run() {
		d.display3(name);
	}
}
class Display{ 
	
	public void display1(String name) {
		
		for(int i=1 ; i<=10 ; i++) {
			System.out.print("Hai : ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
	public synchronized void display2(String name) {
		
		for(int i=1 ; i<=3 ; i++) {
			System.out.print("Hai : ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
	
	ReentrantLock l = new ReentrantLock();
	
	public void display3(String name) {
		
		
		l.lock();
		for(int i=1 ; i<=3 ; i++) {
			System.out.print("Hai : ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
		l.unlock();
	}

	
}
