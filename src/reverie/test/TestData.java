package reverie.test;

import reverie.model.Task;
import reverie.scheduler.AppState;

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
            String jobType;
            String jobTitle;
            String jobNotes;
            int numOps;
            String date;
            int numHours;
            Scanner readLine = new Scanner(new File(fileDir));
            while(readLine.hasNext()){
                StringTokenizer tok = new StringTokenizer(readLine.nextLine(), " ");
                while(tok.hasMoreTokens()){
                    jobType = tok.nextToken();
                    jobTitle = tok.nextToken();
                    jobNotes = tok.nextToken();
                    numOps = Integer.parseInt(tok.nextToken());
                    date = tok.nextToken() + ' ' + tok.nextToken() + ' ' + tok.nextToken();
                    numHours = Integer.parseInt(tok.nextToken());
                    Date date1=null;
                    try{
                        date1 = new SimpleDateFormat("y/MM/d h:mm a").parse(date);
                    } catch(ParseException e){
                        e.printStackTrace();
                    }
                    AppState.getPriorityQueue().add(new Task(UUID.randomUUID(),jobTitle, jobNotes, numOps, numHours, date1));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        for(Task t : AppState.getPriorityQueue()){
            System.out.println(t.getJobId().toString() + "\n" + t.getJobName() + "\n" + t.getJobNotes() + "\n");
        }
    }
}
