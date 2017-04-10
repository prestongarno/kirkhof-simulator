package KirkhofSimulatorPack;


import KirkhofSimulatorPack.LinkedList.CustomLinkedList;

import java.util.ArrayList;
import java.util.List;


public class MainQueue implements ClockListener {

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

	/**Variable to represent checkout line*/
	private final List<Checkout> checkouts;
	
	/*****************************************
	 * Create a queue with initial size 0
	 ****************************************/
	public MainQueue() {
		QUEUE = new CustomLinkedList<>();
		checkouts = new ArrayList<>();
	}
	
	/*****************************************
	 * @param person the person to add to the queue
	 ****************************************/
	public void add(Person person) {
		this.QUEUE.add(person);
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
		for(Checkout checkout : this.checkouts) {
			if(checkout.isOpen()) {
				checkout.setPerson(this.QUEUE.removeLast());
			}
		}

		Person p;
		for (int i = 0; i < QUEUE.size(); i++) {
			p = QUEUE.get(i);
			if(p.getLeaveTime() >= tick - p.getTickTime()) {
				QUEUE.remove(p);
			}
		}
	}


	/**
	 *
	 * @return
	 */
	private Person getNextPerson(){
		//TODO: fix getLast() method in the linked list
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

}
