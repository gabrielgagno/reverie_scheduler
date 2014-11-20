/**
 * Created by Dell on 11/5/2014.
 */

import reverie.model.Task;
import reverie.scheduler.*;
import reverie.view.ReverieMainFrame;

import java.util.ArrayList;
import java.util.Date;

public class ReverieMain {
    public static void main(String args[]){
        AppState.initalizeState();
        if(args.length>0){
            if(args[0].equals("-c")){
                //TODO console mode
            }
            else if(args[0].equals("-devtest")){
                //TODO test mode
            }
            else if(args[0].equals("-anova")){
                //TODO anova mode
            }
            else if(args[0].equals("-h")){
                String helpMsg = "ReverieMain v1.0 help\nUsage: java -jar ReverieMain [-c|-devtest|-anova|-h]\n" +
                        "Parameters:\n" +
                        "-c\tconsole mode\n" +
                        "-devtest\tdeveloper test mode\n" +
                        "-anova\tanova calculation mode\n" +
                        "-h\t help (this window)";
                System.out.println(helpMsg);
            }
            else{
                System.out.println("Invalid usage. Type in -h for help");
            }
        }
        else{
            ReverieMainFrame mainFrame = new ReverieMainFrame();
        }
    }
}
