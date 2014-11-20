package reverie.model;


import java.util.Date;

/**
 * Represents a job in the scheduling problem.
 * @author Gabriel John Gagno
 * @version 1.0 11/6/2014
 *
 */
public abstract class Job {
    protected int jobId;
    protected String jobName;
    protected String jobNotes;
    protected Date startTimestamp;
    protected Date endTimestamp;
    //startTimestamp is the start time of the job
    //endTimestamp is the end time of the job
    //these parameters are applicable to all its subclasses

    protected Job(int jobId, String jobName, String jobNotes, Date startTimestamp, Date endTimestamp){
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobNotes = jobNotes;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    protected Job(int jobId, String jobName, String jobNotes) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobNotes = jobNotes;
    }
}