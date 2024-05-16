package Tasks;

import Tasks.RecurringTask.TaskType;

public class RecurringTaskTest {
    public static void main(String[] args) throws Exception
    {
        RecurringTask task = new RecurringTask("Test", 1, 1, false, 1, 2, 2, 2, 2, 2, 2, 2, TaskType.EXERCISE);

        System.out.println(task.getTaskDetails());


    }

}
    

