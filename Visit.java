public class Visit extends TransientTask {
    private TypeCategory typeCategory;

    Visit(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        super (name, typeCategory, startTime, duration, date);
       
    }

    Visit(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, TransientTask.TypeCategory typeCategory){
        super(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, typeCategory);
    }
}