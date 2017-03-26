package KirkhofSimulatorPack.runner;

import KirkhofSimulatorPack.Clock;
import KirkhofSimulatorPack.Eatery;
import KirkhofSimulatorPack.MainQueue;
import KirkhofSimulatorPack.PersonProducer;


/** **************************************************
 * @author Roger Ferguson
 * ***************************************************/
public class Sim {
	
	
	public static void main(String[] args) {
		
		Clock clk = new Clock();
		Eatery booth = new Eatery();
		MainQueue mainQ = new MainQueue();
		
		// 		int numOfTicksNextPerson = 20
		//      int averageBoothTime = 20
		
		PersonProducer produce = new PersonProducer(booth, 20, 18);
		clk.add(produce);
		clk.add(booth);
		clk.add(mainQ);
		
		clk.run(10000);
		
		System.out.println("Through put is: " + booth.getThroughPut() + " people.");
		System.out.println("People that are still in the Q:" + booth.getLeft() + " people.");
		System.out.println("Max Q length:" + booth.getMaxQlength() + " people.");
		
		System.out.println("\nMain Queue Through put is: " + mainQ.getCompleted() + " people.");
		System.out.println("People that are still in the main Q: " + mainQ.size() + " people.");
		System.out.println("Max Main Queue length: " +mainQ.getMaxQlength() +" people");
	}
}
