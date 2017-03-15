package edu.gvsu.cis163.project4;

/** **************************************************
 * @author Roger Ferguson
 * ***************************************************/
public class Person {
	private int tickTime;  // master clock time
	protected double eateryTime;  // time it takes to order food at eatery
	
	public double getEateryTime() {
		return eateryTime;
	}
	
	public int getTickTime() {
		return tickTime;
	}
	
	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}
	
	public void setEateryTime(double time) {
		this.eateryTime = time;
	}
}
