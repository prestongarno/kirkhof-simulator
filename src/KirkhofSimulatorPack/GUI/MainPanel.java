package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.Eatery;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;


/************************************
 * Created by preston on 4/8/17.
 ****************************************/
public class MainPanel extends JPanel {
	
	
	private final JLabel MAIN_QUEUE;
	private final JPanel EATERIES;
	private final JPanel CHECKOUTS;
	
	private JPanel[] eateryPanels;
	private JPanel[] checkoutPanels;
	
	public MainPanel() {
		// this is the the panel that holds all subpanels
		setLayout(new BorderLayout(0, 0));
		
		//The layout for the eateries and the checkout
		final GridLayout layout = new GridLayout(1, 10, 4, 4);
		//JPanel that holds the Checkouts
		CHECKOUTS = new JPanel(layout);
		// JPanel that holds the Eateries
		EATERIES = new JPanel(layout);
		
		// TODO: 4/9/17 next line
		MAIN_QUEUE = new JLabel("What should the main queue be?");
	}
	
	public void setQueue(String label) {
		MAIN_QUEUE.setText(label);
	}
	
	public void addEatery(Eatery eatery) {
		JPanel eateryPanel = new JPanel(new BorderLayout(5, 5));
		
		// label for the eatery title, possibly replace with icon later
		String label;
		if (eatery.getName() == null) {
			label = "Eatery #" + EATERIES.getComponents().length;
		} else label = eatery.getName();
		
		// add the title of the eatery
		eateryPanel.add(new JLabel(label), BorderLayout.CENTER);
		// add the eatery "queue" label, todo possibly change this?
		eateryPanel.add(new JLabel("" + eatery.getTotalPeopleLeft()), BorderLayout.SOUTH);
		
		this.eateryPanels = (JPanel[]) EATERIES.getComponents();
	}
	
	
	public void addCheckout() {
		JPanel checkoutPanel = new JPanel(new BorderLayout(5, 5));
		
		String label;
		if (checkoutPanel.getName() == null) {
			label = "Eatery #" + EATERIES.getComponents().length;
		} else label = checkoutPanel.getName();
		
		// add the title of the checkout
		checkoutPanel.add(new JLabel(label), BorderLayout.CENTER);
		
		this.checkoutPanels = (JPanel[]) CHECKOUTS.getComponents();
	}
	
	public void update() {
		for (JPanel panel : this.checkoutPanels) {
			//update checkouts
		}
		
		//same foreach for the eateries
	}
}
