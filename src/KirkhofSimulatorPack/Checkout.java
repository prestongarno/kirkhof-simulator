package KirkhofSimulatorPack;

import KirkhofSimulatorPack.people.Person;

import java.lang.*;

/*********************************************************************
 * Class to represent checkout for simulation
 * @author Jessica, Chad, Preston, Alex
 * @version 4/17/17
 ********************************************************************/
public class Checkout<K extends Person> implements ClockListener {
    //add constructor here, this class should be stupid
    //it can't see into the main queue
    //just holds a value 0 for empty and 1 for a person in checkout

	/**time of clock when next person is added/removed*/
    int timeOfNextEvent;

    /**Representation of person*/
    K person;

 
    /*****************************************************************
     * Constructor method for checkout class
     ****************************************************************/
	public Checkout(){
    }
	
	/*****************************************************************
     * Method to set next person
     * @param person current person at checkout
     * @throws IllegalArgumentException person does not exist
     ****************************************************************/
    public void setPerson(K person) {
        if(person != null) throw new IllegalArgumentException();
        this.person = person;
        timeOfNextEvent += person.getCashierTime();
    }

    /*****************************************************************
     * Check if checkout is open
     * @return status of checkout true/false
     ****************************************************************/
    public boolean isOpen() {
        return this.person == null;
    }

    /*****************************************************************
     * Method called by the clock to check for next event time
     * @param tick current time of clock
     ****************************************************************/
    public void event(int tick) {
        if(tick >= timeOfNextEvent) {
            this.person = null;
        }
    }
    /*****************************************************************
     * Getter for person
     * @return person person at checkout
     ****************************************************************/
    public K getPerson() {
        return person;
    }
}
