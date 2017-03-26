package KirkhofSimulatorPack;

/**
 * Created by Alex on 3/26/2017.
 */
public class SpecialNeedsPerson extends Person {

    @Override
    public void setEateryTime(double time) {
        super.setEateryTime(time*4);
    }

    @Override
    public void setCashierTime(double time) {
        super.setCashierTime(time*2);
    }
}
