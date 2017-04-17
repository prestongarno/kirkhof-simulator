package KirkhofSimulatorPack;


import KirkhofSimulatorPack.GUI.MainPanel;
import KirkhofSimulatorPack.GUI.PersonType;
import KirkhofSimulatorPack.Interfaces.QueueListener;
import KirkhofSimulatorPack.LinkedList.CustomLinkedList;
import KirkhofSimulatorPack.people.Person;

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

	private int averageTimeInQueue;
	/** the amount of people that have passed through the main queue */
	private int throughput;

	private static MainQueue instance;

	/*****************************************
	 * This solves the problem of accessing the main queue from checkouts and eateries
	 * @return the instance of the main queue
	 ****************************************/
	public static MainQueue getInstance() {
		return instance == null ? instance = new MainQueue() : instance;
	}
	
	/*****************************************
	 * Create a queue with initial size 0
	 ****************************************/
	private MainQueue() {
		QUEUE = new CustomLinkedList<>();
		checkouts = new ArrayList<>();
		QUEUE_LISTENERS = new ArrayList<>();
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
				this.throughput ++;
				// update stats
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


	/*****************************************
	 *
	 * @return
	 ****************************************/
	private Person getNextPerson(){
		//TODO: fix getLast() method in the linked list
		return QUEUE.removeLast(); //return last person in line
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

	public CustomLinkedList<Person> getPeople() {
		return QUEUE;
	}

	final List<QueueListener> QUEUE_LISTENERS;

	public void registerQueueListener(QueueListener listener) {
		QUEUE_LISTENERS.add(listener);
	}
}
