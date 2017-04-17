package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.people.LimitedTimePerson;
import KirkhofSimulatorPack.people.Person;
import KirkhofSimulatorPack.people.RegularPerson;
import KirkhofSimulatorPack.people.SpecialNeedsPerson;

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

    /******************************************************************
     * Method to get type of icon 
     * @return icon representation of person
     * @throws IllegalStateException if person is not a type 
     *****************************************************************/
    public Icon getIcon() {
        switch (this) {
            case REGULAR:
                return Util.REGULAR_PERSON;
            case HURRIED:
                return Util.RUNNING_PERSON;
            case DISABLED:
                return Util.SPECIAL_NEEDS_PERSON;
        }
        throw new IllegalStateException("this shouldn't happen");
    }
}
