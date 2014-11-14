package reverie.scheduler;

import reverie.model.Habit;
import reverie.model.Task;

import java.util.Date;

/**
 * Created by Dell on 11/9/2014.
 */
public abstract class Scheduler {
    public static void addToSchedule(Task task){
        //TODO add to priority queue
        //TODO compute weight
        //TODO rearrange
    }

    public static void addToHabit(Habit habit){
        //TODO add to habit queue
        //TODO add to schedule
    }

    public static void reDraw(){

    }
}
