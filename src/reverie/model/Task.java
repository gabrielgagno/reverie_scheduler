package reverie.model;

import reverie.scheduler.Scheduler;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Dell on 11/7/2014.
 */

/**
 * Represents a job with a deadline, an operation duration, and
 */
public class Task extends Job implements Comparable<Task> {
    private int numOperations;
    //in this class, super's startTimestamp denotes a "global" start time - that is, the start time of the entire task.
    //if the task has more than one operation, it becomes the start time of the first operation. this is the same for
    //super's endTimestamp, i.e. it is the end time of the last operation. in this case, the stagger operation happens
    //first before setting the super's endTimestamp.
    private int operationDuration;
    private Date deadlineTimestamp;
    private long weight;

    public Task(int jobId, String jobName, String jobNotes, int numOperations, int operationDuration, Date deadlineTimestamp) {
        super(jobId, jobName, jobNotes);
        this.numOperations = numOperations;
        this.operationDuration = operationDuration;
        this.deadlineTimestamp = deadlineTimestamp;
    }

    //getter and setter
    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public int getNumOperations() {
        return numOperations;
    }

    public void setNumOperations(int numOperations) {
        this.numOperations = numOperations;
    }

    public int getOperationDuration() {
        return operationDuration;
    }

    public void setOperationDuration(int operationDuration) {
        this.operationDuration = operationDuration;
    }

    public Date getDeadlineTimestamp() {
        return deadlineTimestamp;
    }

    public void setDeadlineTimestamp(Date deadlineTimestamp) {
        this.deadlineTimestamp = deadlineTimestamp;
    }

    public int compareTo(Task o){
        return (int) (weight - o.weight);
    }
}
