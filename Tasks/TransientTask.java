package Tasks;

public class TransientTask extends Task {
    private TypeCategory typeCategory;

    // Constructor for TransientTask
    TransientTask(String name, TypeCategory typeCategory, double startTime, double duration, int date) {
        super(name, startTime, duration, date);
        setTaskType(typeCategory);

        String dateString = Integer.toString(date);
        int year = Integer.parseInt(dateString.substring(0, 4));
        int month = Integer.parseInt(dateString.substring(4, 6));
        int day = Integer.parseInt(dateString.substring(6, 8));
        try {
			setDate(year, month, day);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    TransientTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, TypeCategory typeCategory) throws Exception{
        super(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay);
        this.typeCategory = typeCategory;
    }

    // Set the Transient Task type (Appointment, Shopping, and Visit)
    public void setTaskType(TypeCategory transientTaskType) {
        if (transientTaskType != TypeCategory.Appointment &&
            transientTaskType != TypeCategory.Shopping &&
            transientTaskType != TypeCategory.Visit) {
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
        Appointment,
        Shopping,
        Visit
    }

    @Override
    public String getTaskDetails(){
        String details = super.getTaskDetails() + 
        "\nTask type: " + typeCategory.toString();

        return details;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Type Category: " + typeCategory;
    }

}