package edu.gvsu.cis162.project4.people;


/**************************************************************
 *  Special Needs people specifications
 * @author
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
  *  Method to set leave time to be 2 times as much as a 
  *  regular person
  * @param time average leave time
  **************************************************************/ 
    public void setLeaveTime(double time){
    	super.setLeaveTime(time*3);
    }
}
