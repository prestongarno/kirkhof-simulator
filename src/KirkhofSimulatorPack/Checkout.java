package KirkhofSimulatorPack;

import KirkhofSimulatorPack.Interfaces.QueueListener;
import KirkhofSimulatorPack.people.Person;

import java.lang.*;
import java.util.Collections;

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
