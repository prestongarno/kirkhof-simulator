package KirkhofSimulatorPack;

import KirkhofSimulatorPack.GUI.Util;

import javax.swing.*;


/**
 * Created by Alex on 3/26/2017.
 */
public class RegularPerson extends Person {

    /**************************************************************
     * Setter methods
     * @param time The persons eatery/cashier/leave time
     **************************************************************/
    public void setEateryTime(double time) { super.setEateryTime(time); }

    public void setCashierTime(double time) { super.setCashierTime(time); }
    
    @Override
    public Icon getIconRepresentation() {
        return Util.REGULAR_PERSON;
    }
    
    public void setLeaveTime(double time) { super.setLeaveTime(time); }

}
