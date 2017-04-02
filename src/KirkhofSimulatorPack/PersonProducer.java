package KirkhofSimulatorPack;

import java.util.Random;


/**************************************************************
 * 
 * @author
 * @version 3/27/17
 **************************************************************/
public class PersonProducer implements ClockListener {
	
	/**The next person in line*/
	private int nextPerson = 0;
	
	/**Defines an eatery*/
	private Eatery eatery1;
	
	/**Time until next person can be added*/
	private int numOfTicksNextPerson;
	
	/**The average amount of time each person takes*/
	private int averageEateryTime;

	/**The average amount of time each person takes at the cashier*/
	private int averageCashierTime;

	/**The average amount of time it takes for a person to leave*/
	private int averageLeaveTime;
	
	/**Variable to be randomized*/
	private Random r = new Random();
	
	/**************************************************************
	 * 
	 * @param eatery
	 * @param numOfTicksNextPerson
	 * @param averageEateryTime
	 **************************************************************/
	public PersonProducer(Eatery eatery, int numOfTicksNextPerson,
			int averageEateryTime, int averageCashierTime,
			int averageLeaveTime) {

		this.eatery1 = eatery;
		this.numOfTicksNextPerson = numOfTicksNextPerson;
		this.averageEateryTime = averageEateryTime;
		this.averageLeaveTime = averageLeaveTime;
		this.averageCashierTime = averageCashierTime;
		// r.setSeed(13); // This will cause the same random numbers
	}

	/**************************************************************
	 * Method called by the clock.
	 *
	 * @param tick
	 **************************************************************/
	public void event(int tick) {
		if (nextPerson <= tick) {
			nextPerson = tick + numOfTicksNextPerson;
			
			Person person;
			
			//generates numbers to 100
			int rNumber = (int)(Math.random() * 100);
			
			//number falls within 10% of population
			//create special needs
			if(rNumber<10) {
				person = new SpecialNeedsPerson();
				//number falls within 20% of population
				//create limited time person
			}
			else if(rNumber<30&&rNumber>=10) {
				person = new LimitedTimePerson();
				//number falls within 70% of population
				//create regular person
			}
			else {
				person = new RegularPerson();
			}

			//sets time based on normal curve for eateryTime
			person.setEateryTime(Math.max(0,
					averageEateryTime * 0.5 * r.nextGaussian()
							+ averageEateryTime + .5)); 
														
			person.setTickTime(tick);
			//sets time based on normal curve for cashierTime
			person.setCashierTime(Math.max(0,
					averageCashierTime * 0.5 * r.nextGaussian()
					+ averageCashierTime + .5));
			//sets time based on normal curve for leaveTime
			person.setLeaveTime(Math.max(0,
					averageLeaveTime * 0.5 * r.nextGaussian()
					+ averageLeaveTime + .5)); 
		
			//add person to eatery
			eatery1.add(person);
		}
	}
	
}
