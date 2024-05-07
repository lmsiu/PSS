public class Study extends RecurringTask{

    private String type;

    Study(String taskName,String typeCat, double startTime, double duration, String type, int startDate, int endDate, int frequency){
        super (taskName, typeCat, startTime, duration, type, startDate, endDate, frequency);
    }
}