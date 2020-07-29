package ru.kuzminykh.tm.controller;

import ru.kuzminykh.tm.repository.TaskRepository;
import ru.kuzminykh.tm.entity.Task;

public class TaskController extends AbstractController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public int createTask() {
        System.out.println("[CREATE TASK]");
        System.out.println("[Please, enter task name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter task description:]");
        final String description = scanner.nextLine();
        taskRepository.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int updateTaskByIndex() {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter, task index");
        final int index = Integer.parseInt(scanner.nextLine())-1;
        final Task task = taskRepository.findByIndex(index);
        if (task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter task name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter task description:]");
        final String description = scanner.nextLine();
        taskRepository.update(task.getId(),name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int updateTaskById() {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter, task id");
        final Long id = Long.parseLong(scanner.nextLine());
        final Task task = taskRepository.findById(id);
        if (task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description:]");
        final String description = scanner.nextLine();
        taskRepository.update(task.getId(),name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int removeTaskByName() {
        System.out.println("[REMOVE TASK BY NAME]");
        System.out.println("[Please, enter task name:]");
        final String name = scanner.nextLine();
        final Task task = taskRepository.removeByName(name);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeTaskById() {
        System.out.println("[REMOVE TASK BY ID]");
        System.out.println("[Please, enter task id:]");
        final Long id = scanner.nextLong();
        final Task task = taskRepository.removeById(id);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeTaskByIndex() {
        System.out.println("[REMOVE TASK BY INDEX]");
        System.out.println("[Please, enter task index:]");
        final int index = scanner.nextInt() - 1;
        final Task task = taskRepository.removeByIndex(index);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int clearTask() {
        System.out.println("[CLEAR TASK]");
        taskRepository.clear();
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
        final int index = scanner.nextInt() - 1;
        final Task task = taskRepository.findByIndex(index);
        viewTask(task);
        return 0;
    }

    public int viewTaskById() {
        System.out.println("Enter, task id");
        final Long id = scanner.nextLong();
        final Task task = taskRepository.findById(id);
        viewTask(task);
        return 0;
    }

    public int listTask() {
        System.out.println("[LIST TASK]");
        int index = 1;
        for (final Task task : taskRepository.findALL()) {
            System.out.println(index + ". " + task.getId() + ": " + task.getName());
            index++;
        }
        System.out.println();
        System.out.println("[OK]");
        return 0;
    }


}
