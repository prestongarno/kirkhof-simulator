package edu.gvsu.cis162.project4.GUI;

import edu.gvsu.cis162.project4.people.LimitedTimePerson;
import edu.gvsu.cis162.project4.people.Person;
import edu.gvsu.cis162.project4.people.RegularPerson;
import edu.gvsu.cis162.project4.people.SpecialNeedsPerson;

import javax.swing.*;
/**********************************************************************
 * Class to find what type of person a given person is. 
 * @author Preston, Alex, Jessica, Chad
 * @version 4/18/17
 *********************************************************************/
public enum PersonType {
    REGULAR,
    DISABLED,
    HURRIED;
	/*****************************************************************
	 * Getter for type of person
	 * @param person person at given time
	 * @return type of person
	 * @throws IllegalStateException if person is not a type 
	 ****************************************************************/
    public static PersonType getType(Person person) {
        if(person instanceof RegularPerson) {
            return REGULAR;
        } else if(person instanceof LimitedTimePerson) {
            return HURRIED;
        } else if(person instanceof SpecialNeedsPerson) {
            return DISABLED;
        }
        throw new IllegalStateException("this shouldn't happen");
    }


    /******************************************************************
     * Method to convert type into string
     * @return string of person type
     * @throws IllegalStateException if person is not a type 
     *****************************************************************/
    public String toString() {
        switch (this) {
            case REGULAR:
                return "Average person";
            case HURRIED:
                return "Person in a hurry";
            case DISABLED:
                return "Special needs person";
        }
        throw new IllegalStateException("this shouldn't happen");
    }

}
