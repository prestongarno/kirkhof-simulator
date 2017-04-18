package edu.gvsu.cis162.project4.LinkedList;

/*****************************************
 * The entry class for the queue -
 * package private no one else has to know about this class
 * @param <T> an object
 ****************************************/
final class Entry<T> {
	
	
	/** The object for this entry */
	private final T obj;
	
	/** The next person on the list */
	private Entry<T> next;
	
	/*****************************************
	 * Creates a list entry
	 * @param obj the entry
	 * @param next the next item
	 ****************************************/
	Entry(T obj, Entry<T> next) {
		this.obj = obj;
		this.next = next;
	}
	
	/*****************************************
	 * @param next sets the next person
	 ****************************************/
	public void setNext(Entry<T> next) {
		this.next = next;
	}
	
	/*****************************************
	 * @return get the object for this entry
	 ****************************************/
	public T get() {
		return obj;
	}
	
	/*****************************************
	 * @return get the next object for this entry in the list
	 ****************************************/
	public Entry<T> getNext() {
		return next;
	}
}
