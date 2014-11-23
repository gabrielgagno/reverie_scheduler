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
    public static void testReadInput(){
        String fileDir = "src/resources/testinputs";
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
            Scheduler.reDraw(AppState.getSchedule(), AppState.getPriorityQueue(), AppState.getHabitQueue(), new Date());
            for(Job j : AppState.getSchedule()){
                if(j instanceof Task){
                    System.out.println(((Task) j).getJobName());
                }
            }
            Util.saveSchedFile(new File("C:\\Users\\Dell\\Documents\\UPLB Schoolwork\\4 Fourth Year\\CMSC 190-1\\SP\\ICS-template\\schedule.rsch"));
        }
    }
}
