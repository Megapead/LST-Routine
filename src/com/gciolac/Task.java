package com.gciolac;

import java.util.Date;

public class Task {
    private String title, description;
    private Date deadline, startTime;
    private byte priority;
    private int averageTime;

    public Task(String title){
        this.title = title;
    }

    public Task(String title, Date startTime){
        this(title);
        this.startTime = startTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }


    public int getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    /**
     * Converts time into minutes
     * Date.getTime() returns milliseconds since epoch as a long
     * milliseconds / 60000 is time in minutes.
     * Getting the delta between the deadline and the startTime should give you the task length
     * @return int
     */
    public int lengthMinutes(){
        return (int) (Math.abs(this.deadline.getTime() - this.startTime.getTime())/60000);
    }

}
