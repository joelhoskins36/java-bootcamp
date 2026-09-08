
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Employee{
    public int age;
    public String name;
    Employee(int age, String name){
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return age;
    }
}
public class streamEx {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 10, 3);
        List<Employee> employees = (new Employee(21,"Mark"),new Employee(40,"Cheryl"),new Employee(19,"Swen"));
        List<Employee> filtered= employees.stream();
            .filter(e -> e.getAge()>=21)
                .collect(Collectors.toList());


        System.out.println("Original numbers:");
        System.out.println(numbers);

        System.out.println("\nNumbers greater than 5:");

        numbers.stream()
                .filter(number -> number > 5)
                .forEach(System.out::println);

        System.out.println("\nNumbers doubled:");

        numbers.stream()
                .map(number -> number * 2)
                .forEach(System.out::println);

        System.out.println("\nSorted numbers:");

        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        List<Integer> smallNumbers = numbers.stream()
                .filter(number -> number < 6)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nNumbers less than 6, sorted:");
        System.out.println(smallNumbers);
    }
}

