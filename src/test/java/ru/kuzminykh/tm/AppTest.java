package ru.kuzminykh.tm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ru.kuzminykh.tm.entity.Project;
import ru.kuzminykh.tm.entity.Task;

/**
 * Unit test for simple App.
 */
public class
AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        final Application app = new Application();
        final Task task = app.getTaskService().findByIndex(0);
        System.out.println(task);
        final Project project = app.getProjectService().findByIndex(0);
        System.out.println(project);
        app.getProjectTaskService().addTaskToProject(project.getId(), task.getId());
        System.out.println(app.getProjectTaskService().findAllByProjectId(project.getId()));
        app.getProjectTaskService().removeTaskToProject(project.getId(), task.getId());
        System.out.println(app.getProjectTaskService().findAllByProjectId(project.getId()));
        assertTrue(true);
    }
}
