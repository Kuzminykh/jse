package ru.kuzminykh.tm.repository;

import ru.kuzminykh.tm.entity.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProjectRepository {

    private final List<Project> projects = new ArrayList<>();

    public Project create(final String name) {
        final Project project = new Project(name);
        projects.add(project);
        return project;
    }

    public Project create(final String name, final String description) {
        final Project project = new Project(name, description);
        projects.add(project);
        return project;
    }

    public Project create(final String name, final String description, Long userId) {
        final Project project = create(name, description);
        project.setUserId(userId);
        return project;
    }

    public Project update(final Long id, final String name, final String description) {
        final Project project = findById(id);
        if (project == null) return null;
        project.setId(id);
        project.setName(name);
        project.setDescription(description);
        return project;
    }

    public void clear() {
        projects.clear();
    }

    public Project findByIndex(final int index) {
        if (index < 0 || index > projects.size() - 1) return null;
        return projects.get(index);
    }

    public Project findByName(final String name) {
        for (final Project project : projects) {
            if (project.getName().equals(name)) return project;
        }
        return null;
    }

    public Project findById(final Long id) {
        for (final Project project : projects) {
            if (project.getId().equals(id)) return project;
        }
        return null;
    }

    public Project removeByIndex(final int index) {
        final Project task = findByIndex(index);
        if (task == null) return null;
        projects.remove(task);
        return task;
    }

    public Project removeById(final Long id) {
        final Project task = findById(id);
        if (task == null) return null;
        projects.remove(task);
        return task;
    }

    public Project removeByName(final String name) {
        final Project task = findByName(name);
        if (task == null) return null;
        projects.remove(task);
        return task;
    }

    public List<Project> findAllByUserId(final Long userId) {
        final List<Project> result = new ArrayList<>();
        for (final Project project : findAll()) {
            final Long IdUser = project.getUserId();
            if (IdUser == null) continue;
            if (IdUser.equals(userId)) result.add(project);
        }
        return result;
    }

    public List<Project> findAll() {
        return projects;
    }

}
