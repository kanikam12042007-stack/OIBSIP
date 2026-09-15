import java.util.ArrayList;

public class ATM {
    private Account account;
    private ArrayList<Transaction> transactions;

    public ATM(Account account) {
        this.account = account;
        transactions = new ArrayList<>();
    }

    public boolean login(int pin) {
        return account.verifyPin(pin);
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs. " + account.getBalance());
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            transactions.add(new Transaction("Withdrawal", amount));
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        transactions.add(new Transaction("Deposit", amount));
        System.out.println("Deposit successful.");
    }

    public void transfer(double amount) {
        if (account.withdraw(amount)) {
            transactions.add(new Transaction("Transfer", amount));
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void showTransactions() {
        System.out.println("\nTransaction History:");

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction transaction : transactions) {
                transaction.display();
            }
        }
    }
}