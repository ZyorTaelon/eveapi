package com.beimin.eveapi.model.character;

import java.util.Date;

public class SkillQueueItem {
    private int queuePosition;
    private int typeID;
    private int level;
    private int startSP;
    private int endSP;
    private Date startTime;
    private Date endTime;

    public int getQueuePosition() {
        return queuePosition;
    }

    public void setQueuePosition(final int queuePosition) {
        this.queuePosition = queuePosition;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(final int typeID) {
        this.typeID = typeID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getStartSP() {
        return startSP;
    }

    public void setStartSP(final int startSP) {
        this.startSP = startSP;
    }

    public int getEndSP() {
        return endSP;
    }

    public void setEndSP(final int endSP) {
        this.endSP = endSP;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }
}
