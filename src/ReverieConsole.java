import reverie.model.Habit;
import reverie.model.Job;
import reverie.model.Task;
import reverie.scheduler.AppState;

import java.util.Scanner;

/**
 * Created by Dell on 11/21/2014.
 */
public class ReverieConsole {

    public static void consoleMain(){
        int choice = -1;
        while(choice!='0'){
            choice = consoleMenu();
            switch(choice){
                case 1: consoleTaskInput();
                    break;
                case 2: consoleHabitInput();
                    break;
                case 3: consoleOutputSched();
                    break;
                case 4: break;
                default: System.out.println("Bad Command");
                    break;
            }
        }
    }
    public static int consoleMenu(){
        Scanner readInt = new Scanner(System.in);
        System.out.print("Welcome to Reverie 1.0 Console (Basic)!\n" +
                "1 - Add new Task\n" +
                "2 - Add new Habit\n" +
                "3 - Output\n" +
                ">");
        return readInt.nextInt();
    }

    public static void consoleTaskInput(){

    }

    public static void consoleHabitInput(){

    }

    public static void consoleOutputSched(){
        for(Job j : AppState.getSchedule()){

            if(j instanceof Task){

            }
            else if(j instanceof Habit){

            }
        }
    }
}
