package ru.kuzminykh.tm.service;

import ru.kuzminykh.tm.entity.Project;
import ru.kuzminykh.tm.entity.Task;
import ru.kuzminykh.tm.repository.ProjectRepository;
import ru.kuzminykh.tm.repository.TaskRepository;

import java.util.Collections;
import java.util.List;

public class ProjectTaskService {

    private final ProjectRepository projectRepository;

    private final TaskRepository taskRepository;

    public ProjectTaskService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public List<Task> findAddByProjectId(final Long projectId) {
        if (projectId == null) return Collections.emptyList();
        return taskRepository.findAllByProjectId(projectId);
    }

    public Task removeTaskToProject(final Long projectId, final Long taskId){
        final  Task task = taskRepository.findByProjectIdAndId(projectId, taskId);
        if (task == null) return null;
        task.setProjectId(null);
        return task;
    }

    public Task addTaskToProject(final Long projectId, final Long taskId){
        final Project project = projectRepository.findById(projectId);
        if (project == null) return null;
        final  Task task = taskRepository.findById(taskId);
        if (task == null) return null;
        task.setProjectId(projectId);
        return task;
    }

}
