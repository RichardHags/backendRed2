package se.backend.groupred2.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.backend.groupred2.model.Task;
import se.backend.groupred2.model.TaskStatus;
import se.backend.groupred2.repository.TaskRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskService taskService;

    Task task, task2;

    @Before
    public void setUp() {
        task = new Task("TestTitle", "Testing a task creation", TaskStatus.UNSTARTED);
        task2 = new Task("test2", "test2", TaskStatus.STARTED);
    }

    @Test
    public void createTaskTest() {
        taskService.createTask(task);
        task.setId(1L);

        Optional<Task> testResult = taskRepository.findById(task.getId());
        Task savedTask = testResult.get();

        assertEquals(task.toString(), savedTask.toString());
        assertNotEquals(task2.toString(), savedTask.toString());
    }

    @After
    public void tearDown() {
        taskRepository.delete(task);
    }
}