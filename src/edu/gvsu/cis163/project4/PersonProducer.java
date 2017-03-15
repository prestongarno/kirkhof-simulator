package edu.gvsu.cis163.project4;

import java.util.Random;


/** **************************************************
 * @author Roger Ferguson
 * ***************************************************/
public class PersonProducer implements ClockListener {
	
	private int nextPerson = 0;
	private Eatery eatery;
	private int numOfTicksNextPerson;
	private int averageEateryTime;
	
	private Random r = new Random();
	
	public PersonProducer(Eatery eatery,
								 int numOfTicksNextPerson,
								 int averageEateryTime) {
		
		this.eatery = eatery;
		this.numOfTicksNextPerson = numOfTicksNextPerson;
		this.averageEateryTime = averageEateryTime;
		//r.setSeed(13);    // This will cause the same random numbers
	}
	
	
	// This is the method that is called by the clock.
	public void event(int tick) {
		if (nextPerson <= tick) {
			nextPerson = tick + numOfTicksNextPerson;
			
			Person person = new Person();
			
			int rNumber = (int)(Math.random() * 100);
			
			person.setEateryTime(Math.max(0,averageEateryTime*0.5*r.nextGaussian() + averageEateryTime +.5));
			person.setTickTime(tick);
			eatery.add(person);
		}
	}
	
}
