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
        boolean any = false;
        schedule.clear();
        while(priorityQueue.size()!=0){
            Scheduler.fitToSchedule(priorityQueue.get(i), schedule, datePointer);
            datePointer = priorityQueue.get(i).getDeadlineTimestamp();
            //if not fit, then remove from schedule
            if(fit(priorityQueue.get(i), schedule) && Util.differenceInHours(currentDate, priorityQueue.get(i).getDeadlineTimestamp())<0){
                schedule.remove(schedule.size()-1);
            }
            else if(!fit(priorityQueue.get(i), schedule)){
                any = false;
                i++;
                while(!any && i!=priorityQueue.size()){
                    Scheduler.fitToSchedule(priorityQueue.get(i), schedule, datePointer);
                    if(Util.differenceInHours(currentDate, priorityQueue.get(i).getDeadlineTimestamp())<0){
                        schedule.remove(schedule.size()-1);
                    }
                    else{
                        any=true;
                    }
                }
                if(i==priorityQueue.size()){
                    //TODO skip to the end of next habit
                }
            }
            else if(fit(priorityQueue.get(i), schedule)){
                priorityQueue.remove(i);
                i=0;
            }
        }
    }

    public static void fitToSchedule(Task task, ArrayList<Job> schedule, Date datePointer){
        //set start time (datePointer)
        task.setStartTimestamp(datePointer);
        //set end time
        task.setEndTimestamp(Util.getDeadline(datePointer, task.getOperationDuration()));
        schedule.add(task);
    }

    public static boolean fit(Task task, ArrayList<Job> schedule){
        //check for the least distance
        long time = Util.unixTimestamp(task.getEndTimestamp());
        for(int i=0;i<schedule.size();i++){
            if(Util.differenceInHours(task.getEndTimestamp(), schedule.get(i).getEndTimestamp())<0){
                return false;
            }
        }
        return true;
    }

    public static long weight(int wx, int wy, long x, long y){
        return (2*wx*x) + wy*y;
    }
}
