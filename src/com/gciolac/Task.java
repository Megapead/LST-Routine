package com.gciolac;

import java.util.Date;

public class Task {
    private String title, description;
    private Time deadline,arrivalTime;
    private Priority priority;
    private long manMinutes;

    public Task(String title,Time deadline){
        this.arrivalTime = Time.now();
        this.deadline = deadline;
        this.title = title;
        this.manMinutes = 0;
    }

    public Task(String title, Time startTime, Time deadline){
        this(title,deadline);
        this.arrivalTime = startTime;
    }

    private void setManMinutes(long minutes){
        this.manMinutes = minutes;
    }

    private void setManHours(long hours){
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

    public boolean hasArrived(){
        if(Time.now().get() - this.arrivalTime.get() < 0)
            return false;
        return true;
    }

    /**
     *
     * @return time from startTime to deadline
     */
    public long getTimeline(){
        if(deadline == null || arrivalTime == null)
            return 0;
        return Math.abs(deadline.get() - arrivalTime.get());
    }

    @Override
    public String toString(){
        if
    }

}
