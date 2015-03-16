package reverie.test;

import reverie.model.Habit;
import reverie.model.Job;
import reverie.model.SubTask;
import reverie.model.Task;
import reverie.scheduler.AppState;
import reverie.scheduler.Scheduler;
import reverie.scheduler.Util;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Dell on 11/9/2014.
 */
public abstract class TestData {
    /*
    public static void testRun() throws ParseException {
        AppState.addToHabitQueue(new Habit(UUID.randomUUID(), "sleep", "sleep all day", Habit.FREQ_ONCE, 1, new SimpleDateFormat("h:mm a").parse("3:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 3:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 4:00 AM")));
        AppState.addToHabitQueue(new Habit(UUID.randomUUID(), "eat", "eat all day", Habit.FREQ_ONCE, 1, new SimpleDateFormat("h:mm a").parse("5:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 5:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 6:00 AM")));
        Task t = new Task(UUID.randomUUID(), "do SP", "do it a**", 1, 2, new SimpleDateFormat("yyyy/MM/dd h:mm a").parse("2015/3/16 1:00 AM"));
        t.setWeight(500);
        //SubTask st = new SubTask(t.getJobId(), new SimpleDateFormat("yyyy/MM/dd h:mm a").parse("2015/3/15 4:00 AM"), new SimpleDateFormat("yyyy/MM/dd h:mm a").parse("2015/3/15 6:00 AM"));
        SubTask st = new SubTask(t.getJobId());
        ArrayList<SubTask> stList = new ArrayList<SubTask>();
        stList.add(st);
        t.setSubTasks(stList);
        AppState.addToPrioQueue(t);
        AppState.addToSchedule(AppState.getHabitQueue().get(0));
        AppState.addToSchedule(AppState.getHabitQueue().get(1));
        System.out.println(Scheduler.fit(st,AppState.getSchedule(), AppState.getPriorityQueue(),new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 4:00 AM")));
    }*/

    public static void testRun() throws ParseException{
        Habit h1 = new Habit(UUID.randomUUID(), "Sleep","Sleep all day", Habit.FREQ_DAILY, 1, new SimpleDateFormat("h:mm a").parse("3:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 3:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 4:00 AM"));
        Habit h2 = new Habit(UUID.randomUUID(), "eat", "eat all day", Habit.FREQ_ONCE, 1, new SimpleDateFormat("h:mm a").parse("5:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 5:00 AM"), new SimpleDateFormat("y/MM/d h:mm a").parse("2015/3/15 6:00 AM"));
    }
}
