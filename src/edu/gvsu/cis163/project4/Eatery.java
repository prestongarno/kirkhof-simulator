package edu.gvsu.cis163.project4;

import java.util.ArrayList;


/** **************************************************
 * @author Roger Ferguson
 * ***************************************************/
public class Eatery implements ClockListener {
	private ArrayList<Person> Q = new ArrayList<Person>();  // the line for eatery
	
	private int timeOfNextEvent = 0;
	private int maxQlength = 0;
	private Person person;   // this is the person at the Eatery.
	private int completed = 0;
	
	public void add (Person person)
	{
		Q.add(person);
		if (Q.size() > maxQlength)
			maxQlength = Q.size();
	}
	
	public void event (int tick){
		if (tick >= timeOfNextEvent) {
//			if (person != null) { 			// Notice the delay that takes place here
//				person.getDestination().add(person);    // take this person to the next station.
//			person = null;				// I have send the person on.
//			}
			
			if (Q.size() >= 1) {
				person = Q.remove(0);		// do not send this person as of yet, make them wait.
				timeOfNextEvent = tick + (int) (person.getEateryTime() + 1);
				// this is where you would send on the person to the next listener.
				completed++;
			}
		}
	}
	
	public int getLeft() {
		return Q.size();
	}
	
	public int getMaxQlength() {
		return maxQlength;
	}
	
	public int getThroughPut() {
		return completed;
	}
}
