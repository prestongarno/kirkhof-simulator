package KirkhofSimulatorPack.people;

import KirkhofSimulatorPack.GUI.Util;

import javax.swing.*;


/**************************************************************
 *  Class specifications of regular person
 * @author Jessica, Chad, Alex, Preston
 **************************************************************/
public class RegularPerson extends Person {

    /**************************************************************
     * Setter methods
     * @param time The persons eatery time
     **************************************************************/
    public void setEateryTime(double time) {
    	super.setEateryTime(time); 
    	}
    /**************************************************************
     * Setter methods
     * @param time The persons cashier time
     **************************************************************/
    public void setCashierTime(double time) { 
    	super.setCashierTime(time); 
    	}
    
    /**************************************************************
     * Getter method
     * @return  icon representation
     **************************************************************/
    public Icon getIconRepresentation() {
        return Util.REGULAR_PERSON;
    }
    
    public void setLeaveTime(double time) { super.setLeaveTime(time); }

}
