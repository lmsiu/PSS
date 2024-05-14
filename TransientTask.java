import java.util.*;

public class TransientTask extends Task {
    private String name;
    private String typeCategory;
    private float startTime;
    private float duration;
    private int date;
    
    // Constructor for TransientTask
    TransientTask (String name, String typeCategory, float startTime, float duration, int date) {
        this.name = name;
        setTaskType(typeCategory);
        this.startTime = startTime;
        this.duration = duration;
        this.date = date;
    }

    // Set the Transient Task type (Appointment, Shopping, and Visit)
    public void setTaskType(String transientTaskType) {
        if (transientTaskType.compareTo("Appointment") != 0 ||
            transientTaskType.compareTo("Shopping") != 0 ||
            transientTaskType.compareTo("Visit") != 0) {
            throw new IllegalArgumentException("Invalid task type. Must be one of: Appointment, Shopping, Visit.");
        }
        this.typeCategory = transientTaskType;
    }


}