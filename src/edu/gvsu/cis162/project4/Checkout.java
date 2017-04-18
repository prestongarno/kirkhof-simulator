package edu.gvsu.cis162.project4;

import edu.gvsu.cis162.project4.Interfaces.QueueListener;
import edu.gvsu.cis162.project4.people.Person;

import java.lang.*;

/**
 * Created by Chad on 4/8/2017.
 */
public class Checkout extends Venue implements ClockListener {

    int timeOfNextEvent;

    Person person;

    /** the panel object
     */
    private QueueListener listener;

	/** true if this location is open
	 */
	private boolean enabled;

    public Checkout(String name){
    	super(name);
    	this.enabled = true;
    	this.maxQlength = 1;
    }

	@Override
	public int getMaxQlength() {
		return 1;
	}

	@Override
	public int getCurrentVenueTime() {
		return new Double(Q.get(0).getCashierTime()).intValue();
	}

    public void setPerson(Person person) {
        if(person != null) throw new IllegalArgumentException();
        this.person = person;
        timeOfNextEvent += person.getCashierTime();
    }

    public boolean isOpen() {
        return this.person == null;
    }

    @Override
    public void event(int tick) {
        if(tick >= timeOfNextEvent) {
            System.out.println(name + " " + person + tick);

            this.person = null;
        }
    }
    
    public Person getPerson() {
        return person;
    }
}
