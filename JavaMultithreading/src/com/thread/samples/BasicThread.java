package com.thread.samples;

class HiThread1 extends Thread{
	public void run() {
		for(int i =0 ; i<5 ; i++) {
			System.out.println("Hi");
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
	}
}

class HelloThread1 extends Thread{
	public void run() {
		for(int i =0 ; i<5 ; i++) {
			System.out.println("Hello");
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
	}
}


public class BasicThread {
	
	public static void main(String[] arg) {
		Thread obj1 = new HiThread1();
		Thread obj2 = new HelloThread1();
		
		
		obj1.start();
		obj2.start();
	}

}