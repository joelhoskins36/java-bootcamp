import java.util.LinkedList;
public class linkedList {

    public static void main(String[] args) {
        // Primitive value belongs to main's frame
        LinkedList<String> names = new LinkedList<>();

        names.add("Donkey");
        names.add("Shrek");
        names.add("Fiona");
        names.remove(2);
        System.out.println(names);
    }
}