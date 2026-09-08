public class exer2 {
    static class Person {
        final String name;

        Person(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Person first = new Person("Aman"); // create + reference
        // TODO: Person alias = first;  (second reference, same object)
        Person alias = first;

        System.out.println(
                "Same object: " + (first == alias));

        first=null;
        System.out.println(
                "Still reachable through alias: " + alias.name);

        alias=null;
        System.out.println(
                "No strong references remain; object is GC-eligible.");

        System.gc();
        System.out.println("GC requested, not guaranteed.");
    }
}