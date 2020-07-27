package ru.kuzminykh.tm;

import ru.kuzminykh.tm.dao.ProjectDAO;

import ru.kuzminykh.tm.dao.TaskDAO;
import ru.kuzminykh.tm.entity.Project;
import ru.kuzminykh.tm.entity.Task;

import java.util.Scanner;

import static ru.kuzminykh.tm.constant.TerminalConst.*;

/*
 * Учебный проект в рамках курса Java.
 */

public class App {

    private static final ProjectDAO projectDAO = new ProjectDAO();

    private static final TaskDAO taskDAO = new TaskDAO();

    private static final Scanner scanner = new Scanner(System.in);

    static {
        projectDAO.create("Demo Project 1");
        projectDAO.create("Demo Project 2");
        taskDAO.create("Test Task 1");
        taskDAO.create("Test Task 2");
    }

    public static void main(final String[] args) {
        run(args);
        displayWelcome();
        process();
    }

    private static void process() {
        String command = "";
        while (!EXIT.equals(command)) {
            command = scanner.nextLine();
            run(command);
            System.out.println();
        }
    }

    private static void run(final String[] args) {
        if (args == null) return;
        if (args.length < 1) return;
        final String param = args[0];
        final int result = run(param);
        System.exit(result);
    }

    private static int run(final String param) {
        if (param == null || param.isEmpty()) return -1;
        switch (param) {
            case VERSION: return displayVersion();
            case ABOUT: return displayAbout();
            case HELP: return displayHelp();
            case EXIT: return displayExit();

            case PROJECT_LIST: return listProject();
            case PROJECT_CREATE: return createProject();
            case PROJECT_CLEAR: return clearProject();
            case PROJECT_VIEW_INDEX: return viewProjectByIndex();
            case PROJECT_VIEW_ID: return viewProjectById();
            case PROJECT_REMOVE_NAME: return removeProjectByName();
            case PROJECT_REMOVE_ID: return removeProjectById();
            case PROJECT_REMOVE_INDEX: return removeProjectByIndex();
            case PROJECT_UPDATE_INDEX: return updateProjectByIndex();
            case PROJECT_UPDATE_ID: return updateProjectById();

            case TASK_LIST: return listTask();
            case TASK_CREATE: return createTask();
            case TASK_CLEAR: return clearTask();
            case TASK_VIEW_INDEX: return viewTaskByIndex();
            case TASK_VIEW_ID: return viewTaskById();
            case TASK_REMOVE_NAME: return removeTaskByName();
            case TASK_REMOVE_ID: return removeTaskById();
            case TASK_REMOVE_INDEX: return removeTaskByIndex();
            case TASK_UPDATE_INDEX: return updateTaskByIndex();
            case TASK_UPDATE_ID: return updateTaskById();

            default: return displayError();
        }
    }

