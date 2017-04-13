package KirkhofSimulatorPack;

import KirkhofSimulatorPack.people.Person;

import java.lang.*;

/**
 * Created by Chad on 4/8/2017.
 */
public class Checkout<K extends Person> implements ClockListener {
    //add constructor here, this class should be stupid
    //it can't see into the main queue
    //just holds a value 0 for empty and 1 for a person in checkout

    int timeOfNextEvent;

    K person;

    public Checkout(){
    }

    public void setPerson(K person) {
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
            this.person = null;
        }
    }
    
    public K getPerson() {
        return person;
    }
}
