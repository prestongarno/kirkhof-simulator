package KirkhofSimulatorPack;

import java.util.Random;


/**************************************************************
 * Creates person with specialized times and adds them to an 
 * eatery.
 * @author Chad, Jessica, Preston, Alex
 * @version 3/27/17
 **************************************************************/
public class PersonProducer implements ClockListener {
	
	/**The next person in line*/
	private int nextPerson = 0;
	
	/**Defines an eatery*/
	private Eatery eateryA[];
	
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
	 * Constructor to create a person and add them to an eatery
	 * 
	 * @param eatery array of eatery objects
	 * @param numOfTicksNextPerson time until next person is added
	 * @param averageEateryTime the time the person take to get food
	 * @param averageCashierTime the time the person takes to 
	 * checkout
	 * @param averageLeaveTime The time the person is no longer 
	 * willing to wait in line
	 **************************************************************/
	public PersonProducer(Eatery eatery[], int numOfTicksNextPerson,
			int averageEateryTime, int averageCashierTime,
			int averageLeaveTime) {

		this.eateryA = eatery;
		this.numOfTicksNextPerson = numOfTicksNextPerson;
		this.averageEateryTime = averageEateryTime;
		this.averageLeaveTime = averageLeaveTime;
		this.averageCashierTime = averageCashierTime;
		// r.setSeed(13); // This will cause the same random numbers
	}

	/**************************************************************
	 * Method called by the clock.
	 *
	 * @param tick time of the clock
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
			int x=addPerson();
			eateryA[x].add(person);
			person.setTickTime(tick);
		}
	}
	/**************************************************************
	 * Method to determine what eatery to add person to
	 * @return Number of eatery the person is sent to
	 **************************************************************/
	private int addPerson(){
		//random number from 0 to 100
		int randNumber = (int)(Math.random() * 100);
		//length of eatery array(number of eateries)
		int num=eateryA.length;
		//dummy counter
		int counter=0;
		//creates range of probabilty 
		int probability=100/(num);
		//creates a temp variable of last value
		int last =0;
		//goes through all ranges
		while(num>counter){
		//creates a range the random number could fall within
		if(randNumber<(probability+last)&&randNumber>last){
			//returns what number eatery
			return counter;
		}
		else {
			//increase the temp variable 
			last=last+probability;
			//increase array position
			counter=counter+1;
		}
		}
		//if ranges fail, send people to first eatery
		return 0;
	}
	
}
