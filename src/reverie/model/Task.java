package reverie.model;

import reverie.scheduler.Scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Dell on 11/7/2014.
 */

/**
 * Represents a job with a deadline, an operation duration, and
 */
public class Task extends Job implements Comparable<Task> {
    private int numOperations;
    //the numOperations dictates the number of operations. the sieze of operationRanges is equal to this.
    //in this class, super's startTimestamp denotes a "global" start time - that is, the start time of the entire task.
    //if the task has more than one operation, it becomes the start time of the first operation. this is the same for
    //super's endTimestamp, i.e. it is the end time of the last operation. in this case, the stagger operation happens
    //first before setting the super's endTimestamp.
    private SubTask[] subTasks;
    private UUID prerequisiteJobId;
    private int operationDuration;
    private Date deadlineTimestamp;
    private long weight;
    private boolean hardDeadline; //reserve for future use
    public Task(UUID jobId, String jobName, String jobNotes, int numOperations, int operationDuration, Date deadlineTimestamp) {
        super(jobId, jobName, jobNotes);
        this.numOperations = numOperations;
        this.operationDuration = operationDuration;
        this.deadlineTimestamp = deadlineTimestamp;
        this.subTasks = new SubTask[numOperations];
    }

    public SubTask[] getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(SubTask[] subTasks) {
        this.subTasks = subTasks;
    }

    public boolean isHardDeadline() {
        return hardDeadline;
    }

    public void setHardDeadline(boolean hardDeadline) {
        this.hardDeadline = hardDeadline;
    }

    public UUID getPrerequisiteJobId() {
        return prerequisiteJobId;
    }

    public void setPrerequisiteJobId(UUID prerequisiteJobId) {
        this.prerequisiteJobId = prerequisiteJobId;
    }

    //getter and setter
    @Override
    public UUID getJobId(){
        return super.getJobId();
    }

    @Override
    public void setJobId(UUID jobId){
        super.setJobId(jobId);
    }

    @Override
    public String getJobName(){
        return super.getJobName();
    }

    @Override
    public void setJobName(String jobName){
        super.setJobName(jobName);
    }

    @Override
    public String getJobNotes(){
        return super.getJobNotes();
    }

    @Override
    public void setJobNotes(String jobNotes){
        super.setJobNotes(jobNotes);
    }

    @Override
    public Date getStartTimestamp(){
        return super.getStartTimestamp();
    }

    @Override
    public void setStartTimestamp(Date startTimestamp){
        super.setStartTimestamp(startTimestamp);
    }

    @Override
    public Date getEndTimestamp(){
        return super.getEndTimestamp();
    }

    @Override
    public void setEndTimestamp(Date endTimestamp){
        super.setEndTimestamp(endTimestamp);
    }

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

    //implemented from Comparable
    public int compareTo(Task o){
        return (int) (weight - o.weight);
    }
}
