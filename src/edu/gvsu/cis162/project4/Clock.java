package edu.gvsu.cis162.project4;

import edu.gvsu.cis162.project4.LinkedList.CustomLinkedList;

import javax.swing.*;


/** **************************************************
 * @author Roger Ferguson
 * ***************************************************/
public class Clock {
	
	
	/** list of objects that need	to be informed the clock has changed. */
	private CustomLinkedList<ClockListener> listeners;
	
	/** The max number of listeners*/
	private int MAX = 100;
	
	/**creates the clock*/
	private Timer CLOCK_TIMER;
	
	/**Current time of the clock*/
	private int currentTime;
	/******************************************************************
	 * Initializes the clock
	 *****************************************************************/
	public Clock() {
		listeners = new CustomLinkedList<>();
		this.currentTime = 0;
		CLOCK_TIMER = new Timer(500, e -> {
            Clock.this.tick(currentTime++);
            System.out.println("TICK - " + currentTime);
        });
	}
	/******************************************************************
	 * Starts the clock
	 * 
	 *****************************************************************/
	public void startClock() {
		CLOCK_TIMER.start();
	}

	public void restart() {
		this.CLOCK_TIMER.stop();
		this.CLOCK_TIMER = new Timer(500, e -> {
			Clock.this.tick(currentTime++);
			System.out.println("TICK - " + currentTime);
		});
	}
	/******************************************************************
	 * Adds listeners to the clock
	 * @param cl clocklistener to be added
	 *****************************************************************/
	public void add(ClockListener cl) {
		this.listeners.add(cl);
	}
	/******************************************************************
	 * Returns the clock listeners
	 * @return arr array of listeners
	 *****************************************************************/
	public ClockListener[] getMyListeners() {
		ClockListener[] arr = new ClockListener[this.listeners.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = listeners.get(i);
		}
		return arr;
	}
	/******************************************************************
	 * Clears and sets all new listeners
	 * @param myListeners array of clock listeners
	 *****************************************************************/
	public void setMyListeners(ClockListener[] myListeners) {
		listeners.clear();
		listeners.addAll(myListeners);
	}
	/******************************************************************
	 * Returns number of listerners for the clock
	 * @return the amount of listeners on the clock
	 *****************************************************************/
	public int getNumListeners() {
		return listeners.size();
	}
	/******************************************************************
	 * Returns maximum time of the clock
	 * @return MAX the max time of clock
	 *****************************************************************/
	public int getMAX() {
		return MAX;
	}
	/******************************************************************
	 * Event that calls to the clock
	 * 
	 * @param time current time of clock
	 *****************************************************************/
	public void tick(int time) {
		for (int i = 0; i < this.listeners.size(); i++) {
			listeners.get(i).event(time); // <-- don't know what the event() parameters are supposed to be
		}
	}
	/******************************************************************
	 * Stops the clock
	 *
	 *****************************************************************/
	public void stopClock() {
		CLOCK_TIMER.stop();
		restart();
	}

	/******************************************************************
	 * Returns current time on the clock
	 * @return current time on clock
	 *****************************************************************/
	public int getTickCount() {
		return currentTime;
	}
}



