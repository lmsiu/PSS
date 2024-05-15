import java.util.*;
public class RecurringTask extends Task{
    private String name;
    private String typeCategory;
    private double startTime;
    private double duration;
    private String type;
    private int startDate;
    private int endDate;
    private int frequency;

    // Constructor for RecurringTask
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

    RecurringTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, String type, int startDate, int endDate, int frequency, String typeString){
        super(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay);
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
        this.type = type;
    }

    // Sets the type for the recurring task. The given string has to match (Case Sensitive) one of the given values
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

    // Returns the string value for the recurring tasks type
    public String getTaskType(){
        return type;
    }

    // Sets the task's start date after checking to make sure the given date is valid
    public void setStartDate(int startingDate) {
        if (!isValidDate(startingDate)) {
            throw new IllegalArgumentException("Invalid start date. Must be a valid date.");
        }
        this.startDate = startingDate;
    }

    // Sets the task's end date after checking to make sure the given date is valid as an end date
    public void setEndDate(int finalDate) {
        if (!isValidDate(finalDate)) {
            throw new IllegalArgumentException("Invalid end date. Must be a valid date.");
        }
        if (finalDate <= startDate) {
            throw new IllegalArgumentException("End date can't be set to the same date as or before the starting date.");
        }
        this.endDate = finalDate;
    }

    // Method to ensure that the inputted integer for date has a valid year, month, and day within the month.
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

    // Checks to see if the year within date is a leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
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
}
