package KirkhofSimulatorPack;

import KirkhofSimulatorPack.GUI.GUI;
import KirkhofSimulatorPack.GUI.MainPanel;
import KirkhofSimulatorPack.people.PersonProducer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*********************************************************************
 * Controls GUI class initialization
 * @author Preston, Jessica, Chad, Alex
 * @version 4/17/17
 ********************************************************************/
public class Controller {

    /**Number of initial eateries*/
	private static int numEateries=5;

	/**Number of initial checkouts*/
	private static int numCheckouts=5;

	/**Average eatery time*/
	private static int averageEateryTime=20;

	/**Average Cashier time*/
	private static int averageCashierTime=20;

	/**Average Leave time*/
	private static int averageLeaveTime=20;

	/**time until next person is added*/
	private static int numOfTicksNextPerson=20;

	/**gui of type GUI*/
    private final GUI gui;
    
    /**variable of type PersonProducer*/
    private final PersonProducer producer;
    
    /**variable of type clock*/
    private final Clock clock;

	/*****************************************************************
	 * Main method for GUI initialization 
	 * @param args argument for main
	 ****************************************************************/
    public static void main(String[] args) {

        MainPanel mainPanel = new MainPanel();

        GUI gui = new GUI(mainPanel);

        Clock clk = new Clock();
        Eatery eateryArray[]=new Eatery[numEateries];

        MainQueue mainQ = new MainQueue();

        for (int i = 0; i < eateryArray.length; i++) {
            eateryArray[i] = new Eatery(mainQ);
        }

        Checkout checkoutArray[] = new Checkout[numCheckouts];

        PersonProducer newSim = new PersonProducer(eateryArray,
                numOfTicksNextPerson, averageEateryTime,
                averageCashierTime, averageLeaveTime);

        clk.add(newSim);

        for(int i=0; i<numEateries;i++){
            clk.add(eateryArray[i]);
        }

        clk.add(mainQ);

        mainQ.registerStatsListener(gui);
        mainQ.registerQueueListener(mainPanel);

        new Controller(gui, newSim, clk);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(200,200));
        frame.add(gui.getPanel());
        frame.pack();
        frame.setVisible(true);
    }

	/*****************************************************************
	 * Set up constructor for controller class
	 * @param gui GUI implementation
	 * @param producer Sets overall stats of sim
	 * @param clock Time source
	 ****************************************************************/
    Controller(GUI gui, PersonProducer producer, Clock clock) {
        this.gui = gui;
        this.producer = producer;
        this.clock = clock;
        setButtons();
    }

	/*****************************************************************
	 * Sets buttons to start and stop the clock
	 ****************************************************************/
    private void setButtons() {

        this.gui.setStartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.startClock();
            }
        });

        this.gui.setStopButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.stopClock();
            }
        });


        /*if(e.getSource()==updateInfo){
            clk.stopClock();
            if(!avgEatTime.getText().isEmpty())
                averageEateryTime=Integer.parseInt(avgEatTime.getText());
            if(!avgLeaveTime.getText().isEmpty())
                averageLeaveTime=Integer.parseInt(avgLeaveTime.getText());
            if(!avgCashTime.getText().isEmpty())
                averageCashierTime=Integer.parseInt(avgCashTime.getText());
            if(!numTicksNext.getText().isEmpty())
                numOfTicksNextPerson=Integer.parseInt(numTicksNext.getText());
            PersonProducer newSim = new PersonProducer(eateryArray,
                    numOfTicksNextPerson, averageEateryTime,
                    averageCashierTime, averageLeaveTime);
            clk.add(newSim);
        }*/
    }
}
