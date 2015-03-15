package reverie.scheduler;

import reverie.model.Habit;
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
    public static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd h:mm a";
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

    //run only extracted time here
    public static long extractedTimeDifference(long earlier, long later){
        return later - earlier;
    }

    public static Date getEnd(Date date, float hours){
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

    public static long extractTimeInMillis(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);
        calendar.set(1970, Calendar.JANUARY, 1);

        //calendar.setTimeZone(TimeZone.getTimeZone("WST"));
        //System.out.println(calendar.getTime());
        return calendar.getTimeInMillis() + 28800000;
    }

    public static Date extractTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);
        calendar.set(1970,Calendar.JANUARY,1);

        //calendar.setTimeZone(TimeZone.getTimeZone("WST"));
        long calends = calendar.getTimeInMillis() + 28800000;
        return new Date(calends);
    }

    public static boolean overlap(Habit habit, Date tStart, Date tEnd){
        return Util.extractTime(habit.getStartTimestamp()).after(Util.extractTime(tStart)) && Util.extractTime(habit.getEndTimestamp()).before(Util.extractTime(tEnd));
    }

    public static boolean habitSameDay(Habit habit, Date tStart){
        String freq = habit.getFrequency();
        Date dateStart = habit.getRangeStart();
        Date dateEnd = habit.getRangeEnd();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(tStart);
        while(dateStart.compareTo(dateEnd)<0){
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateStart);
            if(cal.get(Calendar.DAY_OF_WEEK)==cal2.get(Calendar.DAY_OF_WEEK)){
                return true;
            }
            if(freq.equals(Habit.FREQ_WEEKLY)){
                cal.roll(Calendar.DAY_OF_YEAR, 7);
            }
            else if(freq.equals(Habit.FREQ_MONTHLY)){
                cal.roll(Calendar.MONTH, true);
            }
            else if(freq.equals(Habit.FREQ_ANNUALLY)){
                cal.roll(Calendar.YEAR, true);
            }
            dateStart = cal.getTime();
        }
        return false;
    }
}