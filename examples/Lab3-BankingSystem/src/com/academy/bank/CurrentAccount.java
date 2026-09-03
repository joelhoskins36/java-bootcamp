package com.academy.bank;

public class CurrentAccount extends Account implements Printable {

    private double transactionFee;
    protected CurrentAccount(String accountNumber, double balance, Customer customer,double transactionFee){
        super(accountNumber, balance, customer);
        this.transactionFee=transactionFee;
    }
    @Override
    public double calculateCharges() {
        return transactionFee;
    }
    @Override
    public void displayAccount() {
        System.out.printf(
                "Type: %s%nAccount Number: %s%nCustomer: %s%nBalance: %.2f%nTransaction Fee: %.2f%n",
                getAccountType(),
                getAccountNumber(),
                getCustomer().getName(),
                getBalance(),
                transactionFee
        );
    }
    @Override
    public String getAccountType() {
        return "Current";
    }
    @Override
    public void printDetails() {
        displayAccount();
    }
}