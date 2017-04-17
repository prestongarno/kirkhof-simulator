package KirkhofSimulatorPack.people;

import KirkhofSimulatorPack.GUI.Util;

import javax.swing.*;


/**************************************************************
 *  Special Needs people specifications
 * @author Preston, Chad, Jessica, Alex
 * @version 3/31/17
 **************************************************************/ 
public class SpecialNeedsPerson extends Person {

/**************************************************************
 *  Method to set eatery time to be 4 times as much as a 
 *  regular person
 * @param time average eatery time
 **************************************************************/
    public void setEateryTime(double time) {
        super.setEateryTime(time*4);
    }

/**************************************************************
 *  Method to set cashier time to be 2 times as much as a 
 *  regular person
 * @param time average cashier time
 **************************************************************/ 
    public void setCashierTime(double time) {
        super.setCashierTime(time*2);
    }
   
/**************************************************************
 *  Getter method of icon
 * @return icon of special needs person 
 **************************************************************/ 
   public Icon getIconRepresentation() {
      return Util.SPECIAL_NEEDS_PERSON;
   }
   
 /**************************************************************
  *  Method to set leave time to be 2 times as much as a 
  *  regular person
  * @param time average leave time
  **************************************************************/ 
    public void setLeaveTime(double time){
    	super.setLeaveTime(time*3);
    }
}
