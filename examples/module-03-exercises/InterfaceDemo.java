public class InterfaceDemo {
    public static void main(String[] args) {
        // TODO: Printable reference to new Customer("C101", "Aman Singh")
        Printable printable = new Customer("c129837", "Donald Duck");

        printable.printDetails();
    }
}
class Customer implements Printable {
    private final String id;
    private final String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void printDetails() {
        // TODO: printf "Customer %s: %s%n" with id and name
        System.out.printf(name, id, name);
    }
}
 interface Printable {
// TODO: declare void printDetails() (public abstract by default in an interface)
void printDetails();
}