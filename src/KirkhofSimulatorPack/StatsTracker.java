package KirkhofSimulatorPack;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by preston on 4/12/17.
 */
public class StatsTracker {

    private static StatsTracker instance;

    public List<StatHolder> STATS;

    private StatsTracker(){
        STATS = new ArrayList<>();
        numCompleted = new StatHolder("Number of People Completed: ");
        STATS.add(numCompleted);
        numCompleteSpecial= new StatHolder("Number of Special People Completed: ");
        STATS.add(numCompleteSpecial);
        numCompleteReg= new StatHolder("Number of Regular People Completed: ");
        STATS.add(numCompleteReg);
        numCompleteLimited= new StatHolder("Number of Limited Time People Completed: ");
        STATS.add(numCompleteLimited);
        averageTimeCompleteSpecial= new StatHolder("Average Time Speical People for Completion: ");
        STATS.add(averageTimeCompleteSpecial);
        averageTimeCompleteReg= new StatHolder("Average Time Regular People Completion: ");
        STATS.add(averageTimeCompleteReg);
        averageTimeCompleteLimited= new StatHolder("Average Time Limited Time People Completion: ");
        STATS.add(averageTimeCompleteLimited);
        averageTimeCompleteEatery1= new StatHolder("Average Time to go Through Eatery 1: ");
        STATS.add(averageTimeCompleteEatery1);
        averageTimeCompleteEatery2= new StatHolder("Average Time to go Through Eatery 2: ");
        STATS.add(averageTimeCompleteEatery2);
        averageTimeCompleteEatery3= new StatHolder("Average Time to go Through Eatery 3: ");
        STATS.add(averageTimeCompleteEatery3);
        averageTimeCompleteEatery4= new StatHolder("Average Time to go Through Eatery 4: ");
        STATS.add(averageTimeCompleteEatery4);
        averageTimeCompleteEatery5= new StatHolder("Average Time to go Through Eatery 5: ");
        STATS.add(averageTimeCompleteEatery5);
        maxLineEatery1= new StatHolder("Maximum length of line at Eatery 1: ");
        STATS.add(maxLineEatery1);
        maxLineEatery2= new StatHolder("Maximum length of line at Eatery 2: ");
        STATS.add(maxLineEatery2);
        maxLineEatery3= new StatHolder("Maximum length of line at Eatery 3: ");
        STATS.add(maxLineEatery3);
        maxLineEatery4= new StatHolder("Maximum length of line at Eatery 4: ");
        STATS.add(maxLineEatery4);
        maxLineEatery5= new StatHolder("Maximum length of line at Eatery 5: ");
        STATS.add(maxLineEatery5);
        numCustomersLost= new StatHolder("Number of Customers Lost: ");
        STATS.add(numCustomersLost);
        totalPeople= new StatHolder("Total Number of Customers: ");
        STATS.add(totalPeople);
        currentTime= new StatHolder("Current Time: ");
        STATS.add(currentTime);
        currentQlength= new StatHolder("Current length of Q: ");
        STATS.add(currentQlength);
        maxQlength= new StatHolder("Max length of the Q: ");
        STATS.add(maxQlength);
    }

    public static StatsTracker getInstance() {
        return instance != null ? instance : new StatsTracker();
    }
    public class StatHolder {
        public int value;
         String description;
        public StatHolder(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "StatHolder{" +
                    "value=" + value +
                    ", description='" + description + '\'' +
                    '}';
        }
    }



    /**Total number of people who completed Simulation**/
    private StatHolder numCompleted;

    /**Number of Special needs people to complete sim*/
    private StatHolder  numCompleteSpecial;

    /**Number of Regular people to complete sim*/
    private StatHolder  numCompleteReg;

    /**Number of Limited time people to complete sim*/
    private StatHolder  numCompleteLimited;

    /**Average Time for special needs to complete sim*/
    private StatHolder  averageTimeCompleteSpecial;

    /**Average Time for regular people to complete sim*/
    private StatHolder  averageTimeCompleteReg;

    /**Average time for limited time people to complete sim*/
    private StatHolder  averageTimeCompleteLimited;

    /**Average time for people to go through Eatery 1*/
    private StatHolder  averageTimeCompleteEatery1;

    /**Average time for people to go through Eatery 2*/
    private StatHolder  averageTimeCompleteEatery2;

    /**Average time for people to go through Eatery 3*/
    private StatHolder  averageTimeCompleteEatery3;

    /**Average time for people to go through Eatery 4*/
    private StatHolder  averageTimeCompleteEatery4;

    /**Average time for people to go through Eatery 5*/
    private StatHolder  averageTimeCompleteEatery5;

    /**Value for the maximum amount of people in line Eatery1*/
    private StatHolder maxLineEatery1;

    /**Value for the maximum amount of people in line Eatery2*/
    private StatHolder maxLineEatery2;

    /**Value for the maximum amount of people in line Eatery3*/
    private StatHolder maxLineEatery3;

    /**Value for the maximum amount of people in line Eatery4*/
    private StatHolder maxLineEatery4;

    /**Value for the maximum amount of people in line Eatery5*/
    private StatHolder maxLineEatery5;

    /**Total amount of people who left sim without completion*/
    private StatHolder numCustomersLost;

    /**Total amount of people to entered simulation*/
    private StatHolder totalPeople;


    /**Creation of array of eateries*/
    private Eatery eateryArray[];

    /**Current time of the clock*/
    private StatHolder currentTime;

    /** Maximum length of the Q*/
    private StatHolder maxQlength;

    /**Current length of the Q*/
    private StatHolder currentQlength;
}
