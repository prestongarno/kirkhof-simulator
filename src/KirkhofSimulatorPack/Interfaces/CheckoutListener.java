package KirkhofSimulatorPack.Interfaces;

import KirkhofSimulatorPack.GUI.PersonType;

/****************************************
 * Created by preston on 4/12/17.
 *
 * Interface (something like this) should be implemented by GUI
 * components representing checkouts
 ****************************************/
public interface CheckoutListener {
	/*****************************************
     * @param person the person type to send to the queue
     ****************************************/
    void setPerson(PersonType person);

	/*****************************************
     * Clear the checkout (Person leaves)
     ****************************************/
    void clearCheckout();

	/*****************************************
     * @param enabled if the checkout should be enabled or not
     ****************************************/
    void setEnabled(boolean enabled);
}
