package reverie.scheduler;

import reverie.model.Job;
import reverie.model.SubTask;
import reverie.model.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dell on 11/12/2014.
 */
public abstract class Util {
    public static final int HOUR_LONG = 3600*1000;
    public static Date convertToDate(String date, String time){
        String newString = date + ' ' + time;
        Date buildDate = null;
        try {
            buildDate = new SimpleDateFormat("y.MM.d h:mm a").parse(newString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return buildDate;
    }

    public static long unixTimestamp(Date date){
        return date.getTime();
    }

    public static long differenceInHours(Date earlier, Date later){
        //System.out.println("DEF EARLY: " + earlier);
        //System.out.println("DEF LATE: " + later);
        long diff = unixTimestamp(later) - unixTimestamp(earlier);
        //System.out.println("DFFERENCE IN HOURS: " + diff);
        return TimeUnit.MILLISECONDS.toHours(diff);
    }

    public static Date getDeadline(Date date, int hours){
        long newDateLong = unixTimestamp(date);
        newDateLong+= hours*HOUR_LONG;
        return new Date(newDateLong);
    }

    public static String translateUUID(UUID uuid){
        return uuid.toString();
    }

    public static void loadSchedFile(File file){
        //TODO for task 30
    }

    public static void saveSchedFile(File file){
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("%rsch 1.0%\n");
            writer.write("%user"+AppState.getUser()+"%\n");
            writer.write("%"+new Date().toString()+"%\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Date findNearestHour(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static int findTask(UUID objectId, ArrayList<Task> priorityQueue){
        int prioritySize = priorityQueue.size();
        for(int i=0;i<prioritySize;i++){
            if(priorityQueue.get(i).getJobId() == objectId){
                return i;
            }
        }
        return -1;
    }
}