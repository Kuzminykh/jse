package ru.kuzminykh.tm;

import ru.kuzminykh.tm.controller.ProjectController;
import ru.kuzminykh.tm.controller.SystemController;
import ru.kuzminykh.tm.controller.TaskController;
import ru.kuzminykh.tm.repository.ProjectRepository;

import ru.kuzminykh.tm.repository.TaskRepository;

import java.util.Scanner;

import static ru.kuzminykh.tm.constant.TerminalConst.*;

/*
 * Учебный проект в рамках курса Java.
 */

public class App {

    private final ProjectRepository projectRepository = new ProjectRepository();

    private final TaskRepository taskRepository = new TaskRepository();

    private final ProjectController projectController = new ProjectController(projectRepository);

    private final TaskController taskController = new TaskController(taskRepository);

    private final SystemController systemController = new SystemController();

     {
        projectRepository.create("Demo Project 1");
        projectRepository.create("Demo Project 2");
        taskRepository.create("Test Task 1");
        taskRepository.create("Test Task 2");
    }

    public static void main(final String[] args) {
        final App app = new App();
        app.run(args);
        app.systemController.displayWelcome();
        app.process();
    }

    public void process() {
        final Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!EXIT.equals(command)) {
            command = scanner.nextLine();
            run(command);
            System.out.println();
        }
    }

    public void run(final String[] args) {
        if (args == null) return;
        if (args.length < 1) return;
        final String param = args[0];
        final int result = run(param);
        System.exit(result);
    }

    public int run(final String param) {
        if (param == null || param.isEmpty()) return -1;
        switch (param) {
            case VERSION: return systemController.displayVersion();
            case ABOUT: return systemController.displayAbout();
            case HELP: return systemController.displayHelp();
            case EXIT: return systemController.displayExit();

            case PROJECT_LIST: return projectController.listProject();
            case PROJECT_CREATE: return projectController.createProject();
            case PROJECT_CLEAR: return projectController.clearProject();
            case PROJECT_VIEW_INDEX: return projectController.viewProjectByIndex();
            case PROJECT_VIEW_ID: return projectController.viewProjectById();
            case PROJECT_REMOVE_NAME: return projectController.removeProjectByName();
            case PROJECT_REMOVE_ID: return projectController.removeProjectById();
            case PROJECT_REMOVE_INDEX: return projectController.removeProjectByIndex();
            case PROJECT_UPDATE_INDEX: return projectController.updateProjectByIndex();
            case PROJECT_UPDATE_ID: return projectController.updateProjectById();

            case TASK_LIST: return taskController.listTask();
            case TASK_CREATE: return taskController.createTask();
            case TASK_CLEAR: return taskController.clearTask();
            case TASK_VIEW_INDEX: return taskController.viewTaskByIndex();
            case TASK_VIEW_ID: return taskController.viewTaskById();
            case TASK_REMOVE_NAME: return taskController.removeTaskByName();
            case TASK_REMOVE_ID: return taskController.removeTaskById();
            case TASK_REMOVE_INDEX: return taskController.removeTaskByIndex();
            case TASK_UPDATE_INDEX: return taskController.updateTaskByIndex();
            case TASK_UPDATE_ID: return taskController.updateTaskById();

            default: return systemController.displayError();
        }
    }

}
