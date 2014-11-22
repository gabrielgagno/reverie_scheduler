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
    }

    public static void reDraw(ArrayList<Job> schedule, ArrayList<Task> priorityQueue, ArrayList<Habit> habitQueue, Date currentDate){
        Date datePointer = currentDate;
        int i=0, j=0;
        schedule.clear();
        for(Habit h : habitQueue){
            schedule.add(h);
        }
        while(schedule.size()!=0){

        }
    }

    public static long weight(int wx, int wy, long x, long y){
        return (2*wx*x) + wy*y;
    }
}
