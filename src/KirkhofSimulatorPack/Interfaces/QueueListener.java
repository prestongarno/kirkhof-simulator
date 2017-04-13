package KirkhofSimulatorPack.Interfaces;

import KirkhofSimulatorPack.GUI.PersonType;

import java.util.HashMap;
import java.util.List;

/****************************************
 * Created by preston on 4/12/17.
 *
 * This interface should be implemented by the GUI objects that represent
 * the Main Queue and also the Eateries, which also have the same behaviour as each other
 ****************************************/
public interface QueueListener {
	/*****************************************
     * @param line the Queue of people
     ****************************************/
    void onUpdateQueue(List<PersonType> line);

	/*****************************************
     * @param index the index of the person that is fed up and leaves the line
     ****************************************/
    void onPersonLeaveQueue(int index);
}
