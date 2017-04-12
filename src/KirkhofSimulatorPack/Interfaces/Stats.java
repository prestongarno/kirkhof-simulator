package KirkhofSimulatorPack.Interfaces;

import KirkhofSimulatorPack.GUI.PersonType;

import java.util.HashMap;

/**
 * Created by Chad on 4/12/2017.
 */
public interface Stats {
    void onNumCompleted(int completed);
    // getKey() for key, getValue() for value, hashmap.getValues()
    void typesOfPeopleCompleted(HashMap<PersonType, Integer> values);

    void onAverageTime(int value);
    void averageTimeCompletedPerType(HashMap<PersonType, Integer> values);
}
