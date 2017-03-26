package KirkhofSimulatorPack;

/**
 * Created by Alex on 3/26/2017.
 */
public class LimitedTimePerson extends Person {

    @Override
    public void setEateryTime(double time) {
        super.setEateryTime(time*.5);
    }

    @Override
    public void setCashierTime(double time) {
        super.setCashierTime(time);
    }
}
