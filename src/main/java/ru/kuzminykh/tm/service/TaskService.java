package ru.kuzminykh.tm.service;

import ru.kuzminykh.tm.entity.Task;
import ru.kuzminykh.tm.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.create(name);
    }

    public Task create(String name, String description) {
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return taskRepository.create(name, description);
    }

    public Task update(Long id, String name, String description) {
        if (id == null) return null;
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return taskRepository.update(id, name, description);
    }

    public void clear() {
        taskRepository.clear();
    }

    public Task findByIndex(int index) {
        if (index <= 0) return null;
        return taskRepository.findByIndex(index);
    }

    public Task findByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.findByName(name);
    }

    public Task findById(Long id) {
        if (id == null) return null;
        return taskRepository.findById(id);
    }

    public Task removeByIndex(int index) {
        if (index <= 0) return null;
        return taskRepository.removeByIndex(index);
    }

    public Task removeById(Long id) {
        if (id == null) return null;
        return taskRepository.removeById(id);
    }

    public Task removeByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.removeByName(name);
    }

    public List<Task> findALL() {
        return taskRepository.findALL();
    }

}
