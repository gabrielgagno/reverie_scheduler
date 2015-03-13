package reverie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Dell on 11/7/2014.
 */
public class Habit extends Job implements Comparable<Habit>{
    //range start is the start time of the range
    //habits have an empty end timestamp, since they can run quite indefinitely. but for test purposes, we will put a deadline.
    private String rangeStart;
    private int duration;
    private String frequency;

    //Constants
    private static String FREQ_DAILY;
    private static String FREQ_WEEKLY;
    private static String FREQ_MONTHLY;
    private static String FREQ_ANNUALLY;

    public Habit(UUID jobId, String jobName, String jobNotes, String frequency, int duration, String rangeStart){
        super(jobId, jobName, jobNotes);
        this.frequency = frequency;
        this.duration = duration;
        this.rangeStart = rangeStart;
    }

    @Override
    public String getJobName(){
        return super.getJobName();
    }

    @Override
    public void setJobName(String jobName){
        super.setJobName(jobName);
    }

    public String getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(String rangeStart) {
        this.rangeStart = rangeStart;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Habit o){
        return o.getStartTimestamp().compareTo(startTimestamp);
    }
}
