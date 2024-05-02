import java.util.*;

public class TransientTask extends Task {
    private String name;
    private TypeCategory typeCategory;
    private float startTime;
    private float duration;
    private int date;

    // Constructor for TransientTask
    TransientTask (String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        this.name = name;
        setTaskType(typeCategory);
        this.startTime = startTime;
        this.duration = duration;
        this.date = date;
    }

    // Set the Transient Task type (Appointment, Shopping, and Visit)
    public void setTaskType(TypeCategory transientTaskType) {
        if (transientTaskType != TypeCategory.APPOINTMENT &&
            transientTaskType != TypeCategory.SHOPPING &&
            transientTaskType != TypeCategory.VISIT) {
            throw new IllegalArgumentException("Invalid task type. Must be one of: APPOINTMENT, SHOPPING, VISIT");
        }
        this.transientTaskType = transientTaskType;
    }

    // Get the Transient Task type
    public TypeCategory getTaskType() {
        return this.typeCategory;
    }

    // enum declaration for Type Categories for Transient Task
    public enum TypeCategory {
        APPOINTMENT,
        SHOPPING,
        VISIT
    }

}