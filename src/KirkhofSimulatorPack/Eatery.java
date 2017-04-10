package KirkhofSimulatorPack;

import java.util.ArrayList;


/**************************************************************
 * Class that simulates one place to get food. Add person to 
 * eatery and then moves to main Q
 * @author Chad, Jessica, Preston, Alex
 * @version 3/27/17
 ****************************************/
public class Eatery implements ClockListener {
	/**The line for the eatery*/
	private ArrayList<Person> Q = new ArrayList<>();
	
	/**The next time in which a person is added*/
	private int timeOfNextEvent = 0;
	
	/**The maximum value for eatery line length*/
	private int maxQlength = 0;
	
	/**Person at eatery*/
	private Person person;   
	
	/**The number of people who have gone through eatery*/
	private int completed = 0;
	
	private String name;

	/**Variable to represent Main Queue linked list*/
	private final MainQueue mainList;

	/**number of people who have lef at this eatery*/
	private int totalPeopleLeft = 0;

	/*****************************************
	 * Constructor for Eatery
	 * @param mainLinkedList Reference to the Main Queue class
	 ****************************************/
	public Eatery(MainQueue mainLinkedList){
		this.mainList = mainLinkedList;
	}
	
	/*****************************************
	 * Constructor for Eatery
	 * @param mainLinkedList Reference to the Main Queue class
	 ****************************************/
	public Eatery(String name, MainQueue mainLinkedList){
		this.name = name;
		this.mainList = mainLinkedList;
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
	 * @param person The person to be added to the eatery 
	 ****************************************/
	public void add(Person person) {
		Q.add(person);
		if (Q.size() > maxQlength)
			maxQlength = Q.size();
	}

	/*****************************************
	 * Method to define the event of the clock
	 * @param tick The current time of the clock
	 ****************************************/
	public void event(int tick) {

		if (tick >= timeOfNextEvent) {

			if(person.getLeaveTime() >= tick - person.getTickTime()){
				//if the person exceeds waiting time, remove from simulation
				Q.remove(person);
				totalPeopleLeft++;
			}


			 if (person != null) { // Notice the delay that takes place here
			 mainList.add(person); // take this person to the next station.
			 person = null; // I have send the person on.
			 }

			if (Q.size() >= 1) {
				person = Q.remove(0); // do not send this person as of yet, make
										// them wait.

				// *****need to add this person to the MAIN queue after the
				// person leaves this queue
				// *****does this use linked list? ^

				timeOfNextEvent = tick
						+ (int) (person.getEateryTime() + 1);
				// this is where you would send on the person to the next
				// listener.
				completed++;
			}
		}
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
	public int getMaxQlength() {
		return maxQlength;
	}
	
	/*****************************************
	 * Counter for the number of people going through the eatery
	 * 
	 * @return completed The number of people who have made it 
	 * through the eatery
	 ****************************************/
	public int getThroughPut() {
		return completed;
	}

	/*****************************************
	 * getter for total people who have left
	 * @return totalPeopleLeft number of people who have left at this eatery
	 ****************************************/
	public int getTotalPeopleLeft() {
		return totalPeopleLeft;
	}
}
