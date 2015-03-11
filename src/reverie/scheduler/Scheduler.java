package reverie.scheduler;

import reverie.model.Habit;
import reverie.model.Job;
import reverie.model.SubTask;
import reverie.model.Task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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
        Date datePointer = Util.findNearestHour(currentDate);
        int i=0, j=0;
        boolean any = false;
        schedule.clear();
        for(Habit h : habitQueue){
            Scheduler.fitToSchedule(h, schedule, datePointer);
        }
        while(priorityQueue.size()!=0){
            for(SubTask subTask : priorityQueue.get(i).getSubTasks()){
                /*
                if fit and not beyond deadline
                    fit it
                else if not fit
                    while
                 */
            }
            i++;
        }
    }

    //needs modification: fit for subtasks
    public static void fitToSchedule(Task task, ArrayList<Job> schedule, Date datePointer){
        //set start time (datePointer)
        task.setStartTimestamp(datePointer);
        //System.out.println("IN FIT: " + datePointer);
        //set end time
        task.setEndTimestamp(Util.getDeadline(datePointer, task.getOperationDuration()));
        //System.out.println("FITYEND" + Util.getDeadline(datePointer, task.getOperationDuration()));
        schedule.add(task);
    }

    public static void fitToSchedule(Habit habit, ArrayList<Job> schedule, Date datePointer){
        habit.setStartTimestamp(datePointer);
        //System.out.println("IN FIT: " + datePointer);
        //set end time
        habit.setEndTimestamp(Util.getDeadline(datePointer, habit.getDuration()));
        //System.out.println("FITYEND" + Util.getDeadline(datePointer, task.getOperationDuration()));
        schedule.add(habit);
    }

    public static boolean fit(int index, Task task, ArrayList<Job> schedule){
        //fit is defined as:
        //minimum distance between task's end time and any of the scheduled tasks's start time
        //must check only after the end time of task
        Date tDead = task.getDeadlineTimestamp();
        Date tStart = task.getStartTimestamp();
        int size = schedule.size();
        for(int i=0;i<size;i++){
            if(schedule.get(i).getStartTimestamp().after(tStart)){
                if(Util.differenceInHours(tDead, schedule.get(i).getStartTimestamp())<0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void fitToSchedule(SubTask subTask, ArrayList<Job> schedule, Date datePointer){

    }

    public static long weight(int wx, int wy, long x, long y){
        return (2*wx*x) + wy*y;
    }
}
