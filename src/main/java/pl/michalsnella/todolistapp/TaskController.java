package pl.michalsnella.todolistapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
//@RequestMapping
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("tasks")
    public ResponseEntity<Iterable<Task>> getAllTasks() {
        Iterable<Task> tasks = taskService.getAllTasks();

        return ResponseEntity.ok(tasks);
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Integer id) {
        return taskService.getTask(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task savedTask = taskService.addTask(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTask.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedTask);
    }

    @PutMapping("tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task task) {
        return taskService.updateTask(id, task)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("tasks/{id}")
    public ResponseEntity<Task> partiallyUpdateTask(@PathVariable Integer id, @RequestBody Task task) {
        return taskService.partiallyUpdateTask(id, task)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PatchMapping("tasks/{id}")
//    public ResponseEntity<Task> archiveTask(@PathVariable Integer id, @RequestBody Task task) {
//        return taskService.archiveTask(id, task)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PatchMapping("tasks/{id}")
//    public ResponseEntity<Task> unArchiveTask(@PathVariable Integer id, @RequestBody Task task) {
//        return taskService.unArchiveTask(id, task)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }


}
