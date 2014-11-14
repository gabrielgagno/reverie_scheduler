/**
 * Created by Dell on 11/5/2014.
 */

import reverie.scheduler.*;
import reverie.view.ReverieMainFrame;

import java.util.Date;

public class ReverieMain {
    public static void main(String args[]){
        AppState.initalizeState();
        String date = "2014.12.03";
        String time = "5:00 AM";
        Date x = Util.convertToDate(date, time);
        System.out.println(x);
        //ReverieMainFrame mainFrame = new ReverieMainFrame();
    }
}
