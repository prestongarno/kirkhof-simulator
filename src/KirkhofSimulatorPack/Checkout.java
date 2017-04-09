package KirkhofSimulatorPack;

import java.lang.*;

/**
 * Created by Chad on 4/8/2017.
 */
public class Checkout {
    //add constructor here, this class should be stupid
    //it can't see into the main queue
    //just holds a value 0 for empty and 1 for a person in checkout

    private int[] checkoutLine;
    private int numCheckouts = 2;

    public Checkout(){
        checkoutLine = new int[numCheckouts];
    }

    public void addPerson(int checkoutNumber){
        checkoutLine[checkoutNumber] = 1;
    }

    public void removePerson(int checkoutNum){
        checkoutLine[checkoutNum] = 0;
    }

    public void setNumCheckouts(int num){
        this.numCheckouts = num;
    }

    public int getNumCheckouts(){
        return this.numCheckouts;
    }

    public int[] getCheckout(){
        return checkoutLine;
    }

    public int getCheckout(int checkoutNum){
        return checkoutLine[checkoutNum];
    }
}
