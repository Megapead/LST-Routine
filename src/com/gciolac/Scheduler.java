package com.gciolac;

public class Scheduler {
    private TaskList schedule;

    public Scheduler(){
        this.schedule = new TaskList();
    }

    public Scheduler(TaskList t){
        this.schedule = TaskList.copy(t);
        this.update();
    }

    private void update(){
        this.schedule.sort();
    }

    public String print(){
        return this.schedule.toString();
    }

}
