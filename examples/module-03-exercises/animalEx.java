abstract class Animal{
    String name;
    void eat(){
        System.out.println(name+" is eating...");
    }
    Animal(String name){
        this.name = name;
    }
    abstract void sound();

}
class Cat extends Animal{
    Cat(String name){
        super(name);
    }
    void sound(){
        System.out.println(name+" is meowing!");
    }

}
class Dog extends Animal{
    Dog(String name) {
        super(name);
    }
    void sound(){
        System.out.println(name+ " is barking!");
    }
    @Override
    void eat(){
        System.out.println(name+" Is wolfing it down");
    }
}


public class animalEx {
    public animalEx() {
    }

    public static void main(String[] var0) {
    Dog dog1 = new Dog("Fido");
    Cat cat1 = new Cat("Lucy");
    dog1.eat();
    dog1.sound();
    cat1.sound();
    }
}
