package reverie.test;

import reverie.model.Job;
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
    public static void testRun(){
        Date deadL=null;
        Date setStart=null;
        Date setEnd=null;
        //test initialization
        try {
            deadL = new SimpleDateFormat("y/MM/d h:mm a").parse("2014/11/28 4:00 PM");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String fileDir = "src/resources/testinputs";
        Task x = new Task(UUID.randomUUID(), "CMSC150", "optimize", 1, 3, deadL);
        Scheduler.addToPrioQueue(x, AppState.getPriorityQueue());
        try {
            setStart = new SimpleDateFormat("y/MM/d h:mm a").parse("2014/11/24 5:10 AM");
            setEnd = Util.getDeadline(setStart, 3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        x.setStartTimestamp(setStart);
        x.setEndTimestamp(setEnd);
        System.out.println("WT: "+x.getWeight());
        AppState.getSchedule().add(x);
        //test initialization end
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
            }
            Util.saveSchedFile(new File("C:\\Users\\Dell\\Documents\\UPLB Schoolwork\\4 Fourth Year\\CMSC 190-1\\SP\\ICS-template\\schedule.rsch"));
        }
    }
}
