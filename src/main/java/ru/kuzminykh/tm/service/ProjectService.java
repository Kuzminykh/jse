package ru.kuzminykh.tm.service;

import ru.kuzminykh.tm.entity.Project;
import ru.kuzminykh.tm.repository.ProjectRepository;

import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(final String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.create(name);
    }

    public Project create(final String name, final String description) {
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return projectRepository.create(name, description);
    }

    public Project update(final Long id, final String name, final String description) {
        if (id == null) return null;
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return projectRepository.update(id, name, description);
    }

    public void clear() {
        projectRepository.clear();
    }

    public Project findByIndex(final int index) {
        return projectRepository.findByIndex(index);
    }

    public Project findByName(final String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.findByName(name);
    }

    public Project findById(final Long id) {
        if (id == null) return null;
        return projectRepository.findById(id);
    }

    public Project removeByIndex(final int index) {
        return projectRepository.removeByIndex(index);
    }

    public Project removeById(final Long id) {
        if (id == null) return null;
        return projectRepository.removeById(id);
    }

    public Project removeByName(final String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.removeByName(name);
    }

    public List<Project> findALL() {
        return projectRepository.findALL();
    }

}
