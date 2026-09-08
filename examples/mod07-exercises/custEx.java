public class custEx {
    public static void main(String[] args) {
        Account account = new Account(100.00);

        try {
            account.withdraw(150.00);

        } catch (InsufficientFundsException ex) {
            System.out.println(ex.getMessage());

            System.out.printf("Shortfall: %.2f%n",
                    ex.getRequested() - ex.getBalance());
        }

        // Failed withdrawal must leave the original balance unchanged.
        System.out.printf("Balance unchanged: %.2f%n",
                account.getBalance());
    }
}

class InsufficientFundsException extends Exception {

    private final double balance;
    private final double requested;

    public InsufficientFundsException(
            double balance, double requested) {

        super(String.format(
                "Insufficient funds: balance=%.2f, requested=%.2f",
                balance, requested));

        this.balance = balance;
        this.requested = requested;
    }

    public double getBalance() {
        return balance;
    }

    public double getRequested() {
        return requested;
    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount)
            throws InsufficientFundsException {

        // Validate before mutating state.
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}