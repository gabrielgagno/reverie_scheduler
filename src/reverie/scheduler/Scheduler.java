package reverie.scheduler;

import reverie.model.Habit;
import reverie.model.Job;
import reverie.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Dell on 11/9/2014.
 */
public abstract class Scheduler {
    public static void addToPrioQueue(Task task, ArrayList<Task> list){
        //add task to list
        list.add(task);
        for(Task x:list){
            //assign new weights to task
            x.setWeight(weight(AppState.getConstX(), AppState.getConstY(), Util.differenceInHours(new Date(), x.getDeadlineTimestamp()),x.getOperationDuration()));
        }
        //auto-sort
        Collections.sort(list);
    }

    public static void addToHabit(Habit habit, ArrayList<Habit> list){
        list.add(habit);
        Scheduler.fitToSchedule(habit, AppState.getSchedule());
    }

    public static void reDraw(){
        //TODO algorithm for redrawing
    }

    public static void fitToSchedule(Habit habit, ArrayList<Job> schedule){
        schedule.add(habit);
    }

    public static void fitToSchedule(Task task, ArrayList<Job> schedule){
        schedule.add(task);
        //TODO check if it fits
    }

    public static long weight(int wx, int wy, long x, long y){
        return (2*wx*x) + wy*y;
    }
}
