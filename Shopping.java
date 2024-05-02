public class Shopping extends TransientTask {
    private TypeCategory typeCategory;

    Shopping(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        super (name, typeCategory, startTime, duration, date);
       
    }
}