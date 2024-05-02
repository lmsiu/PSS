import java.util.LinkedList;
import java.util.List;

public class AntiTask extends Task {
    private Model model;
    public AntiTask(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        super(name, typeCategory, startTime, duration, date);  
    }

    /**
     * Filters out anti-tasks and their corresponding recurring task instances from the provided schedule.
     * 
     * @param schedule The schedule to be filtered
     * @return The filtered schedule without anti-tasks and their corresponding recurring task instances
     */
    public LinkedList<Task> filterAntiTasks(LinkedList<Task> schedule) {
        LinkedList<Task> filteredSchedule = new LinkedList<>();
        for (Task task : schedule) {
            if (!isAntiTask(task) && !hasCorrespondingAntiTask(task)) {
                filteredSchedule.add(task);
            }
        }
        return filteredSchedule;
    }

    // Method to check if a task is an anti-task
    private boolean isAntiTask(Task task) {
        return task.getTypeCategory() == TypeCategory.ANTITASK && task instanceof AntiTask;
    }

    /**
     * Checks if a given recurring task has been canceled by an anti-task.
     * 
     * @param recurringTask The recurring task to check for cancellation
     * @return true if the recurring task has been canceled by an anti-task, false otherwise
     */
    private boolean hasCorrespondingAntiTask(Task task) {
        if (task.getTypeCategory() == TypeCategory.RECURRING && task instanceof RecurringTask) {
            RecurringTask recurringTask = (RecurringTask) task;
            for (Task antiTask : model.returnTaskList()) {
                if (isAntiTask(antiTask) && correspondsToAntiTask(recurringTask, antiTask)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if an anti-task corresponds to a recurring task.
     * 
     * @param recurringTask The recurring task to check against
     * @param antiTask      The anti-task to check
     * @return true if the anti-task corresponds to the recurring task, false otherwise
     */
    private boolean correspondsToAntiTask(RecurringTask recurringTask, Task antiTask){
        return antiTask.getStartTime() == recurringTask.getStartTime() &&
        antiTask.getDate() == recurringTask.getDate() &&
        antiTask.getDuration() == recurringTask.getDuration();

    }


}
