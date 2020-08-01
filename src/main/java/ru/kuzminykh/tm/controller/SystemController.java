package ru.kuzminykh.tm.controller;

public class SystemController {


    public int displayError() {
        System.out.println("Error! Unknown program argument...");
        return -1;
    }

    public int displayExit() {
        System.out.println("Terminate program...");
        return 0;
    }

    public void displayWelcome() {
        System.out.println("** WELCOME TO TASK MANAGER **");
    }

    public int displayHelp() {
        System.out.println("version - Display application version.");
        System.out.println("about - Display developer info.");
        System.out.println("help - Display list of commands.");
        System.out.println("exit - Terminate console application.");
        System.out.println();
        System.out.println("project-list - Display list of projects.");
        System.out.println("project-create - Create new project by name.");
        System.out.println("project-clear - Remove all projects.");
        System.out.println("project-view-index - View project by index.");
        System.out.println("project-view-id - View project by id.");
        System.out.println("project-remove-by-id - Remove project by id.");
        System.out.println("project-remove-by-name - Remove project by name.");
        System.out.println("project-remove-by-index - Remove project by index.");
        System.out.println("project-update-by-index - Update project by index.");
        System.out.println("project-update-by-id - Update project by id.");
        System.out.println();
        System.out.println("task-list - Display list of tasks.");
        System.out.println("task-create - Create new task by name.");
        System.out.println("task-clear - Remove all tasks.");
        System.out.println("task-view-index - View task by index.");
        System.out.println("task-view-id - View task by id.");
        System.out.println("task-remove-by-id - Remove task by id.");
        System.out.println("task-remove-by-name - Remove task by name.");
        System.out.println("task-remove-by-index - Remove task by index.");
        System.out.println("task-update-by-index - Update task by index.");
        System.out.println("task-update-by-id - Update task by id.");
        return 0;
    }

    public int displayVersion() {
        System.out.println("1.0.7");
        return 0;
    }

    public int displayAbout() {
        System.out.println("NataLia Kuzminykh");
        System.out.println("Kuzmihyh_nn@nlmk.com");
        return 0;
    }

}
