
public class EncaptulationDemo {
    public static void main(String[] args) {
        Account account1 = new Account(192873, 100.00);
        savingsAccount account2 = new savingsAccount(20219836, 99.36);
        account2.setBalance(1002);
        account1.setBalance(-10);
        account2.showInfo();
    }
}