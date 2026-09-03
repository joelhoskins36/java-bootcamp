public class Account {
    // TODO: hide balance from outside code (private field)
    double balance;
    private int accountNum;
    protected double interestRate;
    public String bankName;

    public Account(int accountNum, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative");
        }
        balance = initialBalance;
        bankName="trusted bank";
        interestRate=4.5;
        this.accountNum=accountNum;
    }

    public void deposit(double amount) {
        // TODO: reject non-positive amounts (print message, return early)
        if (amount<=0) {
            System.out.println(
                    "Deposit rejected: amount must be positive.");
            return;
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        // TODO: reject if amount <= 0 OR amount > balance
        if (amount>balance || amount<=0) {
            System.out.println("Withdrawal rejected.");
            return false;
        }
        balance -= amount;
        return true;
    }

    // TODO: read-only accessor — return balance (double getBalance())
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if (balance<0){
            System.out.println("Balance cannot be negative");
            return;
        }
        this.balance= balance;
    }
    // Exercise 3 will override this method
    public String getAccountType() {
        return "Account";
    }
}