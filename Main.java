import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount1 = new BankAccount(1000, "1234", "A001"); // Initial balance set to 1000, PIN set to 1234, Account number A001
        BankAccount userAccount2 = new BankAccount(2000, "5678", "A002"); // Another account with Account number A002
        List<BankAccount> allAccounts = new ArrayList<>();
        allAccounts.add(userAccount1);
        allAccounts.add(userAccount2);
        ATM atm = new ATM(userAccount1, allAccounts);
        atm.start();
    }
}
