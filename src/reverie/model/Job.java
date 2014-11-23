package reverie.model;


import java.util.Date;
import java.util.UUID;

/**
 * Represents a job in the scheduling problem.
 * @author Gabriel John Gagno
 * @version 1.0 11/6/2014
 *
 */
public abstract class Job {
    protected UUID jobId;
    protected String jobName;
    protected String jobNotes;
    protected Date startTimestamp;
    protected Date endTimestamp;
    //startTimestamp is the start time of the job
    //endTimestamp is the end time of the job
    //these parameters are applicable to all its subclasses

    protected Job(UUID jobId, String jobName, String jobNotes, Date startTimestamp, Date endTimestamp){
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobNotes = jobNotes;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    protected Job(UUID jobId, String jobName, String jobNotes) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobNotes = jobNotes;
    }

    protected UUID getJobId() {
        return jobId;
    }

    protected void setJobId(UUID jobId) {
        this.jobId = jobId;
    }

    protected String getJobName() {
        return jobName;
    }

    protected void setJobName(String jobName) {
        this.jobName = jobName;
    }

    protected String getJobNotes() {
        return jobNotes;
    }

    protected void setJobNotes(String jobNotes) {
        this.jobNotes = jobNotes;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
    }
}