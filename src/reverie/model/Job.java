package reverie.model;


import java.util.Date;

/**
 * Represents a job in the scheduling problem.
 * @author Gabriel John Gagno
 * @version 1.0 11/6/2014
 *
 */
public class Job {
    private int jobId;
    private String jobName;
    private String jobNotes;
    private Date startTimestamp;
    private Date endTimestamp;
    //startTimestamp is the start time of the job
    //endTimestamp is the end time of the job
    //these parameters are applicable to all its subclasses

    public Job(int jobId, String jobName, String jobNotes, Date startTimestamp, Date endTimestamp){
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobNotes = jobNotes;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    protected Job(int jobId, String jobName, String jobNotes, Date startTimestamp){
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobNotes = jobNotes;
        this.startTimestamp = startTimestamp;
    }
}