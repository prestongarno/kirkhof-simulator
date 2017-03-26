package KirkhofSimulatorPack;

import java.util.ArrayList;

public class MainQueue implements ClockListener{

	private int completed = 0;
	private int maxQlength = 0;
	private int timeOfNextEvent = 0;
    /** The next in line */
    private Entry<Person> first;
    private int size;

    /**
     * Create a queue with initial size 0
     */
    public MainQueue() {
        this.size = 0;
    }

    /**
     * @param person the person to add to the queue
     */
    public void add(Person person){

        this.size ++;

        if(first == null) first = new Entry<>(person, null);

	   else {
           Entry temp = this.first;
	       while (temp.getNext() != null) {
	           temp = temp.getNext();
           }
           temp.setNext(new Entry<>(person, null));
        }
	}

    /**
     * De-queue method / remove a person from the line
     * @return the person that was at the front of the line
     */
    public Person removePerson() {
        Person p = this.first.getPerson();
        this.first = first.getNext();
        return p;
    }

    /**
     * This is where the event happens (remove person if it's time)
     * @param tick the current amount
     */
    @Override
    public void event(int tick){
		if(tick >= timeOfNextEvent){
		}
	}

	public int size() {
		return this.size;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public int getMaxQlength() {
		return maxQlength;
	}

	public void setMaxQlength(int maxQlength) {
		this.maxQlength = maxQlength;
	}

	public int getTimeOfNextEvent() {
		return timeOfNextEvent;
	}

	public void setTimeOfNextEvent(int timeOfNextEvent) {
		this.timeOfNextEvent = timeOfNextEvent;
	}

    /**
     * The entry class for the queue
     * @param <T> a person or subclass of person
     */
    private static final class Entry<T extends Person> {

        /** The person for this entry */
        final T person;

        /** The next person on the list */
        Entry next;

        public Entry(T person, Entry next) {
            this.person = person;
            this.next = next;
        }

        /**
         * @param next sets the next person
         */
        public void setNext(Entry next) {
            this.next = next;
        }

        /**
         * @return get the person for this entry
         */
        public T getPerson() {
            return person;
        }

        /**
         * @return get the next person for this entry in the list
         */
        public Entry<T> getNext() {
            return next;
        }
    }
	
}
