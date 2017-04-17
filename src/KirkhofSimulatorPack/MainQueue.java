package KirkhofSimulatorPack;


import KirkhofSimulatorPack.GUI.PersonType;
import KirkhofSimulatorPack.Interfaces.QueueListener;
import KirkhofSimulatorPack.Interfaces.StatsListener;
import KirkhofSimulatorPack.LinkedList.CustomLinkedList;
import KirkhofSimulatorPack.people.Person;

import java.util.ArrayList;
import java.util.List;

/**********************************************************************
 * Class to create and go through logic of Main Q holding area. Moves
 * people from eatery and passes on to checkout.
 * 
 * @author Preston, Alex, Jessica, Chad
 * @version 4/18/17
 ********************************************************************/
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

	private int averageTimeInQueue;
	/** the amount of people that have passed through the main queue */
	private int throughput;
	
	/*****************************************************************
	 * Create a queue with initial size 0
	 *****************************************************************/
	public MainQueue() {
		QUEUE = new CustomLinkedList<>();
		checkouts = new ArrayList<>();
		OBSERVERING = new ArrayList<>();
		QUEUE_LISTENERS = new ArrayList<>();
	}
	
	/******************************************************************
	 * Method to add person
	 * @param person the person to add to the queue
	  *****************************************************************/
	public void add(Person person) {
		this.QUEUE.add(person);
	}
	
	/******************************************************************
	 * This is where the event happens (remove person if it's time?)
	 *
	 * If the current counter is less than the next person's wait time,
	 * 		all that happens is the counter increments?
	 *
	 * @param tick the current amount
	  *****************************************************************/
	public void event(int tick) {
		for(Checkout checkout : this.checkouts) {
			if(checkout.isOpen()) {
				checkout.setPerson(this.QUEUE.removeLast());

				// this is where our interface instances get updated
				this.throughput ++;
				for (StatsListener s : this.OBSERVERING) {
					s.onAverageMainQueueTime(tick);
				}
			}
		}

		List<PersonType> typesQueue = new ArrayList<>(size());
		Person p;
		for (int i = 0; i < QUEUE.size(); i++) {
			p = QUEUE.get(i);
			typesQueue.add(PersonType.getType(p));
			if(p.getLeaveTime() >= tick - p.getTickTime()) {
				QUEUE.remove(p);
			}
		}

		for (QueueListener q : QUEUE_LISTENERS) {
			q.onUpdateQueue(typesQueue);
		}
	}


	 /****************************************************************
	 * Getter to get the last person in line 
	 * @return remove last returns last person in line
	 *****************************************************************/
	private Person getNextPerson(){
		//TODO: fix getLast() method in the linked list
		return QUEUE.removeLast(); //return last person in line
	}
	
	/******************************************************************
	 * Method to find the amount of people in line
	 * @return the amount of people in the queue
	  *****************************************************************/
	public int size() {
		return QUEUE.size();
	}
	
	/******************************************************************
	 * Method to get the max amount of people in line
	 * @return the max amount of people that can be in line
	 *****************************************************************/
	public int getMaxQlength() {
		return maxQlength;
	}

	/******************************************************************
	 * Method to no longer allow people in line after a set amount. 
	 * @param maxQlength sets the max amount of people that can be in 
	 * line
	 *****************************************************************/
	public void setMaxQlength(int maxQlength) {
		this.maxQlength = maxQlength;
	}
	
	/******************************************************************
	 * Getter to return time of event
	 * @return the amount of ticks it needs to execute an event
	  *****************************************************************/
	public int getTimeOfNextEvent() {
		return timeOfNextEvent;
	}
	
	/******************************************************************
	 * Method to find value of clock for next event
	 * @param timeOfNextEvent sets the time of the next event
	 *****************************************************************/
	public void setTimeOfNextEvent(int timeOfNextEvent) {
		this.timeOfNextEvent = timeOfNextEvent;
	}

	/******************************************************************
	 * Method return people in the Q
	 * @return QUEUE people in the Q
	 *****************************************************************/
	public CustomLinkedList<Person> getPeople() {
		return QUEUE;
	}

	// observer pattern

	final List<StatsListener> OBSERVERING;
	final List<QueueListener> QUEUE_LISTENERS;

	/******************************************************************
	 * Method to add stats to variable
	 * @param stats Statistics involved with given variabel
	  *****************************************************************/
	public void registerStatsListener(StatsListener stats) {
		OBSERVERING.add(stats);
	}

	/******************************************************************
	 * Method to remove stats from variable
	 * @param stats Statistics involved with given variable
	  *****************************************************************/
	public void removeStats(StatsListener stats) {
		OBSERVERING.remove(stats);
	}

	/******************************************************************
	 * Resisteres Q listener
	 * @param listener adds action listener
	  *****************************************************************/
	public void registerQueueListener(QueueListener listener) {
		QUEUE_LISTENERS.add(listener);
	}
}
