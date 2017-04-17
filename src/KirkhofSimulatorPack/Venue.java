package KirkhofSimulatorPack;

import KirkhofSimulatorPack.GUI.PersonType;
import KirkhofSimulatorPack.Interfaces.QueueListener;
import KirkhofSimulatorPack.people.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by preston on 4/17/17.
 ****************************************/
public abstract class Venue implements ClockListener {

	// TODO: 4/12/17 use this arraylist instead of person variable for allowing for a line
	/**The line for the venue*/
	protected ArrayList<Person> Q;

	/**The next time in which a person is added*/
	protected int timeOfNextEvent = 0;

	/**The maximum value for venue line length*/
	protected int maxQlength = 0;

	/**The number of people who have gone through venue*/
	protected int completed = 0;

	protected String name;

	/**number of people who have lef at this venue*/
	protected int totalPeopleLeft = 0;

	/** Value to store the current time on the clock*/
	protected int storeTick=0;

	/**Average time it takes to complete venue*/
	protected int average=0;

	/**Sum of the time it takes to complete venue*/
	protected int sum=0;

	/** the list of objects listening for changes in the amount of people in this venue
	 ****************************************/
	protected List<QueueListener> listeners;
	private boolean enabled;

	/*****************************************
	 * Constructor for Venue
	 * @param name the name of the venue
	 ****************************************/
	public Venue(String name){
		this.Q =  new ArrayList<>();
		this.listeners = new ArrayList<>();
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if(!enabled) {
			this.Q.clear();
			updateListeners();
		}
	}

	private void updateListeners() {
		listeners.forEach(listener -> listener.onUpdateQueue(Q.stream()
				.map(person -> (PersonType.getType(person)))
				.collect(Collectors.toCollection(ArrayList::new))));
	}

	private void addListener(QueueListener listener) {
		this.listeners.add(listener);
	}

	private void removeListener(QueueListener listener) {
		this.listeners.remove(listener);
	}

	/*****************************************
	 * Getter for property 'name'.
	 *
	 * @return Value for property 'name'.
	 ****************************************/
	public String getName() {
		return name;
	}

	/*****************************************
	 * Setter for property 'name'.
	 *
	 * @param name Value to set for property 'name'.
	 ****************************************/
	public void setName(String name) {
		this.name = name;
	}

	/*****************************************
	 * Method to add people to eateries
	 * @param person The person to be added to the venue
	 ****************************************/
	public void add(Person person) {
		Q.add(person);
		if (Q.size() > maxQlength)
			maxQlength = Q.size();
	}
	/*****************************************
	 * The amount of people still in line
	 *
	 * @return Q.size The amount of people in the q line
	 ****************************************/
	public int getLeft() {
		return Q.size();
	}

	/*****************************************
	 * The maximum number of people in line
	 *
	 * @return maxQlength
	 ****************************************/
	public String getMaxQlength() {
		return Integer.toString(maxQlength);
	}

	/*****************************************
	 * Method to get the average time a person spent at the venue
 	 *
 	 * @return Value of time spent at venue
 	 ****************************************/
	public String getAverageVenueTime()
	{
		// TODO: 4/12/2017 fix this method to work properly
		//to get the GUI to run, this must be commented out 4/12/17 9:20pm
		//sum=storeTick-person.getTickTime()+sum;
		//average=sum/completed;
		return Integer.toString(average);
	}


	/*****************************************
	 * Counter for the number of people going through the venue
	 *
	 * @return completed The number of people who have made it
	 * through the venue
	 ****************************************/
	public int getThroughPut() {
		return completed;
	}

	/*****************************************
	 * getter for total people who have left
	 * @return totalPeopleLeft number of people who have left at
	 * this venue
	 ****************************************/
	public int getTotalPeopleLeft() {
		return totalPeopleLeft;
	}
}
