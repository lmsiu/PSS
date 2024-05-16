package Tasks;

import java.util.LinkedList;
import java.util.List;

import Tasks.Task;

public class AntiTask extends Task {
    private Model model;

    public AntiTask(String name, double startTime, double duration, int date) {
        super(name, startTime, duration, date);  
    }

    public AntiTask(String name,  int startTimeMinute, int startTimeHour, boolean AM, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay) throws Exception{
        super(name, startTimeMinute, startTimeHour, AM, durationHour, durationMinutes, dateYear, dateMonth, dateDay);
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
    public boolean isAntiTask(Task task) {
        return task instanceof AntiTask;
    }

    /**
     * Checks if a given recurring task has been canceled by an anti-task.
     * 
     * @param recurringTask The recurring task to check for cancellation
     * @return true if the recurring task has been canceled by an anti-task, false otherwise
     */
    public boolean hasCorrespondingAntiTask(Task task) {
        if (task instanceof RecurringTask) {
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
 * Checks if a specific anti-task corresponds to a specific recurring task.
 * 
 * @param recurringTask The recurring task to check against
 * @param antiTask      The specific anti-task to check
 * @return true if the specific anti-task corresponds to the specific recurring task, false otherwise
 */
private boolean correspondsToAntiTask(RecurringTask recurringTask, Task antiTask) {
    return antiTask.getStartTime() == recurringTask.getStartTime() &&
           antiTask.getDate() == recurringTask.getDate() &&
           antiTask.getDuration() == recurringTask.getDuration();
}


    /**
     * Checks if deleting the anti-task would cause conflicts with existing recurring tasks.
     * 
     * @param model The model containing the task list
     * @return true if deleting the anti-task would cause conflicts, false otherwise
     */
    public boolean hasConflictsAfterDeletion(Model model) {
        double antiTaskStartTime = this.getStartTime();
        double antiTaskEndTime = antiTaskStartTime + this.getDuration();

        for (Task task : model.returnTaskList()) {
            if (task instanceof RecurringTask) {
                RecurringTask recurringTask = (RecurringTask) task;
                if ((antiTaskStartTime >= recurringTask.getStartTime() && antiTaskStartTime < (recurringTask.getStartTime() + recurringTask.getDuration())) ||
                    (recurringTask.getStartTime() >= antiTaskStartTime && recurringTask.getStartTime() < antiTaskEndTime)) {
                    return true; // Conflicts found due to overlapping tasks
                }
            }
        }
        return false; // No conflicts found
    }

    /**
     * Checks if this instance of anti-task corresponds to a given recurring task.
     * 
     * @param recurringTask The recurring task to check against
     * @return true if this instance of anti-task corresponds to the given recurring task, false otherwise
     */
public boolean correspondsToRecurringTask(RecurringTask recurringTask) {
    return this.getStartTime() == recurringTask.getStartTime() &&
           this.getDate() == recurringTask.getDate() &&
           this.getDuration() == recurringTask.getDuration();
}
// Helper method to find the corresponding recurring task
public static RecurringTask findCorrespondingRecurringTask(Model model, int startTimeHour, int startTimeMinute, int durationHour, int durationMinutes, int dateYear, int dateMonth, int dateDay) {
    for (Task task : model.returnTaskList()) {
        if (task instanceof RecurringTask) {
            RecurringTask recurringTask = (RecurringTask) task;
            AntiTask antiTask = null;
			try {
				antiTask = new AntiTask("", startTimeMinute, startTimeHour, false, durationHour, durationMinutes, dateYear, dateMonth, dateDay);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if (antiTask.correspondsToRecurringTask(recurringTask)) {
                return recurringTask; // Found corresponding recurring task
            }
        }
    }
    return null; // Corresponding recurring task not found
}
}

