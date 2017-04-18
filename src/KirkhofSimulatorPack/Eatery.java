package KirkhofSimulatorPack;

import KirkhofSimulatorPack.people.Person;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;


/**********************************************************************
 * Class that simulates one place to get food. Add person to eatery 
 * and then moves to main Q
 * @author Chad, Jessica, Preston, Alex
 * @version 4/12/17
 **********************************************************************/

public class Eatery extends Venue implements ClockListener {


	/******************************************************************
	 * Constructor for Eatery
	 ****************************************************************/
	public Eatery(){
		this("Eatery");
	}
	
	/*****************************************************************
	 * Constructor for Eatery
	 *****************************************************************/
	public Eatery(String name){
		super(name);
		this.name = name;
	}

	/*******************************************************************
	 * Method to define the event of the clock
	 * @param tick The current time of the clock
	 ******************************************************************/
	@Override
	public void event(int tick) {
	    int debugLoop = 0;
			System.out.println(this);
		Person person = null;

		if (tick >= timeOfNextEvent) {

			if (Q.size() >= 1) {
				timeOfNextEvent = tick
						+ (int) (Q.get(super.Q.size() - 1).getEateryTime() + 1);
				// this is where you would send on the person to the
				// next listeners.
                if(timeOfNextEvent >= tick) {
                    MainQueue.getInstance().add(Q.remove(0));
				}
				completed++;


			}
			for (int i = 0; i < Q.size()-1; i++) {

				if (Q.get(i).getLeaveTime() > tick - Q.get(i).getTickTime()) {
					//if the person exceeds waiting time, remove from
					//simulation
					Q.remove(i);
					totalPeopleLeft++;
					int finalI = i;
					try {
						this.listeners.forEach(listener -> listener.onPersonLeaveQueue(finalI));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}

			if (person != null) {
				// take this person to the next station.
				MainQueue.getInstance().add(person);
				person = null; // I have send the person on.
				storeTick=tick;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.Q.size());
		Q.forEach(person -> sb.append("\n" + person));

		return name + "\n====================" + sb.toString();
	}
}
