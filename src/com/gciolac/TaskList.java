package com.gciolac;

import java.util.Collections;
import java.util.Comparator;
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

    /**
     * Swapping Two nodes,
     * Note: Does not use local add method, uses add method from LinkedList
     * @param indexY
     * @param indexZ
     */
    private void swap(int indexY,int indexZ){
        if(indexY == indexZ)
            return;
        Task tmp = this.get(indexY);
        this.remove(indexY);
        this.tasks.add(indexY,this.get(indexZ - 1));
        this.remove(indexZ -1);
        this.tasks.add(indexZ,tmp);

    }

    /**
     * Quick sort algorithm for sorting list
     * @param left
     * @param right
     */
    public void sort(int left,int right){
        if(right == -1)
            right = this.tasks.size() - 1;
        if(left < right){
            Task pivot = this.get(right);
            int pos = left -1;
            for(int i = left; i < right; i++){
                if(this.get(i).compareTo(pivot) <= 0)
                    this.swap(++pos,i);
            }
            swap(pos + 1, right);
            sort(left,pos);
            sort(pos + 1,right);

        }
    }
    private LinkedList<Task> getList(){
        return this.tasks;
    }
    public String toString(){
        StringBuilder s = new StringBuilder("");
        for(Task t: tasks){
            s.append(t.toString());
        }
        return s.toString();
    }

    public static TaskList copy(TaskList list){
        if(list == null)
            throw new NullPointerException("List is Null");
        TaskList tmp = new TaskList();

        for(Task t: list.getList())
            tmp.add(t);

        return tmp;
    }

}
