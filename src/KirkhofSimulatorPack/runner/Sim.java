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
		 int numEateries=4;
		/**Max number of eateries allowed sim */
		int maxEateries=6;
		
		Clock clk = new Clock();
		//make an array of eateries
		Eatery eateryArray[]=new Eatery[numEateries];
		MainQueue mainQ = new MainQueue();
		
		// 		int numOfTicksNextPerson = 20
		//      int averageEateryTime = 18
		
		//PersonProducer(eatery,numOfTicksNextPerson, 
		//averageEateryTime, averageCashierTime, averageLeaveTime) 
		PersonProducer produce = new PersonProducer(eateryArray, 20, 18,20,20);
		clk.add(produce);
		//clk.add(booth);
				//create for loop to add clock to eateries
				for(int i=0; i<numEateries;i++){
					clk.add(eateryArray[i]);
				}
		clk.add(mainQ);
	
		clk.add(new ClockListener() {
			@Override
			public void event(int tick) {
				for(int i=0;i<numEateries;i++){
					System.out.println("Through put is: " + eateryArray[i].getThroughPut() + " people.");
					System.out.println("People that are still in the Q:" + eateryArray[i].getLeft() + " people.");
					System.out.println("Max Q length:" + eateryArray[i].getMaxQlength() + " people.");
					
					//System.out.println("\nMain Queue Through put is: " + mainQ.getCompleted() + " people.");
					System.out.println("People that are still in the main Q: " + mainQ.size() + " people.");
					System.out.println("Max Main Queue length: " +mainQ.getMaxQlength() +" people");
				}
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
