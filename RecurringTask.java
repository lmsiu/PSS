import java.time.LocalDate;

public class RecurringTask extends Task{
    private String name;
    private String typeCategory;
    private double startTime;
    private double duration;
    private String type;
    private int startDate;
    private int endDate;
    private int frequency;

    RecurringTask(String taskName,String typeCat, double startTime, double duration, String type, int startDate, int endDate, int frequency) {
        this.name = taskName;
        this.typeCategory = typeCat;
        this.startTime = startTime;
        this.duration = duration;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
    }
    // The given string has to match (Case Sensitive) one of the strings that we've selected as a recurring task
    public void setTaskType(String taskType){
        this.type = taskType;

        List<String> validTaskTypes = Arrays.asList("Class", "Study", "Sleep", "Exercise", "Work", "Meal");

        // Check if the given task type is valid
        if (validTaskTypes.contains(taskType)) {
            this.type = taskType;
        } else {
            throw new IllegalArgumentException("Invalid task type. Must be one of: " + validTaskTypes);
        }
    }
}
    public String getTaskType(){
        return type;
    }
    // Must be a valid date, so months are from 01 to 12 and days from 01 to whatever the last day of that month would be
    public void setStartDate(int startingDate) {
        if (!isValidDate(startingDate)) {
            throw new IllegalArgumentException("Invalid start date. Must be a valid date.");
        }
        this.startDate = startingDate;
    }

    public void setEndDate(int finalDate) {
        if (!isValidDate(finalDate)) {
            throw new IllegalArgumentException("Invalid end date. Must be a valid date.");
        }
        if (finalDate <= startDate) {
            throw new IllegalArgumentException("End date can't be set to the same date as or before the starting date.");
        }
        this.endDate = finalDate;
    }

    private boolean isValidDate(int date) {
        int year = date / 10000;
        int month = (date % 10000) / 100;
        int day = date % 100;

        if (month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        if (day < 1 || day > daysInMonth[month - 1]) {
            return false;
        }

        return true;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int getEndDate() {
        return endDate;
    }
    public void setFrequency(int freq) {
        if (freq < 1 || freq > 7) {
            throw new IllegalArgumentException("Frequency must be a value between 1 and 7.");
        }
        this.frequency = freq;
    }

    public int getFrequency() {
        return frequency;
    }
