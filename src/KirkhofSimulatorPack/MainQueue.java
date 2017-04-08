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

	/**Variable to hold how many people left the sim*/
	private int totalPeopleLeft = 0;

	/**Number of people who have gone through the main queue */
	private int totalCompleted = 0;
	
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
	private Person removePerson() {
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

		if (tick >= timeOfNextEvent) {

			Person person = getNextPerson();

			if(person.getLeaveTime() >= tick){
				//if the person exceeds waiting time, remove from simulation
				QUEUE.remove(person);
				totalPeopleLeft++;
			}


			if (person != null) { // Notice the delay that takes place here
				 // take this person to the checkout
				person = null; // I have send the person on.
			}

			if () { //if the size of the QUEUE is greater than 0
				// do not send this person as of yet, make
				// them wait.

				//person leaves this queue

				// this is where you would send on the person to the next
				// listener.
				totalCompleted++; //increase total completed
			}
		}
	}

	/**
	 *
	 * @return
	 */
	private Person getNextPerson(){
		return QUEUE.getLast(); //return last person in line
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
