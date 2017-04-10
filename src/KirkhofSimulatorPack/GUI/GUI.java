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
import KirkhofSimulatorPack.*;
/**
 *
 */
public class GUI extends JFrame implements KeyListener, ActionListener  {

	/**Number of initial eateries*/
	private int numEateries=4;
	
	/**Max number of eateries */
	private int maxEateries=5;
	
	/**Average eatery time*/
	private int averageEateryTime=20;
	
	/**Average Cashier time*/
	private int averageCashierTime=20;
	
	/**Average Leave time*/
	private int averageLeaveTime=20;
	
	/**time until next person is added*/
	private int numOfTicksNextPerson=20;
	
    /**panel for the GUI elements to be placed on*/
    private JPanel panel;

    /**panel to use for the main program graphics */
    private JPanel centerPanel;
    
    /** Panel contains game functions */
	private JPanel panelLeft;

	/** Panel contains game statistics */
	private JPanel panelRight;
	
	/** Panel on top */
	private JPanel panelUp;

	/** Panel on bottom */
	private JPanel panelDown;
	
	/**Button to start simulation*/
	private JButton startButton;
	
	/**Button to stop simulation*/
	private JButton stopButton;
    
    /**Total number of people who completed Simulation**/
    private JLabel numCompleted;
    
    /**Number of Special needs people to complete sim*/
    private JLabel  numCompleteSpecial;
    
    /**Number of Regular people to complete sim*/
    private JLabel  numCompleteReg;
    
    /**Number of Limited time people to complete sim*/
    private JLabel  numCompleteLimited;
    
    /**Average Time for special needs to complete sim*/
    private JLabel  averageTimeCompleteSpecial;
    
    /**Average Time for regular people to complete sim*/
    private JLabel  averageTimeCompleteReg;
    
    /**Average time for limited time people to complete sim*/
    private JLabel  averageTimeCompleteLimited;
    
    /**Average time for people to go through Eatery 1*/
    private JLabel  averageTimeCompleteEatery1;
    
    /**Total amount of people who left sim without completion*/
    private JLabel numCustomersLost;
    
    /**Total amount of people to entered simulation*/
    private JLabel totalPeople;
    
    /**Input for average eatery time*/
    private JTextField avgEatTime;
    
    /**Input for average cashiertime*/
    private JTextField avgCashTime;
    
    /**Input for average leave time*/
    private JTextField avgLeaveTime;
    
    /**Input for time until next person added*/
    private JTextField numTicksNext;
    
    /**Button to update input*/
    private JButton updateInfo;
    
    /**Creation of clock*/
    private Clock clk=new Clock();
    
    /**Creation of array of eateries*/
    private Eatery eateryArray[];
    


/**********************************************************************
 * Application of GUI Panels for buttons and stats
 *********************************************************************/
    public GUI(){
    	
    	Clock clk = new Clock();
    	Eatery eateryArray[]=new Eatery[numEateries];
		MainQueue mainQ = new MainQueue();

		PersonProducer newSim = new PersonProducer(eateryArray,
				numOfTicksNextPerson, averageEateryTime,
				averageCashierTime, averageLeaveTime);
		clk.add(newSim);
		for(int i=0; i<numEateries;i++){
			clk.add(eateryArray[i]);
		}

		clk.add(mainQ);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setVisible(true);
		panel.setFocusable(true);

		// creation of Center Panel
		// Center panel runs simulation
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 5));
        
        //creation of left panel
        //Displays buttons text fields
     	panelLeft= new JPanel();
     	panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

     	//Left Panel Elements
     	startButton = new JButton("Start");
     	stopButton = new JButton("Stop");
     	avgEatTime=new JTextField();
     	avgLeaveTime=new JTextField();
     	avgCashTime=new JTextField();
     	numTicksNext=new JTextField();
     	updateInfo=new JButton("Update Info");
     	
     	//Left Panel Action Listeners
     	startButton.addActionListener(this);
     	stopButton.addActionListener(this);
     	updateInfo.addActionListener(this);
     	
     	//Add elements to left panel
        // Use of rigid area to create spacing between elements
        panelLeft.add(startButton);
        panelLeft.add(Box.createRigidArea(new Dimension(0,5)));
        panelLeft.add(stopButton);
        panelLeft.add(new JLabel("Average Eatery Time"));
        panelLeft.add(avgEatTime);
        panelLeft.add(new JLabel("Average Leave Time"));
        panelLeft.add(avgLeaveTime);
        panelLeft.add(new JLabel("Average Cash Time"));
        panelLeft.add(avgCashTime);
        panelLeft.add(new JLabel("Time Until Next Person"));
        panelLeft.add(numTicksNext);
        panelLeft.add(updateInfo);
     	
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
/***********************************************************************
 * Method that will Update all the stats for sim
 * @param tick calls event every clock cycle
 */
    public void event(int tick){
    	numCompleted.setText("Number of People Completed: ");
	    numCompleteSpecial.setText("Number of Special People Completed: ");
	    numCompleteReg.setText("Number of Regular People Completed: ");
	    numCompleteLimited.setText("Number of Limited Time People Completed: ");
	    averageTimeCompleteSpecial.setText("Average Time Speical People for Completion: ");
	    averageTimeCompleteReg.setText("Average Time Regular People Completion: ");
	    averageTimeCompleteLimited.setText("Average Time Limited Time People Completion: ");
	    averageTimeCompleteEatery1.setText("Average Time to go Through Eatery 1: ");
	    numCustomersLost.setText("Number of Customers Lost: ");
	    totalPeople.setText("Total Number of Customers: ");
    }

 /**********************************************************************
  * Action perform statements for buttons
  *********************************************************************/
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==startButton){
    		clk.startClock();
        }
        
        if(e.getSource()==stopButton){
        	clk.stopClock();
        }
        
        if(e.getSource()==updateInfo){
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
