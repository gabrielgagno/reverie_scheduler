package reverie.scheduler;

import reverie.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Dell on 11/9/2014.
 */
public abstract class AppState {
    private static ArrayList<Job> schedule;
    private static ArrayList<Task> priorityQueue;
    private static ArrayList<Habit> habitQueue;
    private static boolean firstRun;
    private static String user;
    private static String preferredPrio;
    private static String preferredView;
    private static int constX;
    private static int constY;

    //state initialization methods
    public static void initalizeState(){
        String propFile = "resources/config.properties";
        Properties prop = new Properties();
        InputStream io = AppState.class.getClassLoader().getResourceAsStream(propFile);
        try{
            prop.load(io);
            firstRun = Boolean.valueOf(prop.getProperty("firstrun"));
            user = prop.getProperty("user");
            preferredPrio = prop.getProperty("preferredprio");
            preferredView = prop.getProperty("preferredview");
            if(preferredPrio.equals("deadline")){
                constX = 2;
                constY = 1;
            }
            else{
                constX = 1;
                constY = 2;
            }
            System.out.println("Settings File loaded");
        }
        catch (IOException ex){
            System.out.println("No properties file! contact developer gjpgagno@uplb.edu.ph");
        }
        schedule = new ArrayList<Job>();
        priorityQueue = new ArrayList<Task>();
        habitQueue = new ArrayList<Habit>();
        //TODO try loading save files if they exist
        //TODO run background service of checking deadlines
    }

    public static void saveState(String user, String preferredPrio, String preferredView){
        String propFile = "src/resources/config.properties";
        Properties prop = new Properties();
        try{
            OutputStream out = new FileOutputStream(propFile);
            prop.setProperty("firstrun", "false");
            prop.setProperty("user", user);
            prop.setProperty("preferredprio", preferredPrio);
            prop.setProperty("preferredview", preferredView);

            prop.store(out, null);
            out.close();

            AppState.user = user;
            AppState.preferredPrio = preferredPrio;
            AppState.preferredView = preferredView;
            AppState.firstRun = false;
            //TODO save schedule (.rsch file)
        }
        catch(IOException ex){
            System.out.println("Failed to Write! contact developer gjpgagno@uplb.edu.ph");
        }
    }

    //get methods
    public static ArrayList<Job> getSchedule(){
        return schedule;
    }

    public static ArrayList<Task> getPriorityQueue(){
        return priorityQueue;
    }

    public static ArrayList<Habit> getHabitQueue(){
        return habitQueue;
    }

    public static int getConstX(){
        return constX;
    }

    public static int getConstY(){
        return constY;
    }

    public static String getUser(){
        return user;
    }

    //set methods
    public static void addToPrioQueue(Task task){
        AppState.priorityQueue.add(task);
        //redraw
    }

    public static void addToHabitQueue(Habit habit){
        AppState.habitQueue.add(habit);
    }
}
