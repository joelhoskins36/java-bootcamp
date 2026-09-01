
import java.util.Scanner;
public class exercise3 {
    public static void main(String[] args) {
        System.out.println("Times table for 5");
        for(int i=1; i<5;i++){
            System.out.println("5 x "+i+" = "+(5*i));
        }
        int i = 3;
        while(i!=0){
            System.out.println("Countdown: "+i);
            i--;
        }
        Scanner scanner = new Scanner(System.in);
        String name;
        do{
            System.out.print("Type 'menu' to see it again, anything else to quit: ");
            name = scanner.nextLine();
            System.out.println(name);
        }while(name.equals("menu"));
        scanner.close();
    }
}