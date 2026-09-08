import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

    public static void main(String[] args) {

        System.out.println("===== Weak Reference Demonstration =====");

        // -----------------------------------------
        // Strong Reference
        // -----------------------------------------

        System.out.println("--- Strong Reference ---");

        Person strongPerson = new Person("Donkey", 20);

        System.out.println("Before GC : " + strongPerson);

        MemoryMonitor.triggerGarbageCollection();

        System.out.println("After GC  : " + strongPerson);

        System.out.println(
                "Object remains because a strong reference still exists."
        );


        // -----------------------------------------
        // Weak Reference
        // -----------------------------------------

        System.out.println();
        System.out.println("--- Weak Reference ---");

        Person weakPerson = new Person("Shrek", 30);

        WeakReference<Person> weakReference =
                new WeakReference<>(weakPerson);

        System.out.println(
                "Before removing strong reference : "
                        + weakReference.get()
        );

        // Remove the strong reference
        weakPerson = null;

        System.out.println("Strong reference removed.");

        // Ask JVM to perform garbage collection
        MemoryMonitor.triggerGarbageCollection();

        System.out.println(
                "After GC via WeakReference.get() : "
                        + weakReference.get()
        );

        System.out.println();
        System.out.println("Observation:");
        System.out.println(
                "- WeakReference does not prevent garbage collection."
        );
        System.out.println(
                "- When only the weak reference remains, "
                        + "the Person may be collected."
        );
    }
}