import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class setDemo {
    public static void main(String[] args) {
        // TODO: create HashSet<String> categories
        Set<String> categories = new HashSet<>();

        // TODO: add "Java" and print whether the set changed (add returns boolean)
        categories.add("Java");
        System.out.println(
                "Added Java first time: "
                        );

        // TODO: add "Testing" and "Databases"
        System.out.println(categories.add("Testing"));
        categories.add("Databases");

        // TODO: try adding "Java" again — print whether the set changed
        System.out.println(categories.add("Java"));
        System.out.println(
                "Added Java second time: "
                        );

        System.out.println(
                "Unique count: " + categories.size());
        System.out.println(
                "Contains Testing: "
                        );

        // TODO: print sorted view using new TreeSet<>(categories)
        Set<String> sortedCategories = new TreeSet<>(categories);
        System.out.println(
                "Sorted view: "
                        + sortedCategories);
        System.out.println(sortedCategories.subSet("Databases", "Java"));
        sortedCategories.remove("Java");
        System.out.println(
                "Sorted view: "
                        + sortedCategories);
    }
}