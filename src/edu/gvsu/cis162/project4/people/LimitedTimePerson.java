package edu.gvsu.cis162.project4.people;


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

   /**************************************************************
  *  Method to set leave time to be 0.5 as much as a 
  *  regular person
  * @param time average leave time
  **************************************************************/
    public void setLeaveTime(double time) {
        super.setLeaveTime(time*0.5);
    }
}
