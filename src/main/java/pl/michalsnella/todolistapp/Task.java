package pl.michalsnella.todolistapp;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String body;
    @Convert(converter = ExecutionStatusConverter.class)
    private ExecutionStatus executionStatus;
    private LocalDateTime timeOfCreation;
    private LocalDateTime timeOfUpdate;
    private boolean isArchived;

    public Task(Integer id, String title, ExecutionStatus executionStatus, LocalDateTime timeOfCreation, boolean archived) {
        this.id = id;
        this.title = title;
        this.executionStatus = executionStatus;
        this.timeOfCreation = timeOfCreation;
        this.isArchived = archived;
    }

    public Task(LocalDateTime timeOfCreation) {

        this.timeOfCreation = timeOfCreation;
    }

    public Task() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ExecutionStatus getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(ExecutionStatus executionStatus) {
        this.executionStatus = executionStatus;
    }

    public LocalDateTime getTimeOfCreation() {
        return timeOfCreation;
    }

    public LocalDateTime getTimeOfUpdate() {
        return timeOfUpdate;
    }

    public void setTimeOfUpdate(LocalDateTime timeOfUpdate) {
        this.timeOfUpdate = timeOfUpdate;
    }

    public boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(boolean archived) {
        this.isArchived = archived;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", executionStatus=" + executionStatus +
                ", timeOfCreation=" + timeOfCreation +
                ", timeOfUpdate=" + timeOfUpdate +
                ", archived=" + isArchived +
                '}';
    }
}
