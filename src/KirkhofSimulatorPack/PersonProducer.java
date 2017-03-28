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
	
	/**Variable to be randomized*/
	private Random r = new Random();
	
	/**************************************************************
	 * 
	 * @param eatery
	 * @param numOfTicksNextPerson
	 * @param averageEateryTime
	 **************************************************************/
	public PersonProducer(Eatery eatery,
								 int numOfTicksNextPerson,
								 int averageEateryTime) {
		
		this.eatery1 = eatery;
		this.numOfTicksNextPerson = numOfTicksNextPerson;
		this.averageEateryTime = averageEateryTime;
		//r.setSeed(13);    // This will cause the same random numbers
	}
	
	
	/**************************************************************
	 * Method called by the clock.
	 *
	 * @param tick
	 **************************************************************/
	public void event(int tick) {
		if (nextPerson <= tick) {
			nextPerson = tick + numOfTicksNextPerson;
			
			Person person = new Person();
			
			int rNumber = (int)(Math.random() * 100);
			//generate randome numbers for tick, eat, leave
			//if(rNumber<20){
				//Person person=new SpecialNeedsPerson(tick, EatTime, LeaveTime);
			//}
			//add rest of type of people

			//sets time based on normal curve
			person.setEateryTime(Math.max(0,
					averageEateryTime * 0.5 * r.nextGaussian()
							+ averageEateryTime + .5)); 
														
			
			person.setTickTime(tick);
			eatery1.add(person);
		}
	}
	
}
