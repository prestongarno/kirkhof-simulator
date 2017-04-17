package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.Checkout;
import KirkhofSimulatorPack.Eatery;
import KirkhofSimulatorPack.Interfaces.QueueListener;
import KirkhofSimulatorPack.people.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;


/*********************************************************************
 * Class to create logic for main Panel for GUI
 * @author Preston, Chad, Alex, Jessica
 * @version 4/18/17
 *********************************************************************/
public class MainPanel extends JPanel implements QueueListener, ItemListener {
	
	/**Formatting of main Q*/
	private final MainQueueDisplay MAIN_QUEUE;
	
	/**J Panel of eatery objects*/
	private final JPanel EATERIES;
	
	/** J Panel of checkout objects*/
	private final JPanel CHECKOUTS;

	/**Checkbox for checkouts*/
	private JCheckBox checkoutCheckbox[];
	
	/**Checkbox for eateries*/
	private JCheckBox eateryCheckbox[];
	
	/**Panel of Eateries*/
	private JPanel[] eateryPanels;
	
	/**Panel of checkouts*/
	private CheckoutPanel[] checkoutPanels;

	/*****************************************************************
	 * The Main display jpanel
	 ****************************************************************/
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

		checkoutPanels = new CheckoutPanel[5];
		eateryPanels = new EateryPanel[5];


        for (int i = 0; i < 5; i++) {
            checkoutPanels[i] = new CheckoutPanel(new Checkout(), "Checkout #"+i, null);
            eateryPanels[i] = new EateryPanel(new Eatery(null, null), "Eatery #"+i, null);
            checkoutPanels[i].setVisible(true);
            eateryPanels[i].setVisible(true);
        }


        setVisible(true);
	}
	
    /*****************************************************************
     * Adds eatery to display
     * @param eatery index of eatery
	 ****************************************************************/
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
	
	/*****************************************************************
	 * Adds checkout to GUI
	 * @param c representation of checkout
	 ****************************************************************/
	private void addCheckout(Checkout c) {
		CheckoutPanel checkoutPanel = new CheckoutPanel(c, "Checkout " + EATERIES.getComponentCount(),
				c.getPerson() == null ? null : c.getPerson().getIconRepresentation());
		
		this.checkoutPanels = (CheckoutPanel[]) CHECKOUTS.getComponents();
	}
	
	/*****************************************************************
	 * Updates the main panel
	 ****************************************************************/
	public void update() {
		for (CheckoutPanel panel : this.checkoutPanels) {
			final Person person = panel.getCheckout().getPerson();
			panel.setIcon(person == null ? null : person.getIconRepresentation());
		}
	}

	/*****************************************************************
	 * Updates icon in line for Q
	 ****************************************************************/
	public void onUpdateQueue(List<PersonType> line) {
		System.out.println("Current queue: ");
		line.forEach(System.out::print);
	}

	/*****************************************************************
	 * Display when person leaves line
	 * @param index Spot in which person left
	 ****************************************************************/
	public void onPersonLeaveQueue(int index) {
		System.out.println("Person left the Queue! at index: " + index);
	}

	/*****************************************************************
	 * Update if checkbox is checked out not
	 * @param e event listener
	 ****************************************************************/
    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < 5; i++) {
            if(checkoutCheckbox[i].isSelected()){

            }
            else if(eateryCheckbox[i].isSelected()){

            }
        }
    }

    /*****************************************************************
	 * JPanel represents a checkout
	 ****************************************************************/
	private static final class CheckoutPanel extends JPanel implements ItemListener {
		
		private Checkout checkout;
		private String title;
		private Icon icon;
		private JCheckBox checkoutCheckbox;

		/***************************************************************
		 * CheckoutPanel initialization 
		 * @param checkout checkout index
		 * @param title name of checkout
		 * @param icon type of icon
		 **************************************************************/
		public CheckoutPanel(Checkout checkout, String title, Icon icon) {
			this.checkout = checkout;
			this.title = title;
			this.icon = icon;
			checkoutCheckbox = new JCheckBox("Active");
            checkoutCheckbox.setForeground(Color.GREEN);
			checkoutCheckbox.addItemListener(this);
		}
		
		/***************************************************************
		 *  Getter for property 'icon'.
		 *
		 * @return Value for property 'icon'.
		 **************************************************************/
		public Icon getIcon() {
			return icon;
		}

		/***************************************************************
		 *  Getter for property 'title'.
		 *
		 * @return Value for property 'title'.
		 **************************************************************/
		public String getTitle() {
			return title;
		}
		
		/****************************************************************
		 * Setter for property 'icon'.
		 *
		 * @param icon Value to set for property 'icon'.
		 ****************************************************************/
		void setIcon(Icon icon) {
			this.icon = icon;
		}
		
		/***************************************************************
		 * Setter for property 'title'.
		 *
		 * @param title Value to set for property 'title'.
		 ***************************************************************/
		public void setTitle(String title) {
			this.title = title;
		}
		
		/***************************************************************
		 * Getter for checkout
		 * @return checkout type of checkout
		 **************************************************************/
		public Checkout getCheckout() {
			return checkout;
		}


		/***************************************************************
		 * Checks status of check box
		 * @param e event listener
		 **************************************************************/
        public void itemStateChanged(ItemEvent e) {
            if(checkoutCheckbox.isSelected()){
                checkoutCheckbox.setForeground(Color.GREEN);
            }
            else{
                checkoutCheckbox.setForeground(Color.RED);
            }
        }
    }

	/*******************************************************************
	 * Representation of Eatery
	 ******************************************************************/
    private static final class EateryPanel extends JPanel implements ItemListener {

        private Eatery eatery;
        private String title;
        private Icon[] icon;
        private JCheckBox eateryCheckbox;
        

		/**************************************************************
		 * Initialization of eateries
		 * @param eatery index of eatery
		 * @param title name of eatery
		 * @param icon icon representation of eatery
		 *************************************************************/
        public EateryPanel(Eatery eatery, String title, Icon[] icon) {
            this.eatery = eatery;
            this.title = title;
            this.icon = icon;
            eateryCheckbox = new JCheckBox("Active");
            eateryCheckbox.setForeground(Color.GREEN);
            eateryCheckbox.addItemListener(this);
        }

        /**************************************************************
         * Getter for property 'icon'.
         *
         * @return Value for property 'icon'.
         *************************************************************/
        public Icon[] getIcon() {
            return icon;
        }

        /*************************************************************
         * Getter for property 'title'.
         *
         * @return Value for property 'title'.
         ************************************************************/
        public String getTitle() {
            return title;
        }

        /************************************************************
         * Setter for property 'icon'.
         *
         * @param icon Value to set for property 'icon'.
         ***********************************************************/
        void setIcon(Icon[] icon) {
            this.icon = icon;
        }

        /***********************************************************
         * Setter for property 'title'.
         *
         * @param title Value to set for property 'title'.
         ************************************************************/
        public void setTitle(String title) {
            this.title = title;
        }

		/*************************************************************
		 * Getter of eatery
		 * @return eatery instance of eatery
		 ************************************************************/
        public Eatery getEatery() {
            return eatery;
        }


        /*************************************************************
		 * Checks state of box and changes formatting
		 * @param e event listener
		 ************************************************************/
        public void itemStateChanged(ItemEvent e) {
            if(eateryCheckbox.isSelected()){
                eateryCheckbox.setForeground(Color.GREEN);
            }
            else{
                eateryCheckbox.setForeground(Color.RED);
            }
        }
    }
}
