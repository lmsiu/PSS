public class TaskTest{

public static void main(String[] args)
    {
        Task task = new Task();

        task.setStartTime(12, 15, true);
        System.out.println(task.getStartTime());

        task.setStartTime(12, 59, true);
        System.out.println(task.getStartTime());

        // should throw an error
        task.setStartTime(24, 60, true);

        task.setDuration(0, 45);
        System.out.println(task.getDuration());

        task.setDuration(24, 20);
        System.out.println(task.getDuration());
        task.setDuration(10, 36);
        System.out.println(task.getDuration());
    }

}
