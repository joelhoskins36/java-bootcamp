package com.academy.bank;

public class Transaction {

    private int transactionId;
    private double amount;
    private String type;
    private String date;
    private String accountNumber;
    public Transaction(int transactionId, double amount, String type, String date, String accountNumber) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.accountNumber = accountNumber;
    }
    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void display() {
        System.out.printf(
                "%-8d %-12s %-10.2f %-15s %-15s%n",
                transactionId,
                type,
                amount,
                date,
                accountNumber
        );
    }
}