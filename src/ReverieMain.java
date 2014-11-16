/**
 * Created by Dell on 11/5/2014.
 */

import reverie.scheduler.*;
import reverie.view.ReverieMainFrame;

import java.util.Date;

public class ReverieMain {
    public static void main(String args[]){
        AppState.initalizeState();
        Date date1 = Util.convertToDate("2014.12.03", "05:00 PM");
        Date date2 = Util.convertToDate("2014.11.16", "05:00 PM");
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(Util.differenceInDays(date2, date1));
        //ReverieMainFrame mainFrame = new ReverieMainFrame();
    }
}
