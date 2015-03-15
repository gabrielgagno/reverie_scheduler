package reverie.scheduler;

import reverie.model.Habit;
import reverie.model.Job;
import reverie.model.SubTask;
import reverie.model.Task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
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
            //TODO x.setWeight(weight(AppState.getConstX(), AppState.getConstY(), Util.differenceInHours(new Date(), x.getDeadlineTimestamp()),x.getOperationDuration()));
        }
        //auto-sort
        Collections.sort(list);
    }

    public static void addToHabit(Habit habit, ArrayList<Habit> list){
        list.add(habit);
    }

    public static void reDraw(ArrayList<Job> schedule, ArrayList<Task> priorityQueue, ArrayList<Habit> habitQueue, Date currentDate){
        Collections.sort(habitQueue);
        Date datePointer = Util.findNearestHour(currentDate);
        int i=0, j=0; //let i = for tasks, j = for subtasks
        int index = 0;
        boolean any = false;
        schedule.clear();
        for(Habit h : habitQueue){
            Scheduler.fitToSchedule(h, schedule, datePointer);
        }

        //
        ArrayList<SubTask> subTaskList = new ArrayList<SubTask>();
        for(Task t : priorityQueue){
            subTaskList.addAll(t.getSubTasks());
        }
        int scheduled = 0;
        while(scheduled!=subTaskList.size()){
            /*
            if fit  //before deadline and fits exactly
                fit schedule
                index = 0
            else
                if end of list
                    skip to the end of next habit
                    index = 0
                else
                    index++
             */
            if(fit(subTaskList.get(i), schedule, priorityQueue, datePointer)){
                datePointer = fitToSchedule(subTaskList.get(i), schedule, datePointer, priorityQueue);
                i=0;
            }
            else{
                if(i==subTaskList.size()){
                    datePointer = Util.findNextHabit(habitQueue, datePointer);
                    i=0;
                }
                else{
                    i++;
                }
            }
        }
    }

    //needs modification: fit for subtasks
    public static void fitToSchedule(Task task, ArrayList<Job> schedule, Date datePointer){
        //set start time (datePointer)
        task.setStartTimestamp(datePointer);
        //System.out.println("IN FIT: " + datePointer);
        //set end time
        //TODO task.setEndTimestamp(Util.getDeadline(datePointer, task.getOperationDuration()));
        //System.out.println("FITYEND" + Util.getDeadline(datePointer, task.getOperationDuration()));
        schedule.add(task);
    }

    public static void fitToSchedule(Habit habit, ArrayList<Job> schedule, Date datePointer){
        habit.setStartTimestamp(datePointer);
        //System.out.println("IN FIT: " + datePointer);
        //set end time
        habit.setEndTimestamp(Util.getEnd(datePointer, habit.getDuration()));
        //System.out.println("FITYEND" + Util.getDeadline(datePointer, task.getOperationDuration()));
        schedule.add(habit);
    }


    public static Date fitToSchedule(SubTask subTask, ArrayList<Job> schedule, Date datePointer, ArrayList<Task> priorityQueue){
        subTask.setSubTaskStart(datePointer);
        subTask.setSubTaskEnd(Util.getEnd(datePointer, priorityQueue.get(Util.findTask(subTask.getMotherTaskId(), priorityQueue)).getMinOperationDuration()));
        return Util.getEnd(datePointer, priorityQueue.get(Util.findTask(subTask.getMotherTaskId(), priorityQueue)).getMinOperationDuration());
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

    public static boolean fit(SubTask subTask, ArrayList<Job> schedule, ArrayList<Task> priorityQueue, Date tStart){
        Date tDead = priorityQueue.get(Util.findTask(subTask.getMotherTaskId(),priorityQueue)).getDeadlineTimestamp();
        Date tEnd = Util.getEnd(tStart, priorityQueue.get(Util.findTask(subTask.getMotherTaskId(),priorityQueue)).getMinOperationDuration());
        int schedSize = schedule.size();
        System.out.println(schedSize);
        for(int i=0;i<schedSize;i++){
            if(schedule.get(i) instanceof Habit){
                //check if habit's startTime starts after extractTime(tStart)
                if(Util.extractTime(schedule.get(i).getStartTimestamp()).after(Util.extractTime(tStart))){
                    System.out.println("HELLO!");
                    if(Util.overlap((Habit) schedule.get(i), tStart, tEnd)){
                        if(((Habit) schedule.get(i)).getFrequency().equals(Habit.FREQ_ONCE) || ((Habit) schedule.get(i)).getFrequency().equals(Habit.FREQ_DAILY)){
                            return false;
                        }
                        else{
                            if(Util.habitSameDay((Habit) schedule.get(i), tStart)){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static long weight(int wx, int wy, long x, long y){
        return (2*wx*x) + wy*y;
    }
}
