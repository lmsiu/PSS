package Tasks;
public class Controller {
    private Model model;

    public Controller(Model model){
        this.model = model;

    }

    // Transient Task
    public void createTransientTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, TransientTask.TypeCategory typeCategory) throws Exception{

        // returns the exception so it can be printed to the screen if something goes wrong
            TransientTask newTask = new TransientTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, typeCategory);
            model.createTask(newTask);

    }


    // Recurring Task
    public void createRecurringTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, int startDate, int endDate, int frequency, RecurringTask.TaskType taskType) throws Exception{
            RecurringTask newTask = new RecurringTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, startDate, endDate, frequency, taskType);
            model.createTask(newTask);
    }

 // Create AntiTask method
 public void createAntiTask(String name, int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay) throws Exception {
    RecurringTask correspondingRecurringTask = AntiTask.findCorrespondingRecurringTask(model, startTimeHour, startTimeMinute, durationHour, durationMinutes, dateYear, dateMonth, dateDay);
    if (correspondingRecurringTask == null) {
        throw new Exception("Cannot create anti-task because there is no corresponding recurring task!");
    }
    try {
        AntiTask newTask = new AntiTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay);
        model.createTask(newTask);
    } catch (Exception e) {
        e.printStackTrace();
        throw e;
    }
}
    


    // Delete Task
    public void deleteTask(String taskName) throws Exception{
            model.deleteTask(taskName);
    }

    // Edit tasks
    //Recurring
    public void editRecurringTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, int startDate, int endDate, int frequency, RecurringTask.TaskType taskType) throws Exception{
        RecurringTask newTask = new RecurringTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, startDate, endDate, frequency, taskType);

            model.editTask(newTask);
    }

    // Transient Task
    public void editTransientTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay, TransientTask.TypeCategory typeCategory) throws Exception{

            TransientTask newTask = new TransientTask(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay, typeCategory);
            model.editTask(newTask);

    }
    

    // Search for a task
    public Task searchTask(String taskName){
       return model.findTask(taskName);
    }
}
