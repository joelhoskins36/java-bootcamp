import java.util.HashMap;
import java.util.Map;

public class hashMap {
    public static void main(String[] args) {

        Map<String, Integer> ages = new HashMap<>();

        // Add key/value pairs
        ages.put("Donkey", 20);
        ages.put("Shrek", 30);
        ages.put("Fiona", 25);

        // Get a value using its key
        System.out.println("Donkey's age: " + ages.get("Donkey"));

        // Check if a key exists
        System.out.println("Contains Shrek: " + ages.containsKey("Shrek"));

        // Check if a value exists
        System.out.println("Contains age 25: " + ages.containsValue(25));

        // Number of key/value pairs
        System.out.println("Size: " + ages.size());

        // Print the whole map
        System.out.println("Ages: " + ages);

        // Remove a key/value pair
        ages.remove("Shrek");

        System.out.println("After removing Shrek: " + ages);
    }
}