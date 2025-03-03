package pl.michalsnella.mytaskmanager.model.task;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import pl.michalsnella.mytaskmanager.model.task.ExecutionStatus;

@Converter(autoApply = true)
public class ExecutionStatusConverter implements AttributeConverter<ExecutionStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ExecutionStatus status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }

    @Override
    public ExecutionStatus convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        for (ExecutionStatus status : ExecutionStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown execution status code: " + code);
    }
}

