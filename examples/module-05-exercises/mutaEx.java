import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
public class mutaEx {

    public static void main(String[] args) {
        // Primitive value belongs to main's frame
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
        String s1="Hello";
        String s2=s1.concat(" world");
        System.out.println(s2);
        //list iterator
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        ListIterator<String> it = names.listIterator();

        while (it.hasNext()) {
            String name = it.next();
            System.out.println(name);
            if (name.equals("Bob")){
                it.remove();
                System.out.println("Name removed");
            }

        //list iterator bidirectional
    }
        System.out.println("Done with first go. Lets see it again");

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }


}
}