    private static int createProject() {
        System.out.println("[CREATE PROJECT]");
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description:]");
        final String description = scanner.nextLine();
        projectDAO.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateProjectByIndex() {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter, project index");
        final int index = Integer.parseInt(scanner.nextLine())-1;
        final Project project = projectDAO.findByIndex(index);
        if (project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description:]");
        final String description = scanner.nextLine();
        projectDAO.update(project.getId(),name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateProjectById() {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter, project id");
        final Long id = Long.parseLong(scanner.nextLine());
        final Project project = projectDAO.findById(id);
        if (project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description:]");
        final String description = scanner.nextLine();
        projectDAO.update(project.getId(),name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int removeProjectByName() {
        System.out.println("[REMOVE PROJECT BY NAME]");
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        final Project project = projectDAO.removeByName(name);
        if (project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeProjectById() {
        System.out.println("[REMOVE PROJECT BY ID]");
        System.out.println("[Please, enter project id:]");
        final Long id = scanner.nextLong();
        final Project project = projectDAO.removeById(id);
        if (project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeProjectByIndex() {
        System.out.println("[REMOVE PROJECT BY INDEX]");
        System.out.println("[Please, enter project index:]");
        final int index = scanner.nextInt() - 1;
        final Project project = projectDAO.removeByIndex(index);
        if (project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int clearProject() {
        System.out.println("[CLEAR PROJECT]");
        projectDAO.clear();
        System.out.println("[OK]");
        return 0;
    }

    private static int listProject() {
        System.out.println("[LIST PROJECT]");
        int index = 1;
        for (final Project project : projectDAO.findALL()) {
            System.out.println(index + ". " + project.getId() + ": " + project.getName());
            index++;
        }
        System.out.println();
        System.out.println("[OK]");
        return 0;
    }

    private static void viewProject(Project project) {
        if (project == null) return;
        System.out.println("[VIEW PROJECT]");
        System.out.println("ID:" + project.getId());
        System.out.println("NAME: " + project.getName());
        System.out.println("DESCRIPTION: " + project.getDescription());
        System.out.println("[OK]");
    }

    private static int viewProjectByIndex() {
        System.out.println("Enter, project index");
        final int index = scanner.nextInt() - 1;
        final Project project = projectDAO.findByIndex(index);
        viewProject(project);
        return 0;
    }

    private static int viewProjectById() {
        System.out.println("Enter, project id");
        final Long id = scanner.nextLong();
        final Project project = projectDAO.findById(id);
        viewProject(project);
        return 0;
    }

    private static int createTask() {
        System.out.println("[CREATE TASK]");
        System.out.println("[Please, enter task name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter task description:]");
        final String description = scanner.nextLine();
        taskDAO.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateTaskByIndex() {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter, task index");
        final int index = Integer.parseInt(scanner.nextLine())-1;
        final Task task = taskDAO.findByIndex(index);
        if (task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter task name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter task description:]");
        final String description = scanner.nextLine();
        taskDAO.update(task.getId(),name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateTaskById() {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter, task id");
        final Long id = Long.parseLong(scanner.nextLine());
        final Task task = taskDAO.findById(id);
        if (task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description:]");
        final String description = scanner.nextLine();
        taskDAO.update(task.getId(),name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int removeTaskByName() {
        System.out.println("[REMOVE TASK BY NAME]");
        System.out.println("[Please, enter task name:]");
        final String name = scanner.nextLine();
        final Task task = taskDAO.removeByName(name);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeTaskById() {
        System.out.println("[REMOVE TASK BY ID]");
        System.out.println("[Please, enter task id:]");
        final Long id = scanner.nextLong();
        final Task task = taskDAO.removeById(id);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeTaskByIndex() {
        System.out.println("[REMOVE TASK BY INDEX]");
        System.out.println("[Please, enter task index:]");
        final int index = scanner.nextInt() - 1;
        final Task task = taskDAO.removeByIndex(index);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int clearTask() {
        System.out.println("[CLEAR TASK]");
        taskDAO.clear();
        System.out.println("[OK]");
        return 0;
    }

    private static void viewTask(Task task) {
        if (task == null) return;
        System.out.println("[VIEW TASK]");
        System.out.println("ID:" + task.getId());
        System.out.println("NAME: " + task.getName());
        System.out.println("DESCRIPTION: " + task.getDescription());
        System.out.println("[OK]");
    }

    private static int viewTaskByIndex() {
        System.out.println("Enter, task index");
        final int index = scanner.nextInt() - 1;
        final Task task = taskDAO.findByIndex(index);
        viewTask(task);
        return 0;
    }

    private static int viewTaskById() {
        System.out.println("Enter, task id");
        final Long id = scanner.nextLong();
        final Task task = taskDAO.findById(id);
        viewTask(task);
        return 0;
    }

    private static int listTask() {
        System.out.println("[LIST TASK]");
        int index = 1;
        for (final Task task : taskDAO.findALL()) {
            System.out.println(index + ". " + task.getId() + ": " + task.getName());
            index++;
        }
        System.out.println();
        System.out.println("[OK]");
        return 0;
    }

    private static int displayError() {
        System.out.println("Error! Unknown program argument...");
        return -1;
    }

    private static int displayExit() {
        System.out.println("Terminate program...");
        return 0;
    }

    private static void displayWelcome() {
        System.out.println("** WELCOME TO TASK MANAGER **");
    }

    private static int displayHelp() {
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

    private static int displayVersion() {
        System.out.println("1.0.7");
        return 0;
    }

    private static int displayAbout() {
        System.out.println("NataLia Kuzminykh");
        System.out.println("Kuzmihyh_nn@nlmk.com");
        return 0;
    }

}
