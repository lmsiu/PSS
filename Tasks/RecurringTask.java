package Tasks;

public class RecurringTask extends Task{
    private TaskType typeCategory;
    private int endDate;
    private int frequency;

    // Constructor for RecurringTask
    RecurringTask(String taskName, TaskType typeCat, double startTime, double duration, int startDate, int endDate, int frequency) {
        super(taskName, startTime, duration, startDate);
        this.typeCategory = typeCat;
        this.endDate = endDate;
        this.frequency = frequency;
    }

    RecurringTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, int startDate, int endDate, int frequency, TaskType taskType) throws Exception{
        super(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay);
        this.endDate = endDate;
        this.frequency = frequency;
        this.typeCategory = taskType;
    }

    public void setTaskType(TaskType taskType){
        typeCategory = taskType;

    }

    public TaskType getTaskType(){
        return typeCategory;
    }

    // Sets the task's end date after checking to make sure the given date is valid as an end date
    public void setEndDate(int finalDate) {
        if (!super.isValidDate(finalDate)) {
            throw new IllegalArgumentException("Invalid end date. Must be a valid date.");
        }
        if (finalDate <= this.getDate()) {
            throw new IllegalArgumentException("End date can't be set to the same date as or before the starting date.");
        }
        this.endDate = finalDate;
    }

    // Returns the integer value for the recurring tasks endDate variable
    public int getEndDate() {
        return endDate;
    }

    // Sets the frequency for the recurring task, must be a number between 1 and 7
    public void setFrequency(int freq) {
        if (freq < 1 || freq > 7) {
            throw new IllegalArgumentException("Frequency must be a value between 1 and 7.");
        }
        this.frequency = freq;
    }

    // Returns the integer value for the recurring tasks frequency
    public int getFrequency() {
        return frequency;
    }

    // Task type class
    public enum TaskType{
        CLASS,
        STUDY,
        SLEEP,
        EXERCISE,
        WORK,
        MEAL

    }
}
