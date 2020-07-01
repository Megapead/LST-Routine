package com.gciolac;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Gabriel Ciolac
 *  Basic Time object, created to avoid usage of deprecated Date constructor
 *  and also to shift epoch time from ms to min
 *
 *  Time:
 *
 *  - current:Date
 *  ================================================================
 *  - Time()
 *  + Time(year: int, month: int, day: int, hour: int, minute: int)
 *  + now():Time
 *  + get():long
 *  + toString():String
 */
public class Time {
    private Date current;

    /**
     * Creates an object at the current time
     */
    private Time(){
        this.current = new Date();
    }


    /**
     * creates an object at specific time
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     */
    public Time(int year, int month, int day,int hour,int minute){
        Calendar tmp = Calendar.getInstance();
        tmp.set(Calendar.YEAR,year);
        tmp.set(Calendar.MONTH,month -1);
        tmp.set(Calendar.DAY_OF_MONTH,day);
        tmp.set(Calendar.HOUR_OF_DAY,hour);
        tmp.set(Calendar.MINUTE,minute);
        this.current = tmp.getTime();
    }

    public Time(long minutes){
        this.current = new Date(minutes * 60000);
    }

    /**
     * @return current time
     */
    public static Time now(){
        return new Time();
    }

    /**
     * @return time since epoch in minutes
     */
    public long get(){
        return this.current.getTime() / 60000;
    }


    @Override
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return dateFormat.format(this.current);
    }
}
