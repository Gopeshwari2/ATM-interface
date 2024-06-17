import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private String pin;
    private String accountNumber;
    private List<String> transactionHistory;

    public BankAccount(double initialBalance, String pin, String accountNumber) {
        this.balance = initialBalance;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Money Deposited: " + amount);
        } else {
            System.out.println("Invalid amount for deposit!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Money Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal!");
        }
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            targetAccount.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to Account " + targetAccount.getAccountNumber());
            System.out.println("Transferred: " + amount + " to Account " + targetAccount.getAccountNumber());
        } else {
            System.out.println("Insufficient funds or invalid amount for transfer!");
        }
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
