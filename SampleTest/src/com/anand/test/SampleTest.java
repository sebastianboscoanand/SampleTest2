package com.anand.test;

import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class SampleTest implements Runnable {
	
	public int mTemperature;
	public String test;
	
	public SampleTest() {
		mTemperature = 0;
	}

	  public synchronized void makeDinner() {     
	    boilWater();
	  }

	  private synchronized void boilWater() {
	    mTemperature = 100; // unprotected write.
	    test = "Anand";
	    System.out.println("Doing heavy processing - START "+Thread.currentThread().getName()+ mTemperature);
	  }

	@Override
	public void run() {
		System.out.println("Doing heavy processing - START "+Thread.currentThread().getName());
		
		try {
            makeDinner();
            mTemperature = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Doing heavy processing - END "+Thread.currentThread().getName());
		
		
	}
	
	public static void main (String [] args) {
		SampleTest st = new SampleTest();
		 Thread t1 = new Thread(st, "t1");
	     Thread t2 = new Thread(st, "t2");
	        System.out.println("Starting Runnable threads");
	        t1.start();
	        t2.start();
	        System.out.println("Runnable Threads has been started");
	        Thread t3 = new Thread(st, "t3");
	        Thread t4 = new Thread(st, "t4");
	        System.out.println("Starting Runnable threads 2");
	        t3.start();
	        t4.start();
	        System.out.println("Runnable threads has been started");
	}
}
