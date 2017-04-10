package KirkhofSimulatorPack;

import KirkhofSimulatorPack.GUI.Util;

import javax.swing.*;


/**************************************************************
 * Set specifications for limited time person
 **************************************************************/
public class LimitedTimePerson extends Person {

/**************************************************************
 *  Method to set eatery time to be 0.5 as much as a 
 *  regular person
 * @param time average eatery time
 **************************************************************/
    public void setEateryTime(double time) {
        super.setEateryTime(time*.5);
    }
   
   @Override
   Icon getIconRepresentation() {
      return Util.RUNNING_PERSON;
   }
   
   /**************************************************************
  *  Method to set leave time to be 0.5 as much as a 
  *  regular person
  * @param time average leave time
  **************************************************************/
    public void setLeaveTime(double time) {
        super.setLeaveTime(time*0.5);
    }
}
