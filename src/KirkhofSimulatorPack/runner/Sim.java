package KirkhofSimulatorPack.runner;

import KirkhofSimulatorPack.*;


/**************************************************************
 * 
 * 
 **************************************************************/
public class Sim {
	/**************************************************************
	 * 	 
	 * @param args
	 **************************************************************/
	public static void main(String[] args) {
		/**Number of eateries in sim */
		numEateries=4;
		Clock clk = new Clock();
		//make an array of eateries
		Eatery booth[numEateries] = new Eatery(mainQ);
		MainQueue mainQ = new MainQueue();
		
		// 		int numOfTicksNextPerson = 20
		//      int averageBoothTime = 20
		//edit
		
		PersonProducer produce = new PersonProducer(booth[], 20, 18);
		clk.add(produce);
		//clk.add(booth);
				//create for loop to add clock to eateries
				for(int i=0; i<numEateries;i++){
					clk.add(booth[i]);
				}
		clk.add(mainQ);
	
		clk.add(new ClockListener() {
			@Override
			public void event(int tick) {
					System.out.println("Through put is: " + booth.getThroughPut() + " people.");
					System.out.println("People that are still in the Q:" + booth.getLeft() + " people.");
					System.out.println("Max Q length:" + booth.getMaxQlength() + " people.");
					
					//System.out.println("\nMain Queue Through put is: " + mainQ.getCompleted() + " people.");
					System.out.println("People that are still in the main Q: " + mainQ.size() + " people.");
					System.out.println("Max Main Queue length: " +mainQ.getMaxQlength() +" people");
				}
		});
		
		clk.startClock();
		
		while (true) {
			if (clk.getTickCount() == 10) {
				clk.stopClock();
			}
		}
	}
}
