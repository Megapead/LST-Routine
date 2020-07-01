package com.gciolac;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Time dl1 = new Time(2020,7,1,18,10);
        Time dl2 = new Time(2020,8,1,18,10);
        Time dl3 = new Time(2020,7,2,18,10);
        Time dl4 = new Time(2020,7,3,18,10);

        Time st1 = new Time(2020,7,1,18,10);

        Task t1 = new Task("Task1", dl1);
        Task t2 = new Task("Task2",st1,dl2);
        Task t3 = new Task("Task3",dl3);
        Task t4 = new Task("Task4",dl4);

        t1.setTaskLength(2,00);
        t2.setTaskLength(2,00);
        t3.setTaskLength(2,00);
        t4.setTaskLength(2,00);


        TaskList t = new TaskList();

        t.add(t1);
        t.add(t2);
        t.add(t3);
        t.add(t4);

        System.out.println(t.toString());
        Scheduler s = new Scheduler(t);
        System.out.println(s.toString());

    }
}
