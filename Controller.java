public class Controller {
    // Transient Task
    public boolean createAppointment(String name, TransientTask.TypeCategory typeCategory, float startTime, float duration, int date){

        Appointment newAppt = new Appointment(name, typeCategory, startTime, duration, date);
        return true;

    }

    // Recurring Task

    // Anti Task
}
