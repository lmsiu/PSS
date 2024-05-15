package Tasks;
public class Controller {
    private Model model;

    public Controller(Model model){
        this.model = model;

    }

    // Transient Task
    public Exception createTransientTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, TransientTask.TypeCategory typeCategory){

        // returns the exception so it can be printed to the screen if something goes wrong
        try {
            TransientTask newTask = new TransientTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, typeCategory);
            model.createTask(newTask);
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
        return null;
    }


    // Recurring Task
    public Exception createRecurringTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, int startDate, int endDate, int frequency, RecurringTask.TaskType taskType){

        try {
            RecurringTask newTask = new RecurringTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, startDate, endDate, frequency, taskType);
            model.createTask(newTask);
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }

        return null;
    }

    // Anti Task
    public Exception createAntiTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay){

        // returns the exception so it can be printed to the screen if something goes wrong
        try {
            AntiTask newTask = new AntiTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay);
            model.createTask(newTask);
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
        return null;
    }


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

    // Edit tasks
    //Recurring
    public Exception editRecurringTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, int startDate, int endDate, int frequency, RecurringTask.TaskType taskType){
        RecurringTask newTask = new RecurringTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, startDate, endDate, frequency, taskType);
        try {
            model.editTask(newTask);
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
        return null;
    }

    // Transient Task
    public Exception editTransientTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, TransientTask.TypeCategory typeCategory){

        // returns the exception so it can be printed to the screen if something goes wrong
        try {
            TransientTask newTask = new TransientTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, typeCategory);
            model.editTask(newTask);
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
        return null;
    }
    

    // Search for a task
    public Task searchTask(String taskName){
       return model.findTask(taskName);
    }
}
