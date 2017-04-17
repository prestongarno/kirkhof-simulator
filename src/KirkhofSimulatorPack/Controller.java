package KirkhofSimulatorPack;

import KirkhofSimulatorPack.GUI.EateryCheckoutPanel;
import KirkhofSimulatorPack.GUI.GUI;
import KirkhofSimulatorPack.GUI.MainPanel;
import KirkhofSimulatorPack.people.PersonProducer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private static int averageEateryTime=20;

	/**Average Cashier time*/
	private static int averageCashierTime=20;

	/**Average Leave time*/
	private static int averageLeaveTime=20;

	/**time until next person is added*/
	private static int numOfTicksNextPerson=20;

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
        frame.add(gui.getPanel());
        frame.pack();
        frame.setVisible(true);
    }


    Controller(GUI gui, PersonProducer producer, Clock clock) {
        this.gui = gui;
        this.producer = producer;
        this.clock = clock;
        setButtons();

        MainQueue mainQ = MainQueue.getInstance();
        MainPanel panel = gui.getMainPanel();

        // list of eaterycheckpanels half of them checkouts
        this.locations = new ArrayList<>(10);

        for (int i = 0; i < 5; i++) {
            Eatery ea = new Eatery("Eatery $" + i);
            panel.addEatery(ea.getName());

            Checkout checkout = new Checkout("Checkout $" + i);
            panel.addCheckout(checkout.getName());
            locations.add(ea);
            locations.add(checkout);
        }


        PersonProducer newSim = new PersonProducer(
              locations.stream().filter(venue -> venue instanceof Eatery).toArray(Eatery[]::new),
                numOfTicksNextPerson, averageEateryTime,
                averageCashierTime, averageLeaveTime);

        // add all of the listeners
        clock.add(mainQ);
        clock.add(newSim);

        mainQ.registerQueueListener(gui.getMainPanel().getMainQDisplay());

        new Controller(gui, newSim, clock);
    }

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


    @Override
    public void event(int tick) {
    }
}
