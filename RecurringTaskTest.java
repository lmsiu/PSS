public class RecurringTaskTest {
    public static void main(String[] args)
    {
        RecurringTask task  = new RecurringTask("Eat Food", RecurringTask.TaskType.MEAL, 0, 0, null, 0, 0, 0);

        System.out.println(task instanceof RecurringTask);
    }
    
}
