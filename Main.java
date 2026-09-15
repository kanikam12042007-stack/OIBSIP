import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Account account = new Account("1234567890", 1234, 10000);
        ATM atm = new ATM(account);

        System.out.println("================================");
        System.out.println("          ATM INTERFACE");
        System.out.println("================================");

        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        if (!atm.login(pin)) {
            System.out.println("Invalid PIN. Access denied.");
            scanner.close();
            return;
        }

        System.out.println("Login successful!");

        int choice;

        do {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 4:
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    atm.transfer(transferAmount);
                    break;

                case 5:
                    atm.showTransactions();
                    break;

                case 6:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        scanner.close();
    }
}