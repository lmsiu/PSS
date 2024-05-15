public class Appointment extends TransientTask {
    private TypeCategory typeCategory;

    Appointment(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        super (name, typeCategory, startTime, duration, date);
       
    }

    Appointment(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, TypeCategory typeCategory){
        super(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, typeCategory);
    }
}