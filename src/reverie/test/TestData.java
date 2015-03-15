package reverie.test;

import reverie.model.Habit;
import reverie.model.Job;
import reverie.model.SubTask;
import reverie.model.Task;
import reverie.scheduler.AppState;
import reverie.scheduler.Scheduler;
import reverie.scheduler.Util;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Dell on 11/9/2014.
 */
public abstract class TestData {
    /*
    public static void testRun() throws ParseException {
        Date deadL=null;
        Date setStart=null;
        Date setEnd=null;
        //test initialization
        try {
            deadL = new SimpleDateFormat("y/MM/d h:mm a").parse("2015/2/2 5:00 PM");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String fileDir = "src/resources/testinputs";
        Task x = new Task(UUID.randomUUID(), "CMSC150", "optimize", 1, 3, deadL);
        Scheduler.addToPrioQueue(x, AppState.getPriorityQueue());
        try {
            setStart = new SimpleDateFormat("y/MM/d h:mm a").parse("2015/2/2 1:00 PM");
            setEnd = Util.getDeadline(setStart, 3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        x.setStartTimestamp(setStart);
        x.setEndTimestamp(setEnd);
        System.out.println("WT: "+x.getWeight());
        AppState.getSchedule().add(x);
        //test initialization end
        //test initialization for habit
        Habit h = new Habit(UUID.randomUUID(), "eat", "food", "daily", 3, "12:00");
        try {
            setStart = new SimpleDateFormat("y/MM/d h:mm a").parse("2015/2/2 4:00 AM");
            setEnd = new SimpleDateFormat("y/MM/d h:mm a").parse("2015/2/1 6:00 AM");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        h.setStartTimestamp(setStart);
        h.setEndTimestamp(setEnd);
        AppState.getHabitQueue().add(h);
        //test initialization for habit end
        try {
            String jobType = null;
            String jobTitle = null;
            String jobNotes = null;
            int numOps=0;
            String date=null;
            int numHours=0;
            Date date1=null;
            Scanner readLine = new Scanner(new File(fileDir));
            while(readLine.hasNextLine()){
                StringTokenizer tok = new StringTokenizer(readLine.nextLine(), " ");
                while(tok.hasMoreTokens()){
                    jobType = tok.nextToken();
                    jobTitle = tok.nextToken();
                    jobNotes = tok.nextToken();
                    numOps = Integer.parseInt(tok.nextToken());
                    date = tok.nextToken() + ' ' + tok.nextToken() + ' ' + tok.nextToken();
                    numHours = Integer.parseInt(tok.nextToken());
                    try{
                        date1 = new SimpleDateFormat("y/MM/d h:mm a").parse(date);
                    } catch(ParseException e){
                        e.printStackTrace();
                    }
                }
                Scheduler.addToPrioQueue(new Task(UUID.randomUUID(),jobTitle, jobNotes, numOps, numHours, date1), AppState.getPriorityQueue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            for(Task t : AppState.getPriorityQueue()){
                System.out.println(t.getJobName() + " " + t.getWeight());
            }
            Scheduler.reDraw(AppState.getSchedule(), AppState.getPriorityQueue(), AppState.getHabitQueue(), new Date());
            for(Job j : AppState.getSchedule()){
                if(j instanceof Task){
                    System.out.println(((Task) j).getJobName() + j.getStartTimestamp() + j.getEndTimestamp());
                }
                else{
                    System.out.println(((Habit) j).getJobName() + j.getStartTimestamp() + j.getEndTimestamp());
                }
            }
            //Util.saveSchedFile(new File("C:\\Users\\Dell\\Documents\\UPLB Schoolwork\\4 Fourth Year\\CMSC 190-1\\SP\\ICS-template\\schedule.rsch"));
        }
    }*/

    public static void testRun() throws ParseException {
        AppState.addToHabitQueue(new Habit(UUID.randomUUID(), "sleep", "sleep all day", Habit.FREQ_ONCE, 1, new SimpleDateFormat("h:mm a").parse("3:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 3:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 4:00 AM")));
        AppState.addToHabitQueue(new Habit(UUID.randomUUID(), "eat", "eat all day", Habit.FREQ_ONCE, 1, new SimpleDateFormat("h:mm a").parse("5:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 5:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 6:00 AM")));
        Task t = new Task(UUID.randomUUID(), "do SP", "do it a**", 1, 2, new SimpleDateFormat("yyyy/MM/dd h:mm a").parse("2015/3/16 1:00 AM"));
        t.setWeight(500);
        //SubTask st = new SubTask(t.getJobId(), new SimpleDateFormat("yyyy/MM/dd h:mm a").parse("2015/3/15 4:00 AM"), new SimpleDateFormat("yyyy/MM/dd h:mm a").parse("2015/3/15 6:00 AM"));
        SubTask st = new SubTask(t.getJobId());
        ArrayList<SubTask> stList = new ArrayList<SubTask>();
        stList.add(st);
        t.setSubTasks(stList);
        AppState.addToPrioQueue(t);
        AppState.addToSchedule(AppState.getHabitQueue().get(0));
        AppState.addToSchedule(AppState.getHabitQueue().get(1));
        System.out.println(Scheduler.fit(st,AppState.getSchedule(), AppState.getPriorityQueue(),new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 4:00 AM")));
    }

    public static void test(){

    }
}
