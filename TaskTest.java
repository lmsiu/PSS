public class TaskTest{

public static void main(String[] args)
    {
        Task task = new Task();

        double testStartTime = 12.10;

        task.setStartTime(testStartTime);
        System.out.println(task.getStartTime());
    }

}
