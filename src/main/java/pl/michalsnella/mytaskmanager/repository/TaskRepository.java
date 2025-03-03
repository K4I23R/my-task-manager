package pl.michalsnella.mytaskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import pl.michalsnella.mytaskmanager.model.task.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
