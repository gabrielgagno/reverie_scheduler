package reverie.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Dell on 2/26/2015.
 */
public class SubTask extends Job{
    private UUID motherTaskId;
    private Date subTaskStart;
    private Date subTaskEnd;

    public SubTask(UUID motherTaskId, Date subTaskStart, Date subTaskEnd) {
        this.motherTaskId = motherTaskId;
        this.subTaskStart = subTaskStart;
        this.subTaskEnd = subTaskEnd;
    }

    public SubTask(UUID motherTaskId){
        this.motherTaskId = motherTaskId;
    }

    public UUID getMotherTaskId() {
        return motherTaskId;
    }

    public void setMotherTaskId(UUID motherTaskId) {
        this.motherTaskId = motherTaskId;
    }

    public Date getSubTaskStart() {
        return subTaskStart;
    }

    public void setSubTaskStart(Date subTaskStart) {
        this.subTaskStart = subTaskStart;
    }

    public Date getSubTaskEnd() {
        return subTaskEnd;
    }

    public void setSubTaskEnd(Date subTaskEnd) {
        this.subTaskEnd = subTaskEnd;
    }
}
