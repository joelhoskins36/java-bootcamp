
package com.academy.bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService(scanner);

        while (true) {

            System.out.println("===== Banking System =====");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Savings Account");
            System.out.println("3. Create Current Account");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choiceInput = scanner.nextLine().trim();

            if (choiceInput.isEmpty()) {
                System.out.println("Invalid Input");
                System.out.println("Please Try Again.");
                continue;
            }

            int choice;

            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input");
                System.out.println("Please Try Again.");
                continue;
            }

            switch (choice) {

                case 1:
                    bankService.createCustomer();
                    break;

                case 2:
                    bankService.createSavingsAccount();
                    break;

                case 3:
                    bankService.createCurrentAccount();
                    break;

                case 4:
                    System.out.println("Thank You");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Input");
                    System.out.println("Please Try Again.");
            }

            System.out.println();
        }
    }
}

