package ru.kuzminykh.tm.dao;

import ru.kuzminykh.tm.entity.Project;
import ru.kuzminykh.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private List<Task> tasks = new ArrayList<>();

    public Task create(final String name){
        final Task project = new Task(name);
        tasks.add(project);
        return project;
    }

    public void clear(){
        tasks.clear();
    }

    public List<Task> findALL(){
        return tasks;
    }

}
