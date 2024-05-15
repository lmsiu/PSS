package Tasks;

public class TransientTask extends Task {
    private TypeCategory typeCategory;

    // Constructor for TransientTask
    TransientTask(String name, TypeCategory typeCategory, double startTime, double duration, int date) {
        super(name, startTime, duration, date);
        setTaskType(typeCategory);
    }

    TransientTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, TypeCategory typeCategory) throws Exception{
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