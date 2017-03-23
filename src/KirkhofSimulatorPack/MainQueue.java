package KirkhofSimulatorPack;

import java.util.ArrayList;

public class MainQueue implements ClockListener{

	private ArrayList<Person> mQ = new ArrayList<Person>();
	
	private int completed = 0;
	private int maxQlength = 0;
	private int timeOfNextEvent = 0;
	private Person person;
	
	public void add(Person person){
		mQ.add(person);
		if (mQ.size() > maxQlength)
			maxQlength = mQ.size();
	}
	
	public void event(int tick){
		if(tick >= timeOfNextEvent){
			if(mQ.size() >=1){
				person = mQ.remove(0);
				timeOfNextEvent = tick + (int) (person.getCashierTime() + 1);
				completed++;
			}
		}
	}

	public int getLeft() {
		return mQ.size();
	}
	
	public ArrayList<Person> getQ() {
		return mQ;
	}

	public void setQ(ArrayList<Person> q) {
		mQ = q;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}
