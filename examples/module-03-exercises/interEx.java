public class interEx {
    public static void main(String[] var0) {
    Circle circle = new Circle();
    circle.draw();
    }
}
interface Drawable{
    void draw();
    default void info(){
        System.out.println("Drawable");
    }
    int SIZE=100;
}
class Circle implements Drawable{
    public void draw(){
        System.out.println("Drawing circle");
    }

}
