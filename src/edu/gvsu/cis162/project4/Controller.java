package edu.gvsu.cis162.project4;

import edu.gvsu.cis162.project4.GUI.EateryCheckoutPanel;
import edu.gvsu.cis162.project4.GUI.GUI;
import edu.gvsu.cis162.project4.GUI.MainPanel;
import edu.gvsu.cis162.project4.Interfaces.QueueListener;
import edu.gvsu.cis162.project4.people.PersonProducer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by preston on 4/12/17.
 */
public class Controller implements ClockListener {

    /**Number of initial eateries*/
	private static int numEateries=5;

	/**Number of initial checkouts*/
	private static int numCheckouts=5;

	/**Average eatery time*/
	private static int averageEateryTime=5;

	/**Average Cashier time*/
	private static int averageCashierTime=1;

	/**Average Leave time*/
	private static int averageLeaveTime=40;

	/**time until next person is added*/
	private static int numOfTicksNextPerson=1;

    private final GUI gui;
    private final PersonProducer producer;
    private final Clock clock;

    /** the list of eateries + checkouts
     */
    private final List<Venue> locations;

    public static void main(String[] args) {

        MainPanel mainPanel = new MainPanel();

        GUI gui = new GUI(mainPanel);

        Clock clk = new Clock();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(200,200));
        new Controller(gui, clk);
        frame.add(gui.getPanel());
        frame.pack();
        //frame.setMinimumSize(new Dimension(400,600));
        frame.setVisible(true);
    }


    Controller(GUI gui, Clock clock) {
        this.gui = gui;
        this.clock = clock;
        setButtons();

        MainQueue mainQ = MainQueue.getInstance();
        MainPanel panel = gui.getMainPanel();

        // list of eaterycheckpanels half of them checkouts
        this.locations = new ArrayList<>(10);

        //================================================
        /* create panels and respective eateries and register the listeners */
        for (int i = 0; i < 5; i++) {
            Eatery ea = new Eatery("Eatery $" + i);
            QueueListener lstnr = panel.addEatery(ea.getName());
            ea.addListener(lstnr);
            this.clock.add(ea);

            Checkout checkout = new Checkout("Checkout $" + i);
            lstnr = panel.addCheckout(checkout.getName());
            checkout.addListener(lstnr);
            this.clock.add(ea);
            locations.add(ea);
            locations.add(checkout);
        }
        //================================================


        this.producer = new PersonProducer(
              locations.stream().filter(venue -> venue instanceof Eatery).toArray(Eatery[]::new),
                numOfTicksNextPerson, averageEateryTime,
                averageCashierTime, averageLeaveTime);

        // add all of the listeners
        clock.add(mainQ);
        clock.add(producer);
        clock.add(this);

        mainQ.registerQueueListener(gui.getMainPanel().getMainQDisplay());
    }

    private void setButtons() {

        this.gui.setStartButtonListener(e -> clock.startClock());

        this.gui.setStopButtonListener(e -> clock.stopClock());

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


    @Override
    public void event(int tick) {
        assert (checkEachLocationCount());
    }
    boolean checkEachLocationCount() {
        return this.locations.stream().filter(venue -> venue instanceof Checkout)
              .anyMatch(venue -> venue.Q.size() == ((EateryCheckoutPanel) venue.listeners.get(0)).icons.size());
    }
}
