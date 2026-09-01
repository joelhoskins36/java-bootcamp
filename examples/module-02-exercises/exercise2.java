import java.util.Scanner;   // Scanner lives in java.util — must import it

public class exercise2 {
    public static void main(String[] args) {
        // TODO: create a Scanner reading from System.in
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        // TODO: print a greeting with printf — %s for strings, %d for age, %n for newline
        // System.out.printf("Hello, %s! You are %d years old and live in %s.%n",
        //         name, age, city);
        System.out.printf(
                "Hello, %s! You are %d years old and live in %s.%n",
                name, age, city
        );
        scanner.close();
    }
}