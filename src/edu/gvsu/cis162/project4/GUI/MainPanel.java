package edu.gvsu.cis162.project4.GUI;

import edu.gvsu.cis162.project4.Interfaces.QueueListener;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

	private static final Dimension SIDE_PANEL_SIZE = new Dimension(400,300);
	private static final Dimension MAIN_PANEL_SIZE = new Dimension(500,1000);

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
        final GridLayout sidePanelLayouts = new GridLayout(5, 1);

		//JPanel that holds the Checkouts
        CHECKOUTS = new JPanel(sidePanelLayouts);

		// JPanel that holds the Eateries
		EATERIES = new JPanel(sidePanelLayouts);
		MAIN_QUEUE = new MainQueueDisplay();

		this.add(EATERIES, BorderLayout.WEST);
		this.add(CHECKOUTS, BorderLayout.EAST);
		this.add(MAIN_QUEUE, BorderLayout.CENTER);
		EATERIES.setSize(SIDE_PANEL_SIZE);
		EATERIES.setPreferredSize(SIDE_PANEL_SIZE);
		CHECKOUTS.setPreferredSize(SIDE_PANEL_SIZE);
		CHECKOUTS.setSize(SIDE_PANEL_SIZE);
		EATERIES.setOpaque(false);
		CHECKOUTS.setOpaque(false);
		MAIN_QUEUE.setOpaque(false);
		EATERIES.setVisible(true);
		CHECKOUTS.setVisible(true);
		MAIN_QUEUE.setVisible(true);
		setFocusable(false);
		setOpaque(false);
	  	setVisible(true);
	}
	
	/*****************************************
	 * Add an eatery
	 ****************************************/
	public QueueListener addEatery(String name) {
		// todo iterate through amount or split methods
		EateryCheckoutPanel eateryPanel = new EateryCheckoutPanel(name);
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
		//add to this panel
		CHECKOUTS.add(checkoutPanel);

		//return the listener to the controller
		return checkoutPanel;
	}

	public MainQueueDisplay getMainQDisplay() {
		return MAIN_QUEUE;
	}
}
