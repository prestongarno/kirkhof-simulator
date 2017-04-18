package edu.gvsu.cis162.project4;

import edu.gvsu.cis162.project4.GUI.PersonType;
import edu.gvsu.cis162.project4.Interfaces.QueueListener;
import edu.gvsu.cis162.project4.people.Person;

import javax.swing.*;
import java.util.ArrayList;
import java.util.stream.Collectors;


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
	public Eatery() {
		this("Eatery");
	}

	/*****************************************************************
	 * Constructor for Eatery
	 *****************************************************************/
	public Eatery(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public int getMaxQlength() {
		return 20;
	}

	@Override
	public int getCurrentVenueTime() {
		return new Double(Q.get(0).getEateryTime()).intValue();
	}

	/*******************************************************************
	 * Method to define the event of the clock
	 * @param tick The current time of the clock
	 ******************************************************************/
	@Override
	public void event(int tick) {
		SwingUtilities.invokeLater(() -> {
			if (Q.size() > 0) {
				// this is where you would send on the person to th;
				// next listeners.
				if (tick > timeOfNextEvent) {
					MainQueue.getInstance().add(Q.remove(0));
					for (QueueListener qlstnr : this.listeners) {
						qlstnr.onUpdateQueue(
								Q.stream().map(PersonType::getType)
										.collect(Collectors.toCollection(ArrayList::new)));
					}
				}
				completed++;
			}
			for (int i = 0; i < Q.size() - 1; i++) {

				if (Q.get(i).getLeaveTime() > tick - Q.get(i).getTickTime()) {
					//if the person exceeds waiting time, remove from
					//simulation
					for (QueueListener qlstnr : this.listeners) {
						qlstnr.onPersonLeaveQueue(i);
					}
					totalPeopleLeft++;
				}
			}
		});
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.Q.size());
		Q.forEach(person -> sb.append("\n" + person));

		return name + "\n====================" + sb.toString();
	}
}
