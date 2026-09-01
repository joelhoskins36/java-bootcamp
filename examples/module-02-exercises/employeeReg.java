import java.util.Scanner;

public class employeeReg {
    int age;
    int salary;
    String name;
    int id=99999;
    public employeeReg(String name, int age, int salary) {
        this.name=name;
        this.age=age;
        this.salary=salary;
        id=id-1;
    }
    public void taxes(){
        double tax=salary*(.15);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your name");
        String name =String.parseString(scanner.nextLine());
        System.out.print("Enter your age: ");
        double a =Double.parseDouble(scanner.nextLine());
        System.out.print("Enter your salary: ");
        double a =Double.parseDouble(scanner.nextLine());
        scanner.close();
    }
}