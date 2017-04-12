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
/**********************************************************************
 * Main application of GUI for food court simulation
 *
 *@author 
 *@version 4/12/17
 *********************************************************************/
public class GUI extends JFrame implements ActionListener  {

	/**Number of initial eateries*/
	private int numEateries=5;

	/**Number of initial checkouts*/
	private int numCheckouts=5;
	
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
    
    /**Average time for people to go through Eatery 2*/
    private JLabel  averageTimeCompleteEatery2;
    
    /**Average time for people to go through Eatery 3*/
    private JLabel  averageTimeCompleteEatery3;
    
    /**Average time for people to go through Eatery 4*/
    private JLabel  averageTimeCompleteEatery4;
    
    /**Average time for people to go through Eatery 5*/
    private JLabel  averageTimeCompleteEatery5;
    
    /**Value for the maximum amount of people in line Eatery1*/
    private JLabel maxLineEatery1;
    
    /**Value for the maximum amount of people in line Eatery2*/
    private JLabel maxLineEatery2;
    
    /**Value for the maximum amount of people in line Eatery3*/
    private JLabel maxLineEatery3;
    
    /**Value for the maximum amount of people in line Eatery4*/
    private JLabel maxLineEatery4;
    
    /**Value for the maximum amount of people in line Eatery5*/
    private JLabel maxLineEatery5;
    
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
    private Clock clk = new Clock();
    
    /**Creation of array of eateries*/
    private Eatery eateryArray[];
    
    /**Current time of the clock*/
    private JLabel currentTime;
    
    /** Maximum length of the Q*/
     private JLabel maxQlength;
     
     /**Current length of the Q*/
     private JLabel currentQlength;


/**********************************************************************
 * Application of GUI Panels for buttons and stats
 *********************************************************************/
    public GUI(){
    	
    	Clock clk = new Clock();
    	Eatery eateryArray[]=new Eatery[numEateries];
		MainQueue mainQ = new MainQueue();
		Checkout checkoutArray[] = new Checkout[numCheckouts];

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

		//TODO need to change eateryArray and checkoutArray to arrays in the MainPanel class or vice versa (but that would be harder)
		//centerPanel.add(new MainPanel(mainQ, eateryArray, checkoutArray));
        
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
	    averageTimeCompleteEatery2= new JLabel("Average Time to go Through Eatery 2: ");
	    averageTimeCompleteEatery3= new JLabel("Average Time to go Through Eatery 3: ");
	    averageTimeCompleteEatery4= new JLabel("Average Time to go Through Eatery 4: ");
	    averageTimeCompleteEatery5= new JLabel("Average Time to go Through Eatery 5: ");
	    maxLineEatery1= new JLabel("Maximum length of line at Eatery 1: ");
	    maxLineEatery2= new JLabel("Maximum length of line at Eatery 2: ");
	    maxLineEatery3= new JLabel("Maximum length of line at Eatery 3: ");
	    maxLineEatery4= new JLabel("Maximum length of line at Eatery 4: ");
	    maxLineEatery5= new JLabel("Maximum length of line at Eatery 5: ");
	    numCustomersLost= new JLabel("Number of Customers Lost: ");
	    totalPeople= new JLabel("Total Number of Customers: ");
	    currentTime= new JLabel("Current Time: ");
	    currentQlength= new JLabel("Current length of Q: ");
	    maxQlength= new JLabel("Max length of the Q: ");
	    
	    //Add Elements to Right Panel
	    panelRight.add(numCompleted);
	    panelRight.add(numCompleteSpecial);
	    panelRight.add(numCompleteReg);
	    panelRight.add(numCompleteLimited);
	    panelRight.add(averageTimeCompleteSpecial);
	    panelRight.add(averageTimeCompleteReg);
	    panelRight.add(averageTimeCompleteLimited);
	    panelRight.add(averageTimeCompleteEatery1);
	    panelRight.add(averageTimeCompleteEatery2);
	    panelRight.add(averageTimeCompleteEatery3);
	    panelRight.add(averageTimeCompleteEatery4);
	    panelRight.add(averageTimeCompleteEatery5);
		panelRight.add(numCustomersLost);
		panelRight.add(totalPeople);
		panelRight.add( maxLineEatery1);
		panelRight.add( maxLineEatery2);
		panelRight.add( maxLineEatery3);
		panelRight.add( maxLineEatery4);
		panelRight.add( maxLineEatery5);
		panelRight.add(currentTime);
		panelRight.add(currentQlength);
		panelRight.add(maxQlength);
		
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
 ***********************************************************************/
    public void event(int tick){
    	numCompleted.setText("Number of People Completed: ");
	    numCompleteSpecial.setText("Number of Special People Completed: ");
	    numCompleteReg.setText("Number of Regular People Completed: ");
	    numCompleteLimited.setText("Number of Limited Time People Completed: ");
	    averageTimeCompleteSpecial.setText("Average Time Speical People for Completion: ");
	    averageTimeCompleteReg.setText("Average Time Regular People Completion: ");
	    averageTimeCompleteLimited.setText("Average Time Limited Time People Completion: ");
	    averageTimeCompleteEatery1.setText("Average Time to go Through Eatery 1: "+ eateryArray[0].getAverageEateryTime());
	    averageTimeCompleteEatery2.setText("Average Time to go Through Eatery 2: "+eateryArray[1].getAverageEateryTime());
	    averageTimeCompleteEatery3.setText("Average Time to go Through Eatery 3: "+eateryArray[2].getAverageEateryTime());
	    averageTimeCompleteEatery4.setText("Average Time to go Through Eatery 4: "+eateryArray[3].getAverageEateryTime());
	    averageTimeCompleteEatery5.setText("Average Time to go Through Eatery 5: "+eateryArray[4].getAverageEateryTime());
	    maxLineEatery1.setText("Maximum length of line at Eatery 1: "+eateryArray[0].getMaxQlength());
	    maxLineEatery2.setText("Maximum length of line at Eatery 2: "+eateryArray[1].getMaxQlength());
	    maxLineEatery3.setText("Maximum length of line at Eatery 3: "+eateryArray[2].getMaxQlength());
	    maxLineEatery4.setText("Maximum length of line at Eatery 4: "+eateryArray[3].getMaxQlength());
	    maxLineEatery5.setText("Maximum length of line at Eatery 5: "+eateryArray[4].getMaxQlength());
	    numCustomersLost.setText("Number of Customers Lost: ");
	    totalPeople.setText("Total Number of Customers: ");
	    currentTime.setText("Current Time: "+Integer.toString(clk.getTickCount()));
	    currentQlength.setText("Current length of Q: ");
	    maxQlength.setText("Max length of the Q: ");
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

	/**
	 * Main method to run the program
	 * @param args
	 */
	public static void main(String[] args){
		new GUI();
	}

}
