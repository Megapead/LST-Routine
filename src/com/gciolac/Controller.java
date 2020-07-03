package com.gciolac;

import java.nio.file.FileSystemNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    private TaskList t;
    private Scheduler scheduler;
    private Scanner in;

    private void viewCurrentTask(){
        System.out.print(scheduler.getSchedule().peek().toString());
    }

    private void deleteTask(){
        System.out.println("Select an entry to remove");
        System.out.println(scheduler.getSchedule().toString());
        if(scheduler.getSchedule().remove(in.nextInt()) != null)
            System.out.print("Removed\n");
        else
            System.out.print("Not Removed\n");
    }
    private void finishCurrentTask(){
        if(scheduler.getSchedule().remove(0) != null)
            System.out.print("Removed\n");
        else
            System.out.print("Not Removed\n");
    }

    private void addTask(){
        scheduler.addTask(Task.getTaskFromUser());
    }


    private void viewTasks(){
        System.out.println(scheduler.toString());
    }

    private void importCSV(){
        System.out.println("Function unavailable");
    }

    private void exportCSV(){
        System.out.println("Function unavailable");
    }
    private String selection(){
        StringBuilder s = new StringBuilder("1) View Current Task\n");
        s.append("2) Finish Current Task\n");
        s.append("3) Delete a Task\n");
        s.append("4) Add a Task\n");
        s.append("5) View Schedule\n");
        s.append("6 Import CSV\n");
        s.append("7) Export to CSV\n");
        s.append("Selection: ");
        return s.toString();
    }
    private void menu(){
        int sel = -1;
        while(sel != 0){
            System.out.print(selection());
            sel = in.nextInt();
            switch (sel){
                case 1: viewCurrentTask();  break;
                case 2: finishCurrentTask(); break;
                case 3: deleteTask(); break;
                case 4: addTask(); break;
                case 5: viewTasks(); break;
                case 6: importCSV(); break;
                case 7: exportCSV(); break;
                default: sel = 0; break;
            }
        }
        System.out.println("Thank you, have a nice day");
    }

    private void init(){
        System.out.println("Welcome to LST-Routine:");
        t = new TaskList();
        scheduler = new Scheduler(t);
        in = new Scanner(System.in);
        menu();
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.init();

    }
}
