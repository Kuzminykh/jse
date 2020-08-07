package ru.kuzminykh.tm.controller;

import ru.kuzminykh.tm.entity.Task;
import ru.kuzminykh.tm.entity.User;
import ru.kuzminykh.tm.repository.ProjectRepository;
import ru.kuzminykh.tm.entity.Project;
import ru.kuzminykh.tm.service.ProjectService;
import ru.kuzminykh.tm.service.ProjectTaskService;
import ru.kuzminykh.tm.service.UserService;

import java.util.List;

public class ProjectController extends AbstractController {

    private final ProjectService projectService;

    private final ProjectTaskService projectTaskService;

    private  final UserService userService;

    public ProjectController(ProjectService projectService, ProjectTaskService projectTaskService, UserService userService) {
        this.projectService = projectService;
        this.projectTaskService = projectTaskService;
        this.userService = userService;
    }

    public int createProject() {
        System.out.println("[CREATE PROJECT]");
        System.out.println("Please, enter project name:");
        final String name = scanner.nextLine();
        System.out.println("Please, enter project description:");
        final String description = scanner.nextLine();
        if (userService.user == null) projectService.create(name, description);
        else projectService.create(name, description, userService.user.getId());
       System.out.println("[OK]");
        return 0;
    }

    public void updateProject(Project project) {
        System.out.println("Please, enter project name:");
        final String name = scanner.nextLine();
        System.out.println("Please, enter project description:");
        final String description = scanner.nextLine();
        projectService.update(project.getId(), name, description);
        System.out.println("[OK]");
    }

    public int updateProjectByIndex() {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter, project index");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("FAIL! IT'S NOT NUMBER");
            return -1;
        }
        final int index = scanner.nextInt() - 1;
        scanner.nextLine();
        final Project project = projectService.findByIndex(index);
        if (project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        updateProject(project);
        return 0;
    }

    public int updateProjectById() {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter, project id");
        final Long id = Long.parseLong(scanner.nextLine());
        final Project project = projectService.findById(id);
        if (project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        updateProject(project);
        return 0;
    }

    public void removeProject(Project project){
        final List<Task> tasks = projectTaskService.findAllByProjectId(project.getId());
        for (final Task task : tasks) {
            projectTaskService.removeTaskToProject(project.getId(), task.getId());
        }
        System.out.println("[OK]");
    }

    public int removeProjectByIndex() {
        System.out.println("[REMOVE PROJECT BY INDEX]");
        System.out.println("Please, enter project index:");
        final int index = scanner.nextInt() - 1;
        final Project project = projectService.removeByIndex(index);
        if (project == null) System.out.println("[FAIL]");
        else removeProject(project);
        return 0;
    }

    public int removeProjectById() {
        System.out.println("[REMOVE PROJECT BY ID]");
        System.out.println("Please, enter project id:");
        final Long id = scanner.nextLong();
        final Project project = projectService.removeById(id);
        if (project == null) System.out.println("[FAIL]");
        else removeProject(project);
        return 0;
    }

    public int removeProjectByName() {
        System.out.println("[REMOVE PROJECT BY NAME]");
        System.out.println("Please, enter project name:");
        final String name = scanner.nextLine();
        final Project project = projectService.removeByName(name);
        if (project == null) System.out.println("[FAIL]");
        else removeProject(project);
        return 0;
    }

    public int clearProject() {
        System.out.println("[CLEAR PROJECT]");
        projectService.clear();
        System.out.println("[OK]");
        return 0;
    }

    public void viewProject(Project project) {
        if (project == null) return;
        System.out.println("[VIEW PROJECT]");
        System.out.println("ID:" + project.getId());
        System.out.println("NAME: " + project.getName());
        System.out.println("DESCRIPTION: " + project.getDescription());
        System.out.println("[OK]");
    }

    public int viewProjectByIndex() {
        System.out.println("Enter, project index");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("FAIL! IT'S NOT NUMBER");
            return -1;
        }
        final int index = scanner.nextInt() - 1;
        final Project project = projectService.findByIndex(index);
        viewProject(project);
        return 0;
    }

    public int viewProjectById() {
        System.out.println("Enter, project id");
        final Long id = scanner.nextLong();
        final Project project = projectService.findById(id);
        viewProject(project);
        return 0;
    }

   public int listProject() {
        System.out.println("[LIST PROJECT]");
        int index = 1;
        List<Project> projectList;
        if (userService.user == null) projectList = projectService.findAll();
        else projectList = projectService.findAllByUserId(userService.user.getId());
        for (final Project project : projectList) {
            System.out.println(index + ". " + project.getId() + ": " + project.getName());
            index++;
        }
        System.out.println("[OK]");
        return 0;
    }

}
