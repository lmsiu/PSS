public class Appointment extends TransientTask {
    private TypeCategory typeCategory;

    Appointment(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        super (name, typeCategory, startTime, duration, date);
       
    }
}