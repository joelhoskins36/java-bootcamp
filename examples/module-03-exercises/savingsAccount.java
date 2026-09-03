

public class savingsAccount extends Account{
    public savingsAccount(int accountNum, double balance) {
        super(accountNum,balance);
    }

    public void showInfo() {
        System.out.println(balance+"  "+ interestRate+"  ");
    }

}