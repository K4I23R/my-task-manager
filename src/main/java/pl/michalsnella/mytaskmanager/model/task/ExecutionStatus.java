package pl.michalsnella.mytaskmanager.model.task;

public enum ExecutionStatus {
    NEW(0, "New"),
    IN_PROGRESS(1, "In progress"),
    DONE(2, "Done"),
    UNDONE(3, "Undone"),
    CANCELLED(4, "Cancelled");

    private final int code;
    private final String status;

    ExecutionStatus(int code, String status){
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
