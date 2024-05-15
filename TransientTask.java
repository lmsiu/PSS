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

    TransientTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, TypeCategory typeCategory){
        super(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay);
        this.typeCategory = typeCategory;
    }

    // Set the Transient Task type (Appointment, Shopping, and Visit)
    public void setTaskType(TypeCategory transientTaskType) {
        if (transientTaskType != TypeCategory.APPOINTMENT &&
            transientTaskType != TypeCategory.SHOPPING &&
            transientTaskType != TypeCategory.VISIT) {
            throw new IllegalArgumentException("Invalid task type. Must be one of: APPOINTMENT, SHOPPING, VISIT");
        }
        this.typeCategory = transientTaskType;
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