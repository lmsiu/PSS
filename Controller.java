public class Controller {
    private Model model;

    Controller(Model model){
        this.model = model;

    }

    // Transient Task
    public boolean createAppointment(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay) {

        Appointment newAppt = new Appointment(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, TransientTask.TypeCategory.APPOINTMENT);
        try {
            model.createTask(newAppt);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean createShopping(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay){

        Shopping newShopping = new Shopping(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, TransientTask.TypeCategory.SHOPPING);
        try {
            model.createTask(newShopping);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean createVisit(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay){

        Visit newVisit = new Visit(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, TransientTask.TypeCategory.VISIT);

        try {
            model.createTask(newVisit);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    // Recurring Task

    // Anti Task

    // Delete Task
    public boolean deleteTask(String taskName){
        try {
            model.deleteTask(taskName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    // Edit task
    public boolean editRecurringTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, String type, int startDate, int endDate, int frequency, String typeString){
        RecurringTask newTask = new RecurringTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, type, startDate, endDate, frequency, typeString);
        try {
            model.editTask(newTask);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Search for a task
    public Task searchTask(String taskName){
       return model.findTask(taskName);
    }
}
