import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TransientTaskController {
    private Model model;

    public TransientTaskController(Model model) {
        this.model = model;
    }

    // List of valid task types for transients
    private static final List<String> VALID_TASK_TYPES = Arrays.asList("Visit", "Shopping", "Appointment");

    // Method to validate the task type
    public void validateTaskType(String taskType) {
        // Check if the given task type is valid (case-sensitive)
        if (!VALID_TASK_TYPES.contains(taskType)) {
            throw new IllegalArgumentException("Invalid task type. Must be one of: " + VALID_TASK_TYPES);
        }
    }

    // Method to validate all attributes are filled in for transient task (work in progress)
    public void validateTransientTask(String name, TypeCategory typeCategory, Date date, float startTime, float duration) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (typeCategory != TypeCategory.TRANSIENT) {
            throw new IllegalArgumentException("Type category must be TRANSIENT.");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        if (startTime < 0 || startTime >= 24) {
            throw new IllegalArgumentException("Start time must be between 0 and 24 hours.");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0.");
        }
    }
}

