import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDemo {

    // Long-lived static list.
    // Objects added here remain reachable until the list is cleared.
    private static final List<Employee> employees = new ArrayList<>();

    static class Employee {
        private String name;
        private byte[] data;

        Employee(String name) {
            this.name = name;
            this.data = new byte[1024];
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "'}";
        }
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java MemoryLeakDemo leak");
            System.out.println("   or: java MemoryLeakDemo fix");
            return;
        }

        if (args[0].equalsIgnoreCase("leak")) {
            runLeak();
        } else if (args[0].equalsIgnoreCase("fix")) {
            runFix();
        } else {
            System.out.println("Usage: java MemoryLeakDemo leak");
            System.out.println("   or: java MemoryLeakDemo fix");
        }
    }

    private static void runLeak() {

        System.out.println("===== Memory Leak Demonstration =====");
        System.out.println(
                "Adding employees to a static list that is never cleared..."
        );

        MemoryMonitor.printMemoryReport("Before allocation");

        int count = 0;

        while (true) {

            // Add 100,000 employees
            for (int i = 0; i < 100_000; i++) {
                employees.add(new Employee("Employee-" + (count + i)));
            }

            count += 100_000;

            System.out.println();
            System.out.println("Added " + count + " employees");

            MemoryMonitor.printMemoryReport(
                    "After " + count + " Objects"
            );
        }
    }

    private static void runFix() {

        System.out.println("===== Memory Leak Fix Demonstration =====");

        System.out.println("Creating a local list of employees...");

        List<Employee> localEmployees = new ArrayList<>();

        MemoryMonitor.printMemoryReport("Before allocation");

        // Allocate a batch of employees
        for (int i = 0; i < 100_000; i++) {
            localEmployees.add(new Employee("Employee-" + i));
        }

        System.out.println("Added 100000 employees");

        MemoryMonitor.printMemoryReport("After allocation");

        System.out.println();
        System.out.println("Clearing list to remove strong references...");

        localEmployees.clear();

        System.out.println("Nulling list reference...");
        localEmployees = null;

        System.out.println("Triggering Garbage Collection...");

        MemoryMonitor.triggerGarbageCollection();

        MemoryMonitor.printMemoryReport("After GC");

        System.out.println();
        System.out.println("Observation:");
        System.out.println("- Clearing the list removes references to the Employee objects.");
        System.out.println("- The objects become eligible for garbage collection.");
        System.out.println("- Used memory may drop after GC.");
    }
}