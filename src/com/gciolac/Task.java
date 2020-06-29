package com.gciolac;

import java.util.Date;

public class Task {
    private String title, description;
    private Time deadline, startTime,arrivalTime;
    private Priority priority;
    private long manMinutes;

    public Task(String title){
        this.arrivalTime = Time.now();
        this.title = title;
        this.manMinutes = 0;
    }

    public Task(String title, Time startTime){
        this(title);
        this.startTime = startTime;
    }
    public Task(String title, Time startTime, Time deadline){
        this(title,startTime);
        this.deadline = deadline;
    }

    public void setStartTime(Time startTime){
        this.startTime = startTime;
    }
    public void setDeadline(Time deadline) {
        this.deadline = deadline;
    }

    public void setManMinutes(long minutes){
        this.manMinutes = minutes;
    }

    public void setManHours(long hours){
        this.setManMinutes(hours*60);
    }

    public void setTaskLength(long hours, long minutes){
        this.setManHours(hours);
        this.manMinutes += minutes;
    }

    private long getManMinutes(){
        return this.manMinutes;
    }

    public long getSlack(){
        if(manMinutes == 0 || getTimeline() == 0)
            return 0;
        return this.deadline.get() - (Time.now().get() + this.getManMinutes());
    }

    /**
     *
     * @return time from startTime to deadline
     */
    public long getTimeline(){
        if(deadline == null || startTime == null)
            return 0;
        return Math.abs(deadline.get() - startTime.get());
    }


}
