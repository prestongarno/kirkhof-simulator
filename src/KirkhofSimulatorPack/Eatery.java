package KirkhofSimulatorPack;

import java.util.ArrayList;


/**************************************************************
 * 
 * @author
 * @version 3/27/17
 **************************************************************/
public class Eatery implements ClockListener {
	/**The line for the eatery*/
	private ArrayList<Person> Q = new ArrayList<Person>();  
	
	/**The next time in which a person is added*/
	private int timeOfNextEvent = 0;
	
	/**The maximum value for eatery line length*/
	private int maxQlength = 0;
	
	/**Person at eatery*/
	private Person person;   
	
	/**The number of people who have gone through eatery*/
	private int completed = 0;
	
	/**************************************************************
	 * Method to add people to eateries
	 * @param person The person to be added to the eatery 
	 **************************************************************/
	public void add(Person person) {
		Q.add(person);
		if (Q.size() > maxQlength)
			maxQlength = Q.size();
	}

	/**************************************************************
	 * Method to define the event of the clock
	 * @param tick The current time of the clock
	 **************************************************************/
	public void event(int tick) {
		if (tick >= timeOfNextEvent) {
			 if (person != null) { // Notice the delay that takes place here
			 person.getDestination().add(person); // take this person to the
			 next station.
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
	/**************************************************************
	 * The amount of people still in line
	 * 
	 * @return Q.size The amount of people in the q line
	 **************************************************************/
	public int getLeft() {
		return Q.size();
	}

	/**************************************************************
	 * The maximum number of people in line
	 * 
	 * @return maxQlength
	 **************************************************************/
	public int getMaxQlength() {
		return maxQlength;
	}
	
	/**************************************************************
	 * Counter for the number of people going through the eatery
	 * 
	 * @return completed The number of people who have made it 
	 * through the eatery
	 **************************************************************/
	public int getThroughPut() {
		return completed;
	}
}
