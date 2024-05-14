public class Shopping extends TransientTask {
    private String typeCategory;

    Shopping(String name, String typeCategory, float startTime, float duration, int date) {
        super (name, typeCategory, startTime, duration, date);
       
    }
}