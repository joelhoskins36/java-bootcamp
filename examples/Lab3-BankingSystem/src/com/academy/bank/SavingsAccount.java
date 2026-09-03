package com.academy.bank;

public class SavingsAccount extends Account implements Printable {
    private double interestRate;
    protected SavingsAccount(String accountNumber, double balance, Customer customer,double interestRate){
        super(accountNumber, balance, customer);
        this.interestRate = interestRate;
    }
    @Override
    public void displayAccount() {
        System.out.printf(
                "Type: %s%nAccount Number: %s%nCustomer: %s%nBalance: %.2f%nInterest Rate: %.2f%%%nInterest: %.2f%n",
                getAccountType(),
                getAccountNumber(),
                getCustomer().getName(),
                getBalance(),
                interestRate,
                calculateInterest()
        );
    }
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100.0;
    }
    @Override
    public void printDetails() {
        displayAccount();
    }
    @Override
    public String getAccountType() {
        return "Savings";
    }
}