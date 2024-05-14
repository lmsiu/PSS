public class Appointment extends TransientTask {
    private String typeCategory;

    Appointment(String name, String typeCategory, float startTime, float duration, int date) {
        super (name, typeCategory, startTime, duration, date);
       
    }
}