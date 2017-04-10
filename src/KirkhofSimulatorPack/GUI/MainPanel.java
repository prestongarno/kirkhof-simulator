package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.Checkout;
import KirkhofSimulatorPack.Eatery;
import KirkhofSimulatorPack.MainQueue;
import KirkhofSimulatorPack.Person;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/************************************
 * Created by preston on 4/8/17.
 ****************************************/
// TODO: 4/10/17 Add toggle buttons for the eateries and the checkouts
public class MainPanel extends JPanel {
	
	
	private final MainQueueDisplay MAIN_QUEUE;
	private final JPanel EATERIES;
	private final JPanel CHECKOUTS;
	
	private JPanel[] eateryPanels;
	private CheckoutPanel[] checkoutPanels;
	
	/*****************************************
	 * The Main display jpanel
	 ****************************************/
	public MainPanel(MainQueue queue, List<Eatery> eateries, List<Checkout> checkouts) {
		// this is the the panel that holds all subpanels
		setLayout(new BorderLayout(0, 0));
		
		//The layout for the eateries and the checkout
		final GridLayout layout = new GridLayout(1, 10, 4, 4);
		//JPanel that holds the Checkouts
		CHECKOUTS = new JPanel(layout);
		// JPanel that holds the Eateries
		EATERIES = new JPanel(layout);
		
		for (Eatery e : eateries) {
			this.addEatery(e);
		}
		
		for (Checkout c : checkouts) {
			this.addCheckout(c);
		}
		MAIN_QUEUE = new MainQueueDisplay();
	}
	
	/*****************************************
	 * Add an eatery
	 * @param eatery the eatery to add
	 ****************************************/
	private void addEatery(Eatery eatery) {
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
	
	
	/*****************************************
	 * Adds a checkout
	 ****************************************/
	private void addCheckout(Checkout c) {
		CheckoutPanel checkoutPanel = new CheckoutPanel(c, "Checkout " + EATERIES.getComponentCount(),
				c.getPerson() == null ? null : c.getPerson().getIconRepresentation());
		
		this.checkoutPanels = (CheckoutPanel[]) CHECKOUTS.getComponents();
	}
	
	/*****************************************
	 * Updates the main panel
	 ****************************************/
	public void update() {
		for (CheckoutPanel panel : this.checkoutPanels) {
			final Person person = panel.getCheckout().getPerson();
			panel.setIcon(person == null ? null : person.getIconRepresentation());
		}
	}
	
	/*****************************************
	 * The Jpanel that represents a checkout
	 ****************************************/
	private static final class CheckoutPanel extends JPanel {
		
		private Checkout checkout;
		private String title;
		private Icon icon;
		
		public CheckoutPanel(Checkout checkout, String title, Icon icon) {
			this.checkout = checkout;
			this.title = title;
			this.icon = icon;
		}
		
		/*****************************************
		 * Getter for property 'icon'.
		 *
		 * @return Value for property 'icon'.
		 ****************************************/
		public Icon getIcon() {
			return icon;
		}
		
		/*****************************************
		 * Getter for property 'title'.
		 *
		 * @return Value for property 'title'.
		 ****************************************/
		public String getTitle() {
			return title;
		}
		
		/*****************************************
		 * Setter for property 'icon'.
		 *
		 * @param icon Value to set for property 'icon'.
		 ****************************************/
		void setIcon(Icon icon) {
			this.icon = icon;
		}
		
		/*****************************************
		 * Setter for property 'title'.
		 *
		 * @param title Value to set for property 'title'.
		 ****************************************/
		public void setTitle(String title) {
			this.title = title;
		}
		
		public Checkout getCheckout() {
			return checkout;
		}
	}
}
