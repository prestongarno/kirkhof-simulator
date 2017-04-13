package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.people.LimitedTimePerson;
import KirkhofSimulatorPack.people.Person;
import KirkhofSimulatorPack.people.RegularPerson;
import KirkhofSimulatorPack.people.SpecialNeedsPerson;

import javax.swing.*;

/**
 * Created by Chad on 4/12/2017.
 */
public enum PersonType {
    REGULAR,
    DISABLED,
    HURRIED;

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


    @Override
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
