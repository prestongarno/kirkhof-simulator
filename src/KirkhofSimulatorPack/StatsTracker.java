package KirkhofSimulatorPack;

/**
 * Created by preston on 4/12/17.
 */
public class StatsTracker {

    private static StatsTracker instance;

    private StatsTracker(){}

    public static StatsTracker getInstance() {
        return instance != null ? instance : new StatsTracker();
    }
}
