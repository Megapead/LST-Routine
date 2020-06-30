package com.gciolac;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	Time deadline1 = new Time(2020,6,30,18,0);
	Time deadline2 = new Time(2020,6,30,18,0);
	//Time deadline3 = new Time(2020,11,17,2,0);
	//Time deadline4 = new Time(2020,12,30,18,0);
	Time start4 = new Time(2020,12,0,0,0);
	Task t1 = new Task("Task1",deadline1);
	Task t2 = new Task("Task2",deadline2);
	//Task t3 = new Task("Task3",deadline3);
	//Task t4 = new Task("Task4",start4,deadline4);
	t1.setTaskLength(6,20);
	t2.setTaskLength( 6,20);
	//t3.setTaskLength(22,0);
	//t4.setTaskLength(29,0);

	t2.setPriority(Priority.HIGH);
	t1.setPriority(Priority.HIGH);

	TaskList t = new TaskList();
	t.add(t1);
	t.add(t2);
	//t.add(t3);
	//t.add(t4);

	System.out.println(t2.compareTo(t1));

    }
}
