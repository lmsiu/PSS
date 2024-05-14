import java.util.Calendar;

public class Task {
    private String name;
    private String typeCategory;
    private double startTime;
    private double duration;
    private double endTime;
    private int yyymmdd;
    private int week;
    private int day;
    private int month;
    private int year;

    Task(){
        //empty constructor 
    }

    Task(String name, String typeCategory, int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay) {
        this.name = name;
        this.typeCategory = typeCategory;
        this.day = dateDay;
        this.month = dateMonth;
        this.year = dateYear;
        setStartTime(startTimeHour, startTimeMinute, AM);
        setDuration(durationHour, durationMinutes);
        setDate(dateYear, dateMonth, dateDay);
        setWeek(dateYear, dateMonth, dateDay);
        
    }

    // Constructor to pass in exact values however this should be removed later
    Task(String name, String typeCategory, float startTime, float duration, int date) {
        this.name = name;
        this.typeCategory = typeCategory;
        this.duration = duration;
        this.yyymmdd = date;
        this.startTime = startTime;
        
    }
    

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setTypeCategory(String typeCategory){
        this.typeCategory = typeCategory;

    }

    public String getTypeCategory(){
        return typeCategory;
    }

    public void setStartTime(int hour, int minute, boolean AM){
        //boolean AM true if AM and false if PM
        double startTimeHour = AM ? hour : hour + 12;

        //start time range 0.0 - 23.75 (must round to the nearest 15 minutes (0.25))
        double startTimeMinute = roundFifteen(minute); // the percentage of the hour

        startTime = startTimeHour + startTimeMinute;
        
        // try catch for if it dosent work
        try {
            if(startTime <= 0 || startTime >= 23.75){
                // throws an error if the time is too big
                throw new TaskNotCreatedEexcption("Invalid start time");
            }
        } catch (TaskNotCreatedEexcption e) {
           System.out.println(e.getMessage());
        }
        
    }

    public double getStartTime(){
        return startTime;
    }

    
    public void setDuration(int durationHour, int durationMinute){
        this.duration = durationHour + roundFifteen(durationMinute);
        this.endTime = this.startTime + this.duration;
    }

    public double getDuration(){
        return duration;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double getEndTime() {
        return endTime;
    }

    private void updateEndTime() {
        this.endTime = this.startTime + this.duration;
    }

    public void setDate(int year, int month, int day){
        yyymmdd = (year*10000) + (month*100) + day;
    }

    public int getDate(){
        return yyymmdd;
    }

    public void setWeek(int dateYear, int dateMonth, int dateDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(dateYear, dateMonth - 1, dateDay);
        week = calendar.get(Calendar.WEEK_OF_YEAR);
    }
    
    public int getWeek() {
        return week;
    }

    public void setMonth(int dateMonth) {
        this.month = dateMonth;
    }
    
    public int getMonth() {
        return month;
    }
    private double roundFifteen(int value){
        return Math.ceil((value/60.0)*4)/4;

    }

    // How to print this Task class
    @Override
    public String toString() {
        return "Task: " + name + "\n" +
               "Type Category: " + typeCategory + "\n" +
               "Start Time: " + startTime + "\n" +
               "Duration: " + duration + "\n" +
               "Date: " + year + "-" + month + "-" + day;
    }
    
    
}


// exception for if the task is not initalized
class TaskNotCreatedEexcption extends Exception{
    public TaskNotCreatedEexcption(String errorMessage){
        super(errorMessage);

    }
}