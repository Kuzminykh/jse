package ru.kuzminykh.tm.controller;

import ru.kuzminykh.tm.entity.User;

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
        System.out.println("login - The end of the current session.");
        System.out.println("logout - Terminate console application.");
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
        System.out.println("task-list-by-project-id - Display task list by project id");
        System.out.println("task-add-to-project-by-ids - Add task to project by ids");
        System.out.println("task-remove-form-project-by-ids - Remove task from project by id");
        System.out.println();

        System.out.println("user-create - Create new user.");
        System.out.println("user-create-admin - Create user as admin.");
        System.out.println("user-update-by-index - Update user by index.");
        System.out.println("user-update-by-id - Update user by id.");
        System.out.println("user-update-by-login - Update user by login.");
        System.out.println("user-remove-by-index - Remove user by index.");
        System.out.println("user-remove-by-id - Remove user by id.");
        System.out.println("user-remove-by-login - Remove user by login.");
        System.out.println("user-view-by-index- View user by idndex.");
        System.out.println("user-view-by-id - View user by id.");
        System.out.println("user-view-by-login - View user by login.");
        System.out.println("user-list - Display list of users.");
        System.out.println("user-clear - Remove all user.");
        System.out.println("user-info - View the current user.");
        System.out.println("user-update - Update the current user.");
        System.out.println("user-update-password -  Change password.");
        System.out.println();
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
