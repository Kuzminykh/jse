package ru.kuzminykh.tm.repository;

import ru.kuzminykh.tm.entity.Project;
import ru.kuzminykh.tm.entity.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public Task create(final String name) {
        final Task project = new Task(name);
        tasks.add(project);
        return project;
    }

    public Task create(final String name, final String description) {
        final Task task = new Task(name, description);
        tasks.add(task);
        return task;
    }

    public Task create(final String name, final String description, Long userId) {
        final Task task = create(name, description);
        task.setUserId(userId);
        return task;
    }

    public Task update(final Long id, final String name, final String description) {
        final Task task = findById(id);
        if (task == null) return null;
        task.setId(id);
        task.setName(name);
        task.setDescription(description);
        return task;
    }

    public void clear() {
        tasks.clear();
    }

    public Task findByIndex(final int index) {
        if (index < 0 || index > tasks.size() - 1) return null;
        return tasks.get(index);
    }

    public Task findByName(final String name) {
        for (final Task task : tasks) {
            if (task.getName().equals(name)) return task;
        }
        return null;
    }

    public Task findById(final Long id) {
        for (final Task task : tasks) {
            if (task.getId().equals(id)) return task;
        }
        return null;
    }

    public Task findByProjectIdAndId(final Long projectId, final Long id) {
        if (id == null) return null;
        for (final Task task: tasks) {
            final Long idProject = task.getProjectId();
            if (idProject == null) continue;
            if (!idProject.equals(projectId)) continue;
            if (task.getId().equals(id)) return task;
        }
        return null;
    }

    public Task removeByIndex(final int index) {
        final Task task = findByIndex(index);
        if (task == null) return null;
        tasks.remove(task);
        return task;
    }

    public Task removeById(final Long id) {
        final Task task = findById(id);
        if (task == null) return null;
        tasks.remove(task);
        return task;
    }

    public Task removeByName(final String name) {
        final Task task = findByName(name);
        if (task == null) return null;
        tasks.remove(task);
        return task;
    }

    public List<Task> findAllByProjectId(final Long projectId){
        final List<Task> result = new ArrayList<>();
        for (final Task task: findAll()){
            final Long idProject = task.getProjectId();
            if (idProject == null) continue;
            if (idProject.equals(projectId)) result.add(task);
        }
        return result;
    }

    public List<Task> findAllByUserId(final Long userId) {
        final List<Task> result = new ArrayList<>();
        for (final Task task : findAll()) {
            final Long IdUser = task.getUserId();
            if (IdUser == null) continue;
            if (IdUser.equals(userId)) result.add(task);
        }
        return result;
    }

    public List<Task> findAll() {
        return tasks;
    }


}
