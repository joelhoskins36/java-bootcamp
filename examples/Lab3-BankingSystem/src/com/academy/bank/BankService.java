package com.academy.bank;

import java.util.Scanner;

public class BankService {

    private static final int MAX_CUSTOMERS = 50;
    private static final int MAX_ACCOUNTS = 100;
    private static final int MAX_TRANSACTIONS = 500;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private final Account[] accounts = new Account[MAX_ACCOUNTS];
    private final Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];

    private int customerCount = 0;
    private int accountCount = 0;
    private int transactionCount = 0;

    private int nextAccountNumber = 10001;
    private int nextTransactionNumber = 1;

    private final Scanner scanner;

    public BankService(Scanner scanner) {
        this.scanner = scanner;
    }
    public void createCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        // Check for duplicate ID
        if (findCustomer(id) != null) {
            System.out.println("Customer ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(id, name, email, phone);

        customers[customerCount++] = customer;

        System.out.println("Customer Created Successfully.");
    }
    private Customer findCustomer(int id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId() == id) {
                return customers[i];
            }
        }

        return null;
    }
    private Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }

        return null;
    }
    private Customer readExistingCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Customer customer = findCustomer(id);

        if (customer == null) {
            System.out.println("Customer not found.");
        }

        return customer;
    }
    public void deposit() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = readPositiveAmount("Enter Deposit Amount: ");

        account.deposit(amount);

        recordTransaction(account, amount, "Deposit");

        System.out.println("Balance Updated : " + account.getBalance());
    }
    public void withdraw() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = readPositiveAmount("Enter Withdrawal Amount: ");

        boolean success = account.withdraw(amount);

        if (!success) {
            System.out.println("Insufficient Funds.");
            return;
        }

        recordTransaction(account, amount, "Withdraw");

        System.out.println("Balance Updated : " + account.getBalance());
    }
    private void recordTransaction(Account account, double amount, String type) {
        Transaction transaction = new Transaction(
                nextTransactionNumber++,
                amount,
                type,
                "Today",
                account.getAccountNumber()
        );

        transactions[transactionCount++] = transaction;
    }
    public void displayAccounts() {
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccount();
            System.out.println();
        }
    }
    public void displayCustomers() {
        for (int i = 0; i < customerCount; i++) {
            customers[i].display();
            System.out.println();
        }
    }
    private double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount > 0) {
                return amount;
            }

            System.out.println("Amount must be greater than 0.");
        }
    }
    public void createSavingsAccount() {
        Customer customer = readExistingCustomer();

        if (customer == null) {
            return;
        }

        double balance = readPositiveAmount("Enter Initial Balance: ");

        System.out.print("Enter Interest Rate: ");
        double interestRate = Double.parseDouble(scanner.nextLine());

        String accountNumber = String.valueOf(nextAccountNumber++);

        SavingsAccount account =
                new SavingsAccount(accountNumber, balance, customer, interestRate);

        accounts[accountCount++] = account;

        System.out.println("Savings Account Created.");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance : " + balance);
        System.out.println("Interest Rate : " + interestRate + "%");
    }
    public void createCurrentAccount() {
        Customer customer = readExistingCustomer();

        if (customer == null) {
            return;
        }

        double balance = readPositiveAmount("Enter Initial Balance: ");
        double transactionFee = readPositiveAmount("Enter Transaction Fee: ");

        String accountNumber = String.valueOf(nextAccountNumber++);

        CurrentAccount account =
                new CurrentAccount(accountNumber, balance, customer, transactionFee);

        accounts[accountCount++] = account;

        System.out.println("Current Account Created.");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance : " + balance);
        System.out.println("Transaction Fee : " + transactionFee);
    }
}