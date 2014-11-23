package reverie.scheduler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
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
        newDateLong+= 2*HOUR_LONG;
        return new Date(newDateLong);
    }

    public static String translateUUID(UUID uuid){
        return uuid.toString();
    }

    public static void loadSchedFile(File file){

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
}