package reverie.scheduler;

import reverie.model.Habit;
import reverie.model.Job;
import reverie.model.Task;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Dell on 11/9/2014.
 */
public abstract class Scheduler {
    public static void addToSchedule(Task task, ArrayList<Task> list){
        list.add(task);
        for(Task x:list){
            x.setWeight(weight(AppState.getConstX(), AppState.getConstY(), Util.differenceInDays(new Date(), x.getDeadlineTimestamp()),x.getOperationDuration()));
            System.out.println(x.getWeight());
        }
        //TODO rearrange
    }

    public static void addToHabit(Habit habit, ArrayList<Habit> list){
        list.add(habit);
        //TODO add to schedule
    }

    public static void reDraw(){
        //TODO algorithm for redrawing
    }

    public static long weight(int wx, int wy, long x, long y){
        return (2*wx*x) + wy*y;
    }
}
