package reverie.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dell on 11/12/2014.
 */
public abstract class Util {
    public static Date convertToDate(String date, String time){
        String newString = date + ' ' + time;
        System.out.println(newString);
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

    public static long differenceInDays(Date earlier, Date later){
        long diff = unixTimestamp(later) - unixTimestamp(earlier);
        return TimeUnit.MILLISECONDS.toHours(diff);
    }
}