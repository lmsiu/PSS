public class Task {
    private String name;
    private TypeCategory typeCategory;
    private double startTime;
    private double duration;
    private int date;

    Task(){
        //empty constructor 
    }

    Task(String name, TypeCategory typeCategory, int startTimeMinute, int startTimeHour, boolean AM, float duration, int date) {
        this.name = name;
        this.typeCategory = typeCategory;
        this.duration = duration;
        this.date = date;
        setStartTime(startTimeHour, startTimeMinute, AM);
        
    }

    // Constructor to pass in exact values however this should be removed later
    Task(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        this.name = name;
        this.typeCategory = typeCategory;
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

    public void setTypeCategory(TypeCategory typeCategory){
        this.typeCategory = typeCategory;

    }

    public TypeCategory getTypeCategory(){
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

    
    public void setDuration(double duration){
        this.duration = duration;
    }

    public double getDuration(){
        return duration;
    }

    public void setDate(int date){
        this.date = date;
    }

    public int getDate(){
        return date;
    }

    private double roundFifteen(int value){
        return Math.ceil((value/60.0)*4)/4;

    }
}

enum TypeCategory{
    RECURRING,
    TRANSIENT,
    ANTITASK,
}

// exception for if the task is not initalized
class TaskNotCreatedEexcption extends Exception{
    public TaskNotCreatedEexcption(String errorMessage){
        super(errorMessage);

    }
}