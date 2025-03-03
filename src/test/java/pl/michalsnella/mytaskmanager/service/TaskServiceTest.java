package pl.michalsnella.mytaskmanager.service;

import org.junit.jupiter.api.Test;
import pl.michalsnella.mytaskmanager.model.task.ExecutionStatus;
import pl.michalsnella.mytaskmanager.model.task.Task;
import pl.michalsnella.mytaskmanager.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TaskServiceTest {

    @Test
    public void test1() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        taskList.add(new Task(1, "title1", "body", ExecutionStatus.NEW, LocalDateTime.of(2025, 1, 1, 12, 0, 0), false));
        TaskRepository taskRepository = mock(TaskRepository.class);
    }

}
