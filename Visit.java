public class Visit extends TransientTask {
    private TypeCategory typeCategory;

    Visit(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        super (name, typeCategory, startTime, duration, date);
       
    }
}