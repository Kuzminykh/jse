package ru.kuzminykh.tm.controller;

import ru.kuzminykh.tm.repository.ProjectRepository;
import ru.kuzminykh.tm.entity.Project;

public class ProjectController extends AbstractController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public int createProject() {
        System.out.println("[CREATE PROJECT]");
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description:]");
        final String description = scanner.nextLine();
        projectRepository.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int updateProjectByIndex() {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter, project index");
        final int index = Integer.parseInt(scanner.nextLine())-1;
        final Project project = projectRepository.findByIndex(index);
        if (project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description:]");
        final String description = scanner.nextLine();
        projectRepository.update(project.getId(),name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int updateProjectById() {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter, project id");
        final Long id = Long.parseLong(scanner.nextLine());
        final Project project = projectRepository.findById(id);
        if (project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description:]");
        final String description = scanner.nextLine();
        projectRepository.update(project.getId(),name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int removeProjectByName() {
        System.out.println("[REMOVE PROJECT BY NAME]");
        System.out.println("[Please, enter project name:]");
        final String name = scanner.nextLine();
        final Project project = projectRepository.removeByName(name);
        if (project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeProjectById() {
        System.out.println("[REMOVE PROJECT BY ID]");
        System.out.println("[Please, enter project id:]");
        final Long id = scanner.nextLong();
        final Project project = projectRepository.removeById(id);
        if (project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeProjectByIndex() {
        System.out.println("[REMOVE PROJECT BY INDEX]");
        System.out.println("[Please, enter project index:]");
        final int index = scanner.nextInt() - 1;
        final Project project = projectRepository.removeByIndex(index);
        if (project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int clearProject() {
        System.out.println("[CLEAR PROJECT]");
        projectRepository.clear();
        System.out.println("[OK]");
        return 0;
    }

    public int listProject() {
        System.out.println("[LIST PROJECT]");
        int index = 1;
        for (final Project project : projectRepository.findALL()) {
            System.out.println(index + ". " + project.getId() + ": " + project.getName());
            index++;
        }
        System.out.println();
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
        final int index = scanner.nextInt()-1;
        final Project project = projectRepository.findByIndex(index);
        viewProject(project);
        return 0;
    }

    public  int viewProjectById() {
        System.out.println("Enter, project id");
        final Long id = scanner.nextLong();
        final Project project = projectRepository.findById(id);
        viewProject(project);
        return 0;
    }

}
