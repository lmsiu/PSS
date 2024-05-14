import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Viewer {
    // To access all the task from the taskList from Model class
    private Model model;
    private LinkedList<Task> taskList;
    
    public Viewer(Model model) {
        this.model = model;
        this.taskList = model.returnTaskList();
    }

    // List all of the tasks, sorted by date and time
    public void displayAllSchedule() {
        
        // Sort the taskList by date and time
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                // Compare tasks based on date
                int dateComparison = Integer.compare(task1.getDate(), task2.getDate());
                if (dateComparison != 0) {
                    return dateComparison;
                }
                
                // If dates are equal, compare based on time
                return Double.compare(task1.getStartTime(), task2.getStartTime());
            }
        });

        // Display sorted tasks
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    // Display tasks for a specific day
    public void displayDaySchedule(int targetDate) {
        System.out.println("Schedule for date: " + targetDate);
        for (Task task : taskList) {
            if (task.getDate() == targetDate) {
                System.out.println(task);
            }
        }
    }

    // Display tasks for a specific week
    public void displayWeekSchedule(int targetWeek) {
        System.out.println("Schedule for week: " + targetWeek);
        for (Task task : taskList) {
            if (isTaskInWeek(task, targetWeek)) {
                System.out.println(task);
            }
        }
    }
    // Check if each task falls within the specified week 
    private boolean isTaskInWeek(Task task, int targetWeek) {
        return task.getWeek() == targetWeek;
    }

    // Display tasks for a specific month
    public void displayMonthSchedule(int targetMonth) {
        System.out.println("Schedule for month: " + targetMonth);
        for (Task task : taskList) {
            if (isTaskInMonth(task, targetMonth)) {
                 System.out.println(task);
            }
        }
    }
    // Check if each task falls within the specified month
    private boolean isTaskInMonth(Task task, int targetMonth) {
        // Assuming Task has a method getMonthOfYear() to get the month number
        return task.getMonth() == targetMonth;
    }

}
