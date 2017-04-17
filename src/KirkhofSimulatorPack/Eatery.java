package KirkhofSimulatorPack;

import KirkhofSimulatorPack.people.Person;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;


/**********************************************************************
 * Class that simulates one place to get food. Add person to eatery 
 * and then moves to main Q
 * @author Chad, Jessica, Preston, Alex
 * @version 4/1/17
 **********************************************************************/

public class Eatery implements ClockListener {


	// TODO: 4/12/17 use this arraylist instead of person variable for allowing for a line 
	/**The line for the eatery*/
	private ArrayList<Person> Q = new ArrayList<>();
	
	/**The next time in which a person is added*/
	private int timeOfNextEvent = 0;
	
	/**The maximum value for eatery line length*/
	private int maxQlength = 0;

	/**The number of people who have gone through eatery*/
	private int completed = 0;
	
	private String name;

	/**Variable to represent Main Queue linked list*/
	private final MainQueue mainList;

	/**number of people who have lef at this eatery*/
	private int totalPeopleLeft = 0;
	
	/** Value to store the current time on the clock*/
	private int storeTick=0;
	
	/**Average time it takes to complete eatery*/
	private int average=0;
	
	/**Sum of the time it takes to complete eatery*/
	private int sum=0;

	/******************************************************************
	 * Constructor for Eatery
	 * @param mainLinkedList Reference to the Main Queue class
	 ****************************************************************/
	public Eatery(MainQueue mainLinkedList){
		this.mainList = mainLinkedList;
	}
	
	/*****************************************************************
	 * Constructor for Eatery
	 * @param mainLinkedList Reference to the Main Queue class
	 *****************************************************************/
	public Eatery(String name, MainQueue mainLinkedList){
		this.name = name;
		this.mainList = mainLinkedList;
	}

	/*******************************************************************
	 * Getter for property 'name'.
	 *
	 * @return Value for property 'name'.
	 ******************************************************************/
	public String getName() {
		return name;
	}
	
	/*****************************************************************
	 * Setter for property 'name'.
	 *
	 * @param name Value to set for property 'name'.
	 ******************************************************************/
	public void setName(String name) {
		this.name = name;
	}

	/*******************************************************************
	 * Method to add people to eateries
	 * @param person The person to be added to the eatery 
	 *****************************************************************/
	public void add(Person person) {
		Q.add(person);
		if (Q.size() > maxQlength)
			maxQlength = Q.size();
	}

	/*******************************************************************
	 * Method to define the event of the clock
	 * @param tick The current time of the clock
	 ******************************************************************/
	public void event(int tick) {
		Person person = null;

		if (tick >= timeOfNextEvent) {

			if (Q.size() >= 1) {
				person = Q.remove(0);
				// do not send this person as of yet, make
				// them wait.

				timeOfNextEvent = tick
						+ (int) (person.getEateryTime() + 1);
				// this is where you would send on the person to the
				// next listener.
				completed++;


			}
			for (int i = 0; i < Q.size(); i++) {

				if (Q.get(i).getLeaveTime() >= tick - Q.get(i).getTickTime()) {
					//if the person exceeds waiting time, remove from
					//simulation
					Q.remove(i);
					totalPeopleLeft++;
				}

			}

			if (person != null) {
				// take this person to the next station.
				mainList.add(person);
				person = null; // I have send the person on.
				storeTick=tick;
			}


		}
	}
	/****************************************************************
	 * The amount of people still in line
	 * 
	 * @return Q.size The amount of people in the q line
	 ****************************************************************/
	public int getLeft() {
		return Q.size();
	}

	/*****************************************************************
	 * The maximum number of people in line
	 * 
	 * @return maxQlength
	 ****************************************************************/
	public String getMaxQlength() {
		return Integer.toString(maxQlength);
	}
	
	/****************************************************************
	 * Method to get the average time a person spent at the eatery
 	 * 
 	 * @return Value of time spent at eatery
 	 **************************************************************/
	public String getAverageEateryTime()
	{
		// TODO: 4/12/2017 fix this method to work properly
		//to get the GUI to run, this must be commented out 4/12/17 9:20pm
		//sum=storeTick-person.getTickTime()+sum;
		//average=sum/completed;
		return Integer.toString(average);
	}

	
	/****************************************************************
	 * Counter for the number of people going through the eatery
	 * 
	 * @return completed The number of people who have made it 
	 * through the eatery
	 ****************************************************************/
	public int getThroughPut() {
		return completed;
	}

	/***************************************************************
	 * getter for total people who have left
	 * @return totalPeopleLeft number of people who have left at 
	 * this eatery
	 ***************************************************************/
	public int getTotalPeopleLeft() {
		return totalPeopleLeft;
	}
}
