import java.util.List;
import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private List<BankAccount> allAccounts;
    private Scanner scanner;

    public ATM(BankAccount account, List<BankAccount> allAccounts) {
        this.account = account;
        this.allAccounts = allAccounts;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("******** WELCOME TO ATM ********");
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Show Transaction History");
        System.out.println("5. Transfer Funds");
        System.out.println("6. Exit");
    }

    public void start() {
        if (!checkPin()) {
            System.out.println("Too many failed attempts. Exiting...");
            return;
        }
        int choice;
        do {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    System.out.println("Exiting ATM. Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option!");
            }
        } while (choice != 6);
    }

    private boolean checkPin() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.next();
            if (account.verifyPin(enteredPin)) {
                return true;
            } else {
                System.out.println("Incorrect PIN. Please try again.");
                attempts++;
            }
        }
        return false;
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private void transfer() {
        System.out.print("Enter the target account number: ");
        String targetAccountNumber = scanner.next();
        BankAccount targetAccount = null;
        for (BankAccount acc : allAccounts) {
            if (acc.getAccountNumber().equals(targetAccountNumber)) {
                targetAccount = acc;
                break;
            }
        }
        if (targetAccount == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();
        account.transfer(targetAccount, amount);
    }
}
