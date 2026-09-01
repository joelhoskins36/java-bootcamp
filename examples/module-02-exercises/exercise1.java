import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First number: ");
        double a =Double.parseDouble(scanner.nextLine());

        System.out.print("Second number: ");
        double b =Double.parseDouble(scanner.nextLine());
        System.out.println(a);
        // TODO: print Sum, Difference, Product, and Quotient using printf with %.2f
        // System.out.printf("Sum: %.2f%n", _____);
        // System.out.printf("Difference: %.2f%n", _____);
        // System.out.printf("Product: %.2f%n", _____);
        // System.out.printf("Quotient: %.2f%n", _____);

        scanner.close();
    }
}