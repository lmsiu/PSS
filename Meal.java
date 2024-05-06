public class Meal extends RecurringTask{
    private String type;

    Meal(String taskName,String typeCat, double startTime, double duration, String type, int startDate, int endDate, int frequency){
        super (taskName, typeCat, startTime, duration, type, startDate, endDate, frequency);
    }
}