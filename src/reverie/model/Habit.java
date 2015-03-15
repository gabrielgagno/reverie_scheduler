package reverie.model;

import reverie.scheduler.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Dell on 11/7/2014.
 */
public class Habit extends Job implements Comparable<Habit>{
    //range start is the start time of the range
    //habits have an empty end timestamp, since they can run quite indefinitely. but for test purposes, we will put a deadline.
    private Date rangeStart;
    private Date rangeEnd;
    private int duration;
    private String frequency;

    //Constants
    public static final String FREQ_ONCE = "once";
    public static final String FREQ_DAILY = "daily";
    public static final String FREQ_WEEKLY = "weekly";
    public static final String FREQ_MONTHLY = "monthly";
    public static final String FREQ_ANNUALLY = "annually";

    public Habit(UUID jobId, String jobName, String jobNotes, String frequency, int duration, Date startTimestamp, Date rangeStart, Date rangeEnd){
        super(jobId, jobName, jobNotes);
        this.frequency = frequency;
        this.duration = duration;
        this.startTimestamp = startTimestamp;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.endTimestamp = Util.getEnd(startTimestamp, duration);
    }

    @Override
    public String getJobName(){
        return super.getJobName();
    }

    @Override
    public void setJobName(String jobName){
        super.setJobName(jobName);
    }

    public Date getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(Date rangeStart) {
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

    public Date getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(Date rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    @Override
    public int compareTo(Habit o){
        return o.getStartTimestamp().compareTo(startTimestamp);
    }
}
