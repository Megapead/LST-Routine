package com.gciolac;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	Date deadline = new Date(1998,11,17,18,10);
	Date start = new Date(1998,11,17,18,0);
	Task t1 = new Task("Test",start);
	t1.setDeadline(deadline);
	System.out.println(t1.lengthMinutes());
    }
}
