public class exer4 {
    public static void main(String[] var0) {
        FrozenAccount faccount = new FrozenAccount(50.00);
        System.out.println(faccount.getAccountType() + " balance: " + faccount.getBalance());
        AbstractAccount account = new AbstractSavings(50.00);
    }
}


abstract class AbstractAccount {
    protected double balance;

    public AbstractAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    // TODO: abstract method — no body; every concrete subclass must implement
    public abstract String getAccountType();
}
class AbstractSavings extends AbstractAccount {
    public AbstractSavings(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public String getAccountType() {
        // TODO: return "Savings"
        return "Savings";
    }
}
class FrozenAccount extends AbstractAccount {
    public FrozenAccount(double initialBalance) {
        // Reuse Account construction and balance encapsulation.
        super(initialBalance);
    }

    public void withdraw(double amount) {
        System.out.println("Not allowed to withdraw");
    }

    @Override
    public String getAccountType() {

        return "Frozen";
    }
}