public class Exercise extends RecurringTask{
    private String type;

    public Exercise(String taskName,String typeCat, double startTime, double duration, String type, int startDate, int endDate, int frequency){
        super (taskName, typeCat, startTime, duration, type, startDate, endDate, frequency);
    }
}