package reverie.scheduler;

import reverie.model.*;
import java.util.ArrayList;

/**
 * Created by Dell on 11/9/2014.
 */
public abstract class AppState {
    private static ArrayList<Job> schedule;
    private static ArrayList<Task> priorityQueue;
    private static ArrayList<Habit> habitQueue;

    public static void initalizeState(){

    }

    //get methods
    public static ArrayList<Job> getSchedule(){
        return schedule;
    }

    public static ArrayList<Task> getPriorityQueue(){
        return priorityQueue;
    }

    public static ArrayList<Habit> getHabitQueue(){
        return habitQueue;
    }


}
