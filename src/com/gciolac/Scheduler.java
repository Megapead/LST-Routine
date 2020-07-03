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
        this.schedule.sort(0,-1);
    }

    public Task getCurrentTask(){
        return schedule.peek();
    }

    public TaskList getSchedule(){
        return this.schedule;
    }

    public void addTask(Task t){
        schedule.add(t);
        update();
    }
    public String toString(){
        return this.schedule.toString();
    }

}
