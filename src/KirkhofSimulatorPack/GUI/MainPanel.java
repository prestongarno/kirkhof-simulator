package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.Checkout;
import KirkhofSimulatorPack.Interfaces.QueueListener;

import javax.swing.*;
import java.awt.*;

/************************************
 *
 *
 *
 ****************************************/
// TODO: 4/10/17 Add toggle buttons for the eateries and the checkouts
public class MainPanel extends JPanel {
	
	
	private final MainQueueDisplay MAIN_QUEUE;
	private final JPanel EATERIES;
	private final JPanel CHECKOUTS;

	/*****************************************
	 * The Main display jpanel
	 ****************************************/
	public MainPanel() {
		// this is the the panel that holds all subpanels
		setLayout(new BorderLayout(0, 0));
		
		//The layout for the eateries and the checkout
		final GridLayout layout = new GridLayout(1, 10, 4, 4);

		//JPanel that holds the Checkouts
        CHECKOUTS = new JPanel(layout);

		// JPanel that holds the Eateries
		EATERIES = new JPanel(layout);
		
		MAIN_QUEUE = new MainQueueDisplay();

	  	setVisible(true);
	}
	
	/*****************************************
	 * Add an eatery
	 ****************************************/
	public QueueListener addEatery(String name) {
		// todo iterate through amount or split methods
		EateryCheckoutPanel eateryPanel = new EateryCheckoutPanel(name);
		
		// label for the eatery title, possibly replace with icon later
		JLabel label = new JLabel(name);

		// add the title of the eatery
		eateryPanel.add(label, BorderLayout.CENTER);

		//add to this panel
		EATERIES.add(eateryPanel);

		//return the listener to the controller
		return eateryPanel;
	}
	
	
	/*****************************************
	 * Adds a checkout
	 ****************************************/
	public QueueListener addCheckout(String name) {
		// todo iterate through amount or split methods
		EateryCheckoutPanel checkoutPanel = new EateryCheckoutPanel(name);

		// label for the eatery title, possibly replace with icon later
		JLabel label = new JLabel(name);

		// add the title of the eatery
		checkoutPanel.add(label, BorderLayout.CENTER);

		//add to this panel
		CHECKOUTS.add(checkoutPanel);

		//return the listener to the controller
		return checkoutPanel;
	}

	public MainQueueDisplay getMainQDisplay() {
		return MAIN_QUEUE;
	}
}
