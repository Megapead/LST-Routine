package com.gciolac;

import java.util.LinkedList;

/**
 * @Author Gabriel Ciolac
 *
 * Basic Data structure object backed by a generic linkedlist
 *
 * TaskList:
 *
 *  - tasks:LinkedList
 *===========================================================
 *  + TaskList()
 *  + add(t:Task)
 *  + peek():Task
 *  + get(index: int): Task
 *  + remove(index: int): Task
 *  + toString(): String
 *
 */
public class TaskList {
    private LinkedList<Task> tasks;

    /**
     * Constructor using generic LinkedList object
     */
    public TaskList(){
        tasks = new LinkedList<Task>();
    }

    /**
     * add t to list
     * @param t
     */
    public void add(Task t){
        tasks.add(t);
    }

    /**
     * Note: SAME OBJECT
     * peek at first entry in list
     * @return
     */
    public Task peek(){
        return tasks.peek();
    }

    /**
     * Note: NOT SAME OBJECT
     * @param index
     * @return copy of list.at(index)
     */
    public Task get(int index){
        return new Task(tasks.get(index));
    }

    /**
     * Note: SAME OBJECT
     * @param index
     * @return
     */
    public Task remove(int index){
        return  tasks.remove(index);
    }

    public String toString(){
        StringBuilder s = new StringBuilder("");
        for(Task t: tasks){
            s.append(t.toString());
        }
        return s.toString();
    }

}