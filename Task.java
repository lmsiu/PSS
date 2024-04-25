public class Task {
    private String name;
    private TypeCategory typeCategory;
    private float startTime;
    private float duration;
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

    public void setStartTime(float startTime){
        this.startTime = startTime;
    }

    public float getStartTime(){
        return startTime;
    }

    
    public void setDuration(float duration){
        this.duration = duration;
    }

    public float getDuration(){
        return duration;
    }

    public void setDate(int date){
        this.date = date;
    }

    public float getDate(){
        return date;
    }

}

enum TypeCategory{
    RECURRING,
    TRANSIENT,
    ANTITASK,
}