public class Visit extends TransientTask {
    private String typeCategory;

    Visit(String name, String typeCategory, float startTime, float duration, int date) {
        super (name, typeCategory, startTime, duration, date);
       
    }
}