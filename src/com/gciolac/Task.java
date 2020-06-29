package com.gciolac;

import java.util.Date;

/**
 * @Author Gabriel Ciolac
 * Task object is a schedulable moment in time
 * Task:
 *  - title:String
 *  - description:String
 *  - deadline:Time
 *  - arrivalTime: Time
 *  - priority: Priority
 *  - manMinutes: long
 *  =======================================================
 *  + Task(title:String, deadline:Time)
 *  + Task(title:String, startTime: Time, deadline:Time)
 *  - setManMinutes(minutes: long)
 *  - setManHours(hours: long)
 *  + setTaskLength(hours: long, minutes: long)
 *  - getLength():long
 *  + getSlack():long
 *  + hasArrive():boolean
 */
public class Task {
    private String title, description;
    private Time deadline,arrivalTime;
    private Priority priority;
    private long manMinutes;

    /**
     * Tasks need a deadline and a title by default
     * 
     * @param title
     * @param deadline
     */
    public Task(String title,Time deadline){
        this.arrivalTime = Time.now();
        this.deadline = deadline;
        this.title = title;
        this.manMinutes = 0;
    }

    /**
     * The start time parameter can be used to cause the task to arrive at a later time
     * possible use case is not wanting to start a task this very moment
     * @param title
     * @param startTime
     * @param deadline
     */
    public Task(String title, Time startTime, Time deadline){
        this(title,deadline);
        this.arrivalTime = startTime;
    }

    /**
     * How many minutes do you think a task will take?
     * @param minutes
     */
    private void setManMinutes(long minutes){
        this.manMinutes = minutes;
    }

    /**
     * How many hours do you think a task will take?
     * @param hours
     */
    private void setManHours(long hours){
        this.setManMinutes(hours*60);
    }

    /**
     * A combined method for man minutes and hours
     * @param hours
     * @param minutes
     */
    public void setTaskLength(long hours, long minutes){
        this.setManHours(hours);
        this.manMinutes += minutes;
    }

    /**
     * How long the task takes in minutes
     * @return
     */
    private long getLength(){
        return this.manMinutes;
    }

    /**
     * How much slack is from now to the project deadline if length is known, otherwise task has 0 slack
     * @return
     */
    public long getSlack(){
        if(manMinutes == 0 || getTimeline() == 0)
            return 0;
        return this.deadline.get() - (Time.now().get() + this.getLength());
    }

    /**
     * If the current time is less then the arrival time then task has not arrived
     * @return
     */
    public boolean hasArrived(){
        if(Time.now().get() - this.arrivalTime.get() < 0)
            return false;
        return true;
    }

    /**
     * @return time from arrivalTime to deadline
     */
    public long getTimeline(){
        if(deadline == null || arrivalTime == null)
            return 0;
        return Math.abs(deadline.get() - arrivalTime.get());
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(this.title +"\n\tArrival Time:"+ this.arrivalTime.toString() + "\n\tDeadline:"+ this.deadline);
        if(this.hasArrived())
            s.append("\n\tSlack Time:"+ getSlack()+"min\n");
        return s.toString();

    }

}
