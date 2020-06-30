package com.gciolac;


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
 *  + Task(t:Task)
 *  - setManMinutes(minutes: long)
 *  - setManHours(hours: long)
 *  + setTaskLength(hours: long, minutes: long)
 *  - getLength():long
 *  + getSlack():long
 *  + hasArrive():boolean
 *  + getTimeline(): long
 *  + toString():String
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
     * Copy constructor
     * @param t
     */
    public Task(Task t){
        this.title  = t.title;
        this.description = t.description;
        this.arrivalTime = t.arrivalTime;
        this.deadline = t.deadline;
        this.priority = t.priority;
        this.manMinutes = t.manMinutes;
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
     *
     * @return priority
     */
    public Priority getPriority(){
        return this.priority;
    }

    /**
     * setter for priority
     * @param p
     */
    public void setPriority(Priority p){
        this.priority = p;
    }

    /**
     * @return time from arrivalTime to deadline
     */
    public long getTimeline(){
        if(deadline == null || arrivalTime == null)
            return 0;
        return Math.abs(deadline.get() - arrivalTime.get());
    }

    public int compareTo(Task t){
        if(this.getPriority().compareTo(t.getPriority()) != 0) //if priority enum is not equal
            return this.getPriority().compareTo(t.getPriority());
        if(this.getSlack() < t.getSlack())
            return 1;
        else if(this.getSlack() > t.getSlack())
            return -1;
        return 0;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(this.title +"\n\tArrival Time:"+ this.arrivalTime.toString() + "\n\tDeadline:"+ this.deadline);
        if(this.hasArrived())
            s.append("\n\tSlack Time:"+ getSlack()+"min\n");
        return s.toString();

    }

}
