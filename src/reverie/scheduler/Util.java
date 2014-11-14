package reverie.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Dell on 11/12/2014.
 */
public abstract class Util {
    public static Date convertToDate(String date, String time){
        StringBuilder stringBuilder = new StringBuilder(date);
        stringBuilder.append(' ');
        stringBuilder.append(time);
        String newString = stringBuilder.toString();
        System.out.println(newString);
        Date buildDate = null;
        try {
            buildDate = new SimpleDateFormat("y.MM.d h:mm a").parse(newString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return buildDate;
    }

    public long unixTimestamp(Date date){
        return date.getTime();
    }
}
