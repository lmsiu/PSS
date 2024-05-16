package Tasks;
public class Task {
    private String name;
    private double startTime;
    private double duration;
    private int date;

    Task(){
        //empty constructor 
    }

    Task(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay) throws Exception {
        this.name = name;
        setStartTime(startTimeHour, startTimeMinute, AM);
        setDuration(durationHour, durationMinutes);
        setDate(dateYear, dateMonth, dateDay);
        
    }

    // Keep this constructor
    // Used when we know parameters have been validated already Ex: reading from data from a file
    Task(String name, double startTime, double duration, int date) {
        this.name = name;
        this.duration = duration;
        this.date = date;
        this.startTime = startTime;
        
    }
    

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    public void setStartTime(int hour, int minute, boolean AM) throws Exception{
        //boolean AM true if AM and false if PM
        double startTimeHour = AM ? hour : hour + 12;

        //start time range 0.0 - 23.75 (must round to the nearest 15 minutes (0.25))
        double startTimeMinute = roundFifteen(minute); // the percentage of the hour

        startTime = startTimeHour + startTimeMinute;
        
        // try catch for if it dosent work
   
            if(startTime <= 0 || startTime >= 23.75){
                // throws an error if the time is too big
                throw new TaskNotCreatedEexcption("Invalid start time");
            }
        
    }

    public double getStartTime(){
        return startTime;
    }

    
    public void setDuration(int durationHour, int durationMinute){
        duration = durationHour + roundFifteen(durationMinute);
    }

    public double getDuration(){
        return duration;
    }

    public void setDate(int year, int month, int day) throws Exception{
        date = (year*10000) + (month*100) + day;
        if(!isValidDate(date)) {
        	throw new Exception("Date is not valid");
        }
    }

    public int getDate(){
        return date;
    }

    private double roundFifteen(int value){
        return Math.ceil((value/60.0)*4)/4;

    }
    
    // Method to ensure that the inputted integer for date has a valid year, month, and day within the month.
    protected boolean isValidDate(int date) {
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

    public String getTaskDetails(){
        String details = "Task name: " + name 
        + "\nStart time: " + startTime + 
        "\nDuration: " + duration + 
        "\nDate: " + date;

        return details;

    }
}

// exception for if the task is not initalized
class TaskNotCreatedEexcption extends Exception{
    public TaskNotCreatedEexcption(String errorMessage){
        super(errorMessage);

    }
}