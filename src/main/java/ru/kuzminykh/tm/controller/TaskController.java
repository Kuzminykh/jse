package ru.kuzminykh.tm.controller;

import ru.kuzminykh.tm.entity.Task;
import ru.kuzminykh.tm.service.ProjectTaskService;
import ru.kuzminykh.tm.service.TaskService;

import java.util.List;

public class TaskController extends AbstractController {

    private final TaskService taskService;

    private final ProjectTaskService projectTaskService;

    public TaskController(TaskService taskService, ProjectTaskService projectTaskService) {
        this.taskService = taskService;
        this.projectTaskService = projectTaskService;
    }

    public int createTask() {
        System.out.println("[CREATE TASK]");
        System.out.println("Please, enter task name:");
        final String name = scanner.nextLine();
        System.out.println("Please, enter task description:");
        final String description = scanner.nextLine();
        taskService.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    public void updateTask(Task task) {
        System.out.println("Please, enter task name:");
        final String name = scanner.nextLine();
        System.out.println("Please, enter task description:");
        final String description = scanner.nextLine();
        taskService.update(task.getId(), name, description);
        System.out.println("[OK]");
    }

    public int updateTaskByIndex() {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter, task index");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("FAIL! IT'S NOT NUMBER");
            return -1;
        }
        final int index = scanner.nextInt() - 1;
        scanner.nextLine();
        final Task task = taskService.findByIndex(index);
        if (task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        updateTask(task);
        return 0;
    }

    public int updateTaskById() {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter, task id");
        final Long id = Long.parseLong(scanner.nextLine());
        final Task task = taskService.findById(id);
        if (task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        updateTask(task);
        return 0;
    }

    public int removeTaskByName() {
        System.out.println("[REMOVE TASK BY NAME]");
        System.out.println("Please, enter task name:");
        final String name = scanner.nextLine();
        final Task task = taskService.removeByName(name);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeTaskById() {
        System.out.println("[REMOVE TASK BY ID]");
        System.out.println("Please, enter task id:");
        final Long id = scanner.nextLong();
        final Task task = taskService.removeById(id);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeTaskByIndex() {
        System.out.println("[REMOVE TASK BY INDEX]");
        System.out.println("Please, enter task index:");
        final int index = scanner.nextInt() - 1;
        final Task task = taskService.removeByIndex(index);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int clearTask() {
        System.out.println("[CLEAR TASK]");
        taskService.clear();
        System.out.println("[OK]");
        return 0;
    }

    public void viewTask(Task task) {
        if (task == null) return;
        System.out.println("[VIEW TASK]");
        System.out.println("ID:" + task.getId());
        System.out.println("NAME: " + task.getName());
        System.out.println("DESCRIPTION: " + task.getDescription());
        System.out.println("[OK]");
    }

    public int viewTaskByIndex() {
        System.out.println("Enter, task index");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("FAIL! IT'S NOT NUMBER");
            return -1;
        }
        final int index = scanner.nextInt() - 1;
        final Task task = taskService.findByIndex(index);
        viewTask(task);
        return 0;
    }

    public int viewTaskById() {
        System.out.println("Enter, task id");
        final Long id = scanner.nextLong();
        final Task task = taskService.findById(id);
        viewTask(task);
        return 0;
    }

    public int listTask() {
        System.out.println("[LIST TASK]");
        viewTasks(taskService.findALL());
        System.out.println();
        System.out.println("[OK]");
        return 0;
    }

    public void viewTasks(final List<Task> tasks){
        if (tasks == null || tasks.isEmpty()) return;
        int index = 1;
        for (final Task task : tasks) {
            System.out.println(index + ". " + task.getId() + ": " + task.getName() + " (Description: " + task.getDescription() + ")");
            index++;
        }
    }

    public int listTaskByProjectId(){
        System.out.println("[LIST TASK BY PROJECT]");
        System.out.println("Please, enter project id:");
        final Long projectId = Long.parseLong(scanner.nextLine());
        final List<Task> tasks = taskService.findAllByProjectId(projectId);
        viewTasks(tasks);
        System.out.println("[OK]");
        return 0;
    }

    public int addTaskToProjectByIds(){
        System.out.println("[ADD TASK TO PROJECT BY IDS]");
        System.out.println("Please, enter project id:");
        final Long projectId = Long.parseLong(scanner.nextLine());
        System.out.println("Please, enter task id:");
        final Long taskId = Long.parseLong(scanner.nextLine());
        projectTaskService.addTaskToProject(projectId, taskId);
        System.out.println("[OK]");
        return 0;
    }

    public int removeTaskFromProjectByIds(){
        System.out.println("[REMOVE TASK FROM PROJECT BY IDS]");
        System.out.println("Please, enter project id:");
        final Long projectId = Long.parseLong(scanner.nextLine());
        System.out.println("Please, enter task id:");
        final Long taskId = Long.parseLong(scanner.nextLine());
        projectTaskService.removeTaskToProject(projectId, taskId);
        System.out.println("[OK]");
        return 0;
    }

}
