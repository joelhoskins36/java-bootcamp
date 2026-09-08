public class ObjectLifecycle {

    public static void main(String[] args) {

        System.out.println("===== Object Lifecycle Demonstration =====");

        // 1. Create a Person
        Person person1 = new Person("Donkey", 20);

        System.out.println("\n1. Person created");
        System.out.println("person1: " + person1);
        System.out.println("identityHashCode: "
                + System.identityHashCode(person1));

        // 2. Use getters
        System.out.println("\n2. Using getters");
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());

        // 3. Create an alias
        Person person2 = person1;

        System.out.println("\n3. Second reference created (alias)");
        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);

        System.out.println("person1 identityHashCode: "
                + System.identityHashCode(person1));
        System.out.println("person2 identityHashCode: "
                + System.identityHashCode(person2));

        // Memory before making object unreachable
        MemoryMonitor.printMemoryReport("Before nulling references");

        // 4. Set both references to null
        person1 = null;
        person2 = null;

        System.out.println("\n4. Both references set to null");
        System.out.println("Person object is now eligible for garbage collection.");

        // Memory after references are removed
        MemoryMonitor.printMemoryReport("Before GC");

        // 5. Request garbage collection
        System.out.println("\n5. Requesting garbage collection...");
        MemoryMonitor.triggerGarbageCollection();

        MemoryMonitor.printMemoryReport("After GC");
    }
}