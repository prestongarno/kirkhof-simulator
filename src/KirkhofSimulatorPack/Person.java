package KirkhofSimulatorPack;

/** **************************************************
 * @author Roger Ferguson
 * ***************************************************/
public class Person {
	private int tickTime;  // master clock time
	protected double eateryTime;  // time it takes to order food at eatery
	protected double cashierTime; //time it takes to finish the 
	
	public double getEateryTime() {
		return eateryTime;
	}
	
	public int getTickTime() {
		return tickTime;
	}
	
	public double getCashierTime(){
		return cashierTime;
	}
	
	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}
	
	public void setEateryTime(double time) {
		this.eateryTime = time;
	}
	
	public void setCashierTime(double time){
		this.cashierTime = time;
	}
}
