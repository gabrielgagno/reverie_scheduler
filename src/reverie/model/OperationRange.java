package reverie.model;

import java.util.Date;

/**
 * Created by Dell on 2/3/2015.
 */
public class OperationRange {
    private Date rangeStart;
    private Date rangeEnd;

    public OperationRange(Date rangeStart, Date rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    public Date getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(Date rangeStart) {
        this.rangeStart = rangeStart;
    }

    public Date getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(Date rangeEnd) {
        this.rangeEnd = rangeEnd;
    }
}
