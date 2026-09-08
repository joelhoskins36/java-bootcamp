public class HeapExample {

    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "'}";
        }
    }

    static class Employee {
        String name;

        Employee(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "'}";
        }
    }

    static class Customer {
        String name;

        Customer(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Customer{name='" + name + "'}";
        }
    }

    static class Book {
        String title;

        Book(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Book{title='" + title + "'}";
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Heap Memory Demonstration =====");

        // 1. Memory before allocation
        MemoryMonitor.printMemoryReport("Before allocation");

        // 2. Create objects
        Student student = new Student("Aman");
        Employee employee = new Employee("John");
        Customer customer = new Customer("Sarah");
        Book book = new Book("Java Fundamentals");

        // 3. Print references, object text, and identity hash codes
        System.out.println();
        System.out.println("Objects created:");

        System.out.println("student  -> " + student
                + " | identityHashCode=" + System.identityHashCode(student));

        System.out.println("employee -> " + employee
                + " | identityHashCode=" + System.identityHashCode(employee));

        System.out.println("customer -> " + customer
                + " | identityHashCode=" + System.identityHashCode(customer));

        System.out.println("book     -> " + book
                + " | identityHashCode=" + System.identityHashCode(book));

        // 4. Memory after allocation
        System.out.println();
        MemoryMonitor.printMemoryReport("After allocation");
    }
}