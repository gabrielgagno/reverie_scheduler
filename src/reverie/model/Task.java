package reverie.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Dell on 11/7/2014.
 */

/**
 * Represents a job with a deadline, an operation duration, and
 */
public class Task extends Job {
    private int numOperations;
    //in this class, super's startTimestamp denotes a "global" start time - that is, the start time of the entire task.
    //if the task has more than one operation, it becomes the start time of the first operation. this is the same for
    //super's endTimestamp, i.e. it is the end time of the last operation. in this case, the stagger operation happens
    //first before setting the super's endTimestamp.
    private int operationDuration;
    private Date deadlineTimestamp;

    public Task(int jobId, String jobName, String jobNotes, Date startTimestamp, int operationDuration, Date deadlineTimestamp){
        super(jobId, jobName, jobNotes, startTimestamp);
        this.operationDuration = operationDuration;
        this.deadlineTimestamp = deadlineTimestamp;
    }
}
