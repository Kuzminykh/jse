package ru.kuzminykh.tm.dao;

import ru.kuzminykh.tm.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    private List<Project> projects = new ArrayList<>();

    public Project create(final String name){
        final Project project = new Project(name);
        projects.add(project);
        return project;
    }

    public void clear(){
        projects.clear();
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
