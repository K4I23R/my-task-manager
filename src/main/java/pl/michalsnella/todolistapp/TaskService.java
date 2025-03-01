package pl.michalsnella.todolistapp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(int id) {
        return taskRepository.findById(id);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Integer id, Task task) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(task.getTitle());
                    existingTask.setBody(task.getBody());
                    existingTask.setTimeOfUpdate(task.getTimeOfUpdate());
                    existingTask.setExecutionStatus(task.getExecutionStatus());
                    existingTask.setIsArchived(task.getIsArchived());

                    return taskRepository.save(existingTask);
                });
    }

    public Optional<Task> partiallyUpdateTask(Integer id, Task task) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    if (task.getTitle() != null) existingTask.setTitle(task.getTitle());
                    if (task.getBody() != null) existingTask.setBody(task.getBody());
                    if (task.getTimeOfUpdate() != null) existingTask.setTimeOfUpdate(task.getTimeOfUpdate());
                    if (task.getExecutionStatus() != null) existingTask.setExecutionStatus(task.getExecutionStatus());

                    return taskRepository.save(existingTask);
                });
    }

    public Optional<Task> archiveTask(Integer id, Task task) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    task.setIsArchived(true);

                    return taskRepository.save(existingTask);
                });
    }

    public Optional<Task> unArchiveTask(Integer id, Task task) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    task.setIsArchived(false);

                    return taskRepository.save(existingTask);
                });
    }
}
