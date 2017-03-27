package KirkhofSimulatorPack.LinkedList;

import KirkhofSimulatorPack.ClockListener;


/** **************************************************
 * kirkhof-simulator - KirkhofSimulatorPack.LinkedList - by Preston Garno on 3/27/17
 *
 * This is a linkedList that can be used for anything
 * ***************************************************/
public class CustomLinkedList<T> {
	
	private Entry<T> head;
	private int size;
	
	/*****************************************
	 * Creates a new list
	 ****************************************/
	public CustomLinkedList() {
	}
	
	/*****************************************
	 * Adds an item to the beginning of the list
	 * @param t the item to add
	 ****************************************/
	public void add(T t) {
		if (head == null) { // case: empty list
			head = new Entry<>(t, null);
		} else {
			Entry<T> tail = getTail();
			
			if(tail == null) {
				head.setNext(new Entry<>(t, null));
			} else tail.setNext(new Entry<>(t, null));
		}
		
		size++;
	}
	
	/*****************************************
	 * Inserts an item at the beginning of the list
	 * @param t the item to insert
	 ****************************************/
	public void addFirst(T t) {
		Entry<T> temp = head;
		head = new Entry<>(t, temp);
		
		size++;
	}
	
	/*****************************************
	 * @param t the item to add to the end of the list
	 ****************************************/
	public void addLast(T t) {
		size++;
		final Entry<T> entry = new Entry<>(t, null);
		
		if(head == null) { head = entry; }
		
		else getTail().setNext(entry);
	}
	
	/*****************************************
	 * This removes an item at the beginning of the list
	 *
	 * @return the item that was removed from the beginning of the list
	 ****************************************/
	public T removeFirst() {
		if(size() == 0) throw new IllegalArgumentException("List is empty!");
		
		T item = this.head.get();
		head = head.getNext();
		size--;
		return item;
	}
	
	/*****************************************
	 * Remove an item from the list
	 * @param toRemove the item from the list
	 * @return true if the item existed in the list, false if it didn't
	 ****************************************/
	public boolean remove(T toRemove) {
		if(head == null) return false;
		
		Entry<T> temp = head;
		
		//case: one item in the list
		if (head.getNext() == null || head.get().equals(toRemove)) {
				head = head.getNext();
				size--;
				return temp.get().equals(toRemove);
		}
		
		while (temp.getNext() != null &&
				!temp.getNext().get().equals(toRemove)) {
			temp = temp.getNext();
		}
		
		if(temp.getNext() == null) return false;
		
		// getting here means that the next item == toRemove
		temp.setNext(temp.getNext().getNext());
		size--;
		return true;
	}
	
	/*****************************************
	 * @param index the index of the item to get
	 * @return the item at the index
	 ****************************************/
	public T get(int index) {
		if(size() == 0 | index < 0 | index > size())
			throw new IndexOutOfBoundsException(
					"Requested: " + index + " List size: " + size());
		
		if(head == null) return null;
		
		Entry<T> temp = head;
		
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		
		return temp.get();
	}
	
	/*****************************************
	 * @return amount of items in a list
	 ****************************************/
	public int size() {
		return this.size;
	}
	
	/*****************************************
	 * @return the last item on the list
	 ****************************************/
	private Entry<T> getTail() {
		
		//this shouldn't happen
		if (head == null) throw new IndexOutOfBoundsException("No items in list");
		
		if(head.getNext() == null) return head;
		
		Entry<T> temp = head;
		
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	public void clear() {
		this.head = null;
	}
	
	/*****************************************
	 * Adds all of an array to the list
	 * @param items the array to add to the list
	 ****************************************/
	public void addAll(T[] items) {
		if(this.head == null) {
			head = new Entry<>(items[0], null);
		}
		
		Entry<T> temp = this.getTail();
		
		for (T t : items) {
			if (t != null) {
				temp.setNext(new Entry<>(t, null));
				temp = temp.getNext();
			}
		}
	}
}
