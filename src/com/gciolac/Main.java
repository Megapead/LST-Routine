package com.gciolac;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	Time deadline = new Time(2020,6,30,18,10);
	Time start = new Time(2020,6,30,18,0);
	Task t1 = new Task("Test",deadline);
	t1.setTaskLength(3,30);
	System.out.println(t1.toString());
    }
}
