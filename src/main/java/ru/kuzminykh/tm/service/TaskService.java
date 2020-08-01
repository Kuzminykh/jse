package ru.kuzminykh.tm.service;

import ru.kuzminykh.tm.entity.Task;
import ru.kuzminykh.tm.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(final String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.create(name);
    }

    public Task create(final String name, final String description) {
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return taskRepository.create(name, description);
    }

    public Task update(final Long id, final String name, final String description) {
        if (id == null) return null;
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return taskRepository.update(id, name, description);
    }

    public void clear() {
        taskRepository.clear();
    }

    public Task findByIndex(final int index) {
         return taskRepository.findByIndex(index);
    }

    public Task findByName(final String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.findByName(name);
    }

    public Task findById(final Long id) {
        if (id == null) return null;
        return taskRepository.findById(id);
    }

    public Task removeByIndex(final int index) {
        return taskRepository.removeByIndex(index);
    }

    public Task removeById(final Long id) {
        if (id == null) return null;
        return taskRepository.removeById(id);
    }

    public Task removeByName(final String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.removeByName(name);
    }

    public List<Task> findALL() {
        return taskRepository.findALL();
    }

    public Task findByProjectIdAndId(Long projectId, Long id) {
        if (projectId == null || id == null) return null;
        return taskRepository.findByProjectIdAndId(projectId, id);
    }

    public List<Task> findAllByProjectId(Long projectId) {
        if (projectId == null) return null;
        return taskRepository.findAllByProjectId(projectId);
    }

}
