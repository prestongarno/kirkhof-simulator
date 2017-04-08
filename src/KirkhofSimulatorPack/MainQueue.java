package KirkhofSimulatorPack;


import KirkhofSimulatorPack.LinkedList.CustomLinkedList;

import java.util.ArrayList;


public class MainQueue implements ClockListener {

	/** Arraylist that represents checkouts with an int that is dependent on
	 * the checkout is busy
	 */
	private ArrayList<Integer> checkouts = new ArrayList<>();

	/** the max amount of people that can be in the queue */
	private int maxQlength;
	
	/** the time of the next event */
	private int timeOfNextEvent;
	
	/** The current amount of clock ticks - when this equals timeOfNextEvent,
	 * it gets reset to the next person in line's time */
	private int currentAmountOfTicks;
	
	/** the Queue of people */
	private final CustomLinkedList<Person> QUEUE;
	
	/*****************************************
	 * Create a queue with initial size 0
	 ****************************************/
	public MainQueue() {
		QUEUE = new CustomLinkedList<>();
	}
	
	/*****************************************
	 * @param person the person to add to the queue
	 ****************************************/
	public void add(Person person) {
		this.QUEUE.add(person);
	}
	
	/*****************************************
	 * De-queue method / remove a person from the line
	 * @return the person that was at the front of the line
	 ****************************************/
	public Person removePerson() {
		return QUEUE.removeFirst();
	}
	
	/*****************************************
	 * This is where the event happens (remove person if it's time?)
	 *
	 * If the current counter is less than the next person's wait time,
	 * 		all that happens is the counter increments?
	 *
	 * @param tick the current amount
	 ****************************************/
	@Override
	public void event(int tick) {
		if (tick == getTimeOfNextEvent()) {
			// probably need to remove a person? idk what we do here for the queue
		} else this.currentAmountOfTicks++;
	}
	
	/*****************************************
	 * @return the amount of people in the queue
	 ****************************************/
	public int size() {
		return QUEUE.size();
	}
	
	/*****************************************
	 * @return the max amount of people that can be in line
	 ****************************************/
	public int getMaxQlength() {
		return maxQlength;
	}
	
	/*****************************************
	 * @param maxQlength sets the max amount of people that can be in line
	 ****************************************/
	public void setMaxQlength(int maxQlength) {
		this.maxQlength = maxQlength;
	}
	
	/*****************************************
	 * @return the amount of ticks it needs to execute an event
	 ****************************************/
	public int getTimeOfNextEvent() {
		return timeOfNextEvent;
	}
	
	/*****************************************
	 * @param timeOfNextEvent sets the time of the next event
	 ****************************************/
	public void setTimeOfNextEvent(int timeOfNextEvent) {
		this.timeOfNextEvent = timeOfNextEvent;
	}

	/**************************************************************
	 * Adds checkouts to simulation
	 * @param num The number of checkouts
	 **************************************************************/
	public void addCheckouts(int num) {
		for(int i = 0; i < num; i++) {
			checkouts.add(0, i);
		}
	}
}
