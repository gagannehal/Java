package com.thread.samples;

class HiThread2 implements Runnable{
	public void run() {
		for(int i =0 ; i<5 ; i++) {
			System.out.println("Hi");
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
	}
}

class HelloThread2  implements Runnable{
	public void run() {
		for(int i =0 ; i<5 ; i++) {
			System.out.println("Hello");
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
	}
}


public class RunnableThread {
	
	public static void main(String[] arg) throws InterruptedException {
		Runnable obj1 = new HiThread2();
		Runnable obj2 = new HelloThread2();
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Executing from main thread");
	}

}