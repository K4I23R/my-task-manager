package pl.michalsnella.mytaskmanager.service;

import org.springframework.stereotype.Service;
import pl.michalsnella.mytaskmanager.repository.TaskRepository;
import pl.michalsnella.mytaskmanager.model.task.Task;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Integer id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(existingTask -> applyUpdates(existingTask, updatedTask))
                .orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));
    }

    public Task partiallyUpdateTask(Integer id, Task partialUpdate) {
        return taskRepository.findById(id)
                .map(existingTask -> applyPartialUpdates(existingTask, partialUpdate))
                .orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));
    }

    public Task setArchivedStatus(Integer id, boolean isArchived) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setIsArchived(isArchived);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));
    }

    public void deleteTask(Integer id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task with ID " + id + " not found");
        }
        taskRepository.deleteById(id);
    }

    private Task applyUpdates(Task existingTask, Task updatedTask) {
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setBody(updatedTask.getBody());
        existingTask.setExecutionStatus(updatedTask.getExecutionStatus());
        existingTask.setIsArchived(updatedTask.getIsArchived());
        return taskRepository.save(existingTask);
    }

    private Task applyPartialUpdates(Task existingTask, Task partialUpdate) {
        if (partialUpdate.getTitle() != null) existingTask.setTitle(partialUpdate.getTitle());
        if (partialUpdate.getBody() != null) existingTask.setBody(partialUpdate.getBody());
        if (partialUpdate.getExecutionStatus() != null) existingTask.setExecutionStatus(partialUpdate.getExecutionStatus());
        return taskRepository.save(existingTask);
    }
}
