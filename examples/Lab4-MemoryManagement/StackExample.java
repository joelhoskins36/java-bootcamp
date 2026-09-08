public class StackExample {

    public static void main(String[] args) {
        int age = 20;
        String name = "Donkey";
        Person person = new Person(name, age);

        System.out.println("===== Stack Memory Demonstration =====");
        System.out.println("Call chain: main() -> methodA() -> methodB() -> methodC()");
        System.out.println();

        System.out.println("main() frame");
        System.out.println("  Primitive on stack : age = " + age);
        System.out.println("  Reference on stack : name = " + name);
        System.out.println("  Person reference   : " + person);

        methodA(person);

        System.out.println();
        System.out.println("Back in main() - methodC() frame has been removed from the stack.");
    }

    static void methodA(Person person) {
        // TODO
            int valueA = 10;

            System.out.println();
            System.out.println("methodA() frame");
            System.out.println("  Primitive on stack : valueA = " + valueA);
            System.out.println("  Person reference   : " + person);

            methodB(person);
    }

    static void methodB(Person person) {
        // TODO
        int valueB = 20;

        System.out.println();
        System.out.println("methodB() frame");
        System.out.println("  Primitive on stack : valueB = " + valueB);
        System.out.println("  Person reference   : " + person);

        methodC(person);
    }

    static void methodC(Person person) {
        // TODO
        int valueC = 30;

        System.out.println();
        System.out.println("methodC() frame");
        System.out.println("  Primitive on stack : valueC = " + valueC);
        System.out.println("  Person reference   : " + person);
        System.out.println("  identityHashCode    : " + System.identityHashCode(person));
    }
}