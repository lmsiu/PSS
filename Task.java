public class Task {
    private String name;
    private TypeCategory typeCategory;
    private double startTime;
    private double duration;
    private int date;

    Task(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        this.name = name;
        this.typeCategory = typeCategory;
        this.startTime = startTime;
        this.duration = duration;
        this.date = date;
        
    }

    Task(){
        //empty constructor 
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

    public void setStartTime(double startTime){

        // add try catch for if it dosent work
        try {
            if(startTime >= 0 && startTime <= 23.75){
                // round to the nearest 15 minutes
    
                double temp = startTime/0.15;
    
                int fifteens = (int) temp;
                startTime = fifteens*0.15;
    
                this.startTime = startTime;
            }else{
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