class Car{
    private int speed;
    private String name;
    public Car(int speed, String name){
        this.name=name;
        this.speed=speed;
    }
    public Car(){
        this.name="Default";
        this.speed=0;
    }
    void drive(){
        System.out.println("We're going real fast");
        System.out.println("This is how fast: "+ speed);
    }
    int getSpeed(){return speed;}
    String getName(){return name;}
}
public class classEx {

    public static void main(String[] var0) {
        Car car1=new Car();
        Car car2=new Car(1290834,"Ford");
        car2.drive();
        String x=car1.getName();
        System.out.println(x);
    }
}
