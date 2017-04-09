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
	
	/**Button to start simulation*/
	private JButton startButton;
	
	/**Button to stop simulation*/
	private JButton stopButton;

	/**Button to remove checkout */
    private JButton removeCheckout;

	/**Button to remove checkouts */
    private JButton addCheckout;
    
    /**Total number of people who completed Simulation**/
    private JLabel numCompleted;
    
    /**Number of Special needs people to complete sim*/
    private JLabel  numCompleteSpecial;
    
    /**Number of Regular people to complete sim*/
    private JLabel  numCompleteReg;
    
    /**Number of Limitied time people to complete sim*/
    private JLabel  numCompleteLimited;
    
    /**Average Time for speical needs to complete sim*/
    private JLabel  averageTimeCompleteSpecial;
    
    /**Average Time for regualar people to complete sim*/
    private JLabel  averageTimeCompleteReg;
    
    /**Average time for limited time people to complete sim*/
    private JLabel  averageTimeCompleteLimited;
    
    /**Average time for people to go through Eatery 1*/
    private JLabel  averageTimeCompleteEatery1;
    
    /**Total amount of people who left sim without completion*/
    private JLabel numCustomersLost;
    
    /**Total amount of people to entered simulation*/
    private JLabel totalPeople;
    
    

/**********************************************************************
 * Application of GUI Panels for buttons and stats
 *********************************************************************/
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
     	startButton = new JButton("Start");
     	stopButton = new JButton("Stop");
     	
     	//Left Panel Action Listeners
     	addEatery.addActionListener(this);
     	removeEatery.addActionListener(this);
     	addCheckout.addActionListener(this);
     	removeCheckout.addActionListener(this);
     	startButton.addActionListener(this);
     	stopButton.addActionListener(this);

     	//Add elements to left panel
        // Use of rigid area to create spacing between elements
     	panelLeft.add(addEatery);
     	panelLeft.add(Box.createRigidArea(new Dimension(0,5)));
     	panelLeft.add(removeEatery);
        panelLeft.add(Box.createRigidArea(new Dimension(0,5)));
        panelLeft.add(addCheckout);
        panelLeft.add(Box.createRigidArea(new Dimension(0,5)));
        panelLeft.add(removeCheckout);
        panelLeft.add(Box.createRigidArea(new Dimension(0,5)));
        panelLeft.add(startButton);
        panelLeft.add(Box.createRigidArea(new Dimension(0,5)));
        panelLeft.add(stopButton);
     	
		// creation of right panel
		// Displays stats of simulation
		panelRight = new JPanel();
		panelRight
		.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));

		//Right Panel Elements
		numCompleted = new JLabel("Number of People Completed: ");
	    numCompleteSpecial= new JLabel("Number of Special People Completed: ");
	    numCompleteReg= new JLabel("Number of Regular People Completed: ");
	    numCompleteLimited= new JLabel("Number of Limited Time People Completed: ");
	    averageTimeCompleteSpecial= new JLabel("Average Time Speical People for Completion: ");
	    averageTimeCompleteReg= new JLabel("Average Time Regular People Completion: ");
	    averageTimeCompleteLimited= new JLabel("Average Time Limited Time People Completion: ");
	    averageTimeCompleteEatery1= new JLabel("Average Time to go Through Eatery 1: ");
	    numCustomersLost= new JLabel("Number of Customers Lost: ");
	    totalPeople= new JLabel("Total Number of Customers: ");
	    
	    //Add Elements to Right Panel
	    panelRight.add(numCompleted);
	    panelRight.add(numCompleteSpecial);
	    panelRight.add(numCompleteReg);
	    panelRight.add(numCompleteLimited);
	    panelRight.add(averageTimeCompleteSpecial);
	    panelRight.add(averageTimeCompleteReg);
	    panelRight.add(averageTimeCompleteLimited);
	    panelRight.add(averageTimeCompleteEatery1);
		panelRight.add(numCustomersLost);
		panelRight.add(totalPeople);
		
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


 /**********************************************************************
  * Action perform statements for buttons
  *********************************************************************/
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addEatery){
            try {
                //add an eatery
            }
            catch(Exception exception){
            	JOptionPane.showMessageDialog(null, "Maximum"
						+ "number of Eateries reached.");
            }
        }

        if(e.getSource() == removeEatery){
            try {
                //remove an eatery
            }
            catch(Exception exception){
            	JOptionPane.showMessageDialog(null, "1 Eatery"
						+ "must always be present");
            }
        }
        
        if(e.getSource()==addCheckout){
        	  try {
                  //add a checkout
              }
              catch(Exception exception){
              	JOptionPane.showMessageDialog(null, "Maximum"
  						+ "number of checkouts reached.");
              }
        }
        
        if(e.getSource()==removeCheckout){
        	   try {
                   //remove a checkout
               }
               catch(Exception exception){
               	JOptionPane.showMessageDialog(null, "1 checkout"
   						+ "must always be present");
               }
        }
        
        if(e.getSource()==startButton){
        	
        }
        
        if(e.getSource()==stopButton){
        	
        }


    }
    
    
/**********************************************************************
 * Action performed if key is typed
 *********************************************************************/
    public void keyTyped(KeyEvent e) {

    }

 /**********************************************************************
  * Action performed if key is pressed
  *********************************************************************/
    public void keyPressed(KeyEvent e) {

    }

/**********************************************************************
 * Action performed if key is released
 *********************************************************************/
    public void keyReleased(KeyEvent e) {

    }
}
