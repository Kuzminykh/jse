package ru.kuzminykh.tm.dao;

import ru.kuzminykh.tm.entity.Project;
import ru.kuzminykh.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    private List<Project> projects = new ArrayList<>();

    public Project create(final String name){
        final Project project = new Project(name);
        projects.add(project);
        return project;
    }

    public Project create(final String name,final String description){
        final Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        projects.add(project);
        return project;
    }

    public Project update(final Long id, final String name,final String description){
        final Project project = findById(id);
        if (project == null) return null;
        project.setId(id);
        project.setName(name);
        project.setDescription(description);
        return project;
    }

    public void clear(){
        projects.clear();
    }

    public Project findByIndex(int index){
        if (index < 0 || index > projects.size()-1) return null;
        return projects.get(index);
    }

    public Project findByName(final String name){
        if (name == null || name.isEmpty()) return null;
        for (final Project project: projects) {
            if (project.getName().equals(name)) return project;
        }
        return null;
    }

    public  Project findById(final Long id){
        if (id == null) return null;
        for (final Project project: projects) {
            if (project.getId().equals(id)) return project;
        }
        return null;
    }

    public Project removeByIndex(final int index){
        final Project task = findByIndex(index);
        if (task == null) return null;
        projects.remove(task);
        return task;
    }

    public Project removeById(final Long id){
        final Project task = findById(id);
        if (task == null) return null;
        projects.remove(task);
        return task;
    }

    public Project removeByName(final String name){
        final Project task = findByName(name);
        if (task == null) return null;
        projects.remove(task);
        return task;
    }

    public List<Project> findALL(){
        return projects;
    }

    public static void main(String[] args){
        final ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.create("Demo");
        projectDAO.create("Test");
        System.out.println(projectDAO.findALL());
        projectDAO.clear();
        System.out.println(projectDAO.findALL());
    }

}
