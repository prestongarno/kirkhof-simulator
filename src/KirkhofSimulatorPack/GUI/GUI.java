package KirkhofSimulatorPack.GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.text.*;

/**
 * Created by Alex on 4/2/2017.
 * Added beginning elements and structure Jessica on 4/5
 */
public class GUI extends JFrame implements KeyListener, ActionListener  {

    /**panel for the GUI elements to be placed on*/
    JPanel panel;

    /**panel to use for the main program graphics */
    JPanel centerPanel;
    
    /** Panel contains game functions */
	private JPanel panelLeft;

	/** Panel contains game statistics */
	private JPanel panelRight;
	
	/** Panel on top */
	private JPanel panelUp;

	/** Panel on bottom */
	private JPanel panelDown;
	
	/**Button to add eateries */
	private JButton addEatery;
	
	/**Button to remove eateries */
	private JButton removeEatery;

	/**Button to remove checkout */
    private JButton removeCheckout;

	/**Button to remove checkouts */
    private JButton addCheckout;

    public GUI(){
        panel = new JPanel();
        
        panel.setLayout(new BorderLayout());
        panel.setVisible(true);
        panel.setFocusable(true);
       
     	// creation of Center Panel
     	//Center panel runs simulation
     	centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5,5));
        
        //creation of left panel
        //Displays buttons text fields
     	panelLeft= new JPanel();
     	panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

     	//Left Panel Elements
     	addEatery = new JButton("Add Eatery");
     	removeEatery= new JButton("Remove Eatery");
     	addCheckout = new JButton("Add Checkout");
     	removeCheckout = new JButton("Remove Checkout");
     	
     	//Left Panel Action Listeners
     	addEatery.addActionListener(this);
     	removeEatery.addActionListener(this);
     	addCheckout.addActionListener(this);
     	removeCheckout.addActionListener(this);

     	//Add elements to left panel
        // Use of rigid area to create spacing between elements
     	panelLeft.add(addEatery);
     	panelLeft.add(Box.createRigidArea(new Dimension(0,5)));
     	panelLeft.add(removeEatery);
        panelLeft.add(Box.createRigidArea(new Dimension(0,5)));
        panelLeft.add(addCheckout);
        panelLeft.add(Box.createRigidArea(new Dimension(0,5)));
        panelLeft.add(removeCheckout);
     	
		// creation of right panel
		// Displays stats of simulation
		panelRight = new JPanel();
		panelRight
		.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));

		// Up and Down panel Creation
		panelUp = new JPanel();
		panelUp.setLayout(new FlowLayout());
		panelDown = new JPanel();
		panelDown.setLayout(new FlowLayout());

		// Add all panels to main panel
		panel.add(panelUp, BorderLayout.NORTH);
		panel.add(panelDown, BorderLayout.SOUTH);
		panel.add(panelRight, BorderLayout.EAST);
		panel.add(panelLeft, BorderLayout.WEST);
		panel.add(centerPanel, BorderLayout.CENTER);
		add(panel);

    }


    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addEatery){
            try {
                //add an eatery
            }
            catch(Exception exception){

            }
        }

        if(e.getSource() == removeEatery){
            try {
                //remove an eatery
            }
            catch(Exception exception){

            }
        }

        //TODO add more buttons and listeners

    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
