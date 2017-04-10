package KirkhofSimulatorPack;

import javax.swing.*;


/**************************************************************
 * 
 * @author
 * @version 3/27/17
 ****************************************/
public abstract class Person {
	private int tickTime; // master clock time
	protected double eateryTime; // time it takes to order food at eatery
	protected double cashierTime; // time it takes to finish the
	protected double leaveTime; // time it takes before person leaves queue

	/*****************************************
	 * Getter for eatery time. Time for person to order and get 
	 * their food at an eatery.
	 * @return eateryTime Time for a person to order and get food
	 ****************************************/
	public double getEateryTime() {
		return eateryTime;
	}

	/*****************************************
	 * Getter for leave time. Max time person will spend before
	 * leaving the queue
	 * @return leaveTime Time that person will spend in queue
	 ****************************************/
	public double getLeaveTime() {
		return leaveTime;
	}

	/*****************************************
	 * Getter for tickTime. Time value for person at given instance
	 * @return tickTime Time value at certain point
	 ****************************************/
	public int getTickTime() {
		return tickTime;
	}

	/*****************************************
	 * Getter for Cashiertime. Time for person to checkout
	 * @return cashierTime Time to checkout
	 ****************************************/
	public double getCashierTime() {
		return cashierTime;
	}

	/*****************************************
	 * Setter for TickTime. Sets a value from the clock
	 * 
	 * @param tickTime Time value for a person at an instance
	 ****************************************/
	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}

	/*****************************************
	 * Setter for LeaveTime
	 *
	 * @param leaveTime Determines the amount of time a person
	 * is willing to spend in the queue
	 ****************************************/
	public void setLeaveTime(double leaveTime) {
		this.leaveTime = leaveTime;
	}

	/*****************************************
	 * Setter for EateryTime
	 * 
	 * @param time Determines the amount of time a person spends
	 * at an eatery.
	 ****************************************/
	public void setEateryTime(double time) {
		this.eateryTime = time;
	}

	/*****************************************
	 * Setter for cashierTime.
	 * 
	 * @param time Determines the amount of time a person spends at 
	 * checkout
	 ****************************************/
	public void setCashierTime(double time) {
		this.cashierTime = time;
	}
	
	/*****************************************
	 * @return Returns an Icon representation of the person
	 ****************************************/
	public abstract Icon getIconRepresentation();
}

