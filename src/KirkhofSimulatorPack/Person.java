package KirkhofSimulatorPack;

/**************************************************************
 * 
 * @author
 * @version 3/27/17
 **************************************************************/
public class Person {
	private int tickTime; // master clock time
	protected double eateryTime; // time it takes to order food at eatery
	protected double cashierTime; // time it takes to finish the

	/**************************************************************
	 * Getter for eatery time. Time for person to order and get 
	 * their food at an eatery.
	 * @return eateryTime Time for a person to order and get food
	 **************************************************************/
	public double getEateryTime() {
		return eateryTime;
	}

	/**************************************************************
	 * Getter for tickTime. Time value for person at given instance
	 * @return tickTime Time value at certain point
	 **************************************************************/
	public int getTickTime() {
		return tickTime;
	}

	/**************************************************************
	 * Getter for Cashiertime. Time for person to checkout
	 * @return cashierTime Time to checkout
	 **************************************************************/
	public double getCashierTime() {
		return cashierTime;
	}

	/**************************************************************
	 * Setter for TickTime. Sets a value from the clock
	 * 
	 * @param tickTime Time value for a person at an instance
	 **************************************************************/
	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}

	/**************************************************************
	 * Setter for EateryTime
	 * 
	 * @param time Determiens the amount fo time a person spends 
	 * at an eatery.
	 **************************************************************/
	public void setEateryTime(double time) {
		this.eateryTime = time;
	}

	/**************************************************************
	 * Setter for cashierTime.
	 * 
	 * @param time Determines the amount of time a person spends at 
	 * checkout
	 **************************************************************/
	public void setCashierTime(double time) {
		this.cashierTime = time;
	}
}

