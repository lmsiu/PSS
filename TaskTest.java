public class TaskTest{

public static void main(String[] args)
    {
        Task task = new Task();

        task.setStartTime(12.10);
        System.out.println(task.getStartTime());

        task.setStartTime(12);
        System.out.println(task.getStartTime());

        task.setStartTime(24);
        System.out.println(task.getStartTime());
    }

}
