import java.util.*;

class UserBankAccount {
    private double bal;

    public UserBankAccount(double iniBalance) {
        this.bal = iniBalance;
    }

    public double getBalance() {
        return bal;
    }

    public void deposit(double amount) {
        bal += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= bal) {
            bal -= amount;
            return true;
        }
        return false;
    }
}

class ATMInterface {
    private UserBankAccount userBankAccount;

    public ATMInterface(UserBankAccount account) {
        this.userBankAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nATM INTERFACE MENU:");
        System.out.println("1. CHECK BALANCE");
        System.out.println("2. DEPOSIT");
        System.out.println("3. WITHDRAW");
        System.out.println("4. EXIT");
    }

    public void performTransaction(int choice, double amount) {
        switch (choice) {
            case 1:
                System.out.println("Balance: Rs " + userBankAccount.getBalance());
                break;
            case 2:
                userBankAccount.deposit(amount);
                System.out.println("Deposited Rs " + amount);
                System.out.println("Remaining Balance: Rs " + userBankAccount.getBalance());
                break;
            case 3:
                if (userBankAccount.withdraw(amount)) {
                    System.out.println("Withdrawn Rs " + amount);
                    System.out.println("Remaining Balance: Rs " + userBankAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds or invalid amount");
                }
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double iniBalance = scanner.nextDouble();

        UserBankAccount userBankAccount = new UserBankAccount(iniBalance);
        ATMInterface atm = new ATMInterface(userBankAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice from (1-4): ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting. Thank you!");
                System.exit(0);
            } else {
                if (choice == 1) {
                    // For CHECK BALANCE, amount is not applicable, set it to 0
                    atm.performTransaction(choice, 0);
                } else {
                    System.out.print("Enter the amount: Rs ");
                    double amount = scanner.nextDouble();
                    atm.performTransaction(choice, amount);
                }
            }
        }
    }
}
