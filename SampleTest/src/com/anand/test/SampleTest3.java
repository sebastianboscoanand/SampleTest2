package com.anand.test;


public class SampleTest3 {
	
	  public int mTemperature;
	  public String test;

	  public void makeDinner() {     
	    boilWater();
	  }

	  private void boilWater() {
	    mTemperature = 100; // unprotected write.
	  }

}
