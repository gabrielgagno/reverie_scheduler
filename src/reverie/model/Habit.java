package reverie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Dell on 11/7/2014.
 */
public class Habit extends Job {
    private int frequency;
    private Date rangeStart;
    private Date rangeEnd;

    public Habit(UUID jobId, String jobName, String jobNotes, Date startTimestamp, Date endTimestamp, int frequency, Date rangeStart, Date rangeEnd){
        super(jobId, jobName, jobNotes, startTimestamp, endTimestamp);
        this.frequency = frequency;
    }

}
