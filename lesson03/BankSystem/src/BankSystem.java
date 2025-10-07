import java.util.Scanner;
import java.util.ArrayList;

public class BankSystem {
    private String accountNumber;
    private String fio;
    private double balance;

    private static ArrayList<BankSystem> accounts = new ArrayList<>();

    public BankSystem(String accountNumber, String fio, double balance) {
        this.accountNumber = accountNumber;
        this.fio = fio;
        this.balance = balance;
    }

    // adding a bank account
    public static void addAccount(Scanner in) {
        System.out.print("Enter your account number: ");
        String accountNumber = in.nextLine();

        System.out.print("Enter your Surname and Name: ");
        String fio = in.nextLine();

        BankSystem account = new BankSystem(accountNumber, fio, 0);
        accounts.add(account);

        System.out.println("Your account added successfully!");
    }

    // deleting an account
    public static void deleteAccount(Scanner in) {
        System.out.print("Enter the account number you want to delete: ");
        String accountNumber = in.nextLine();

        BankSystem removingAccount = null;

        for (BankSystem account : accounts) {
            if (account.accountNumber.equalsIgnoreCase(accountNumber)) {
                removingAccount = account;
                break;
            }
        }

        if (removingAccount != null) {
            System.out.println("So you sure you want to delete your account " + accountNumber +
                    "? (1 means yes, 0 means no): ");
            int confirm = in.nextInt();
            in.nextLine();
            if (confirm == 1) {
                accounts.remove(removingAccount);
                System.out.println("Account deleted successfully.");
            } else {
                System.out.println("Alright boah");
            }
        } else {
            System.out.println("No account found for deletion");
        }
    }

    // finding a particular account
    public static BankSystem findAccount(String accountNumber) {
        for (BankSystem account : accounts) {
            if (account.accountNumber.equalsIgnoreCase(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // getting information about account
    public static void getAccountInfo(Scanner in) {
        System.out.print("Enter your account number: ");
        String accountNumber = in.nextLine();

        BankSystem account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("So, account " + account.accountNumber + " belongs to "
                    + account.fio + " and has " + account.balance + " rupees in it.");
        } else {
            System.out.println("No account found with that number.");
        }
    }

    // replenishing the account
    public void addMoney(Scanner in) {
        System.out.print("Enter sum you want to fill your account with: ");
        double amount = in.nextDouble();
        in.nextLine();

        if (amount > 0) {
            balance += amount;
            System.out.println("Your balance is filled with " + amount + " rupees.");
        } else {
            System.out.println("Enter a reasonable sum of money");
        }
    }

    public static void replenishAccount(Scanner in) {
        System.out.print("Enter your account number: ");
        String accountNumber = in.nextLine();

        BankSystem account = findAccount(accountNumber);
            if (account != null){
                account.addMoney(in);
            } else {
                System.out.println("Invalid account number");
            }
        }


    // transferring money between accounts
    public static void transferMoneyBetweenAccounts(Scanner in) {
        System.out.print("Enter your account number: ");
        String fromAccount = in.nextLine();

        System.out.print("Enter receiver's account number: ");
        String toAccount = in.nextLine();

        BankSystem sender = null;
        BankSystem receiver = null;

        for (BankSystem acc : accounts) {
            if (acc.accountNumber.equalsIgnoreCase(fromAccount)) {
                sender = acc;
            }
            if (acc.accountNumber.equalsIgnoreCase(toAccount)) {
                receiver = acc;
            }
        }

        // checking validity of accounts
        if (sender == null) {
            System.out.println("Sender's account not found");
            return;
        }
        if (receiver == null) {
            System.out.println("Receiver's account not found");
            return;
        }
        if (sender == receiver) {
            System.out.println("Wait, what!?");
            return;
        }

        // entering amount of money to transfer
        System.out.print("Enter amount of money you want to or were forced to transfer: ");
        double amount = in.nextDouble();
        in.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        if (amount > sender.balance) {
            System.out.println("You have not enough money to transfer");
            return;
        }

        sender.balance -= amount;
        receiver.balance += amount;

        System.out.println("Here we go, " + amount + " rupees have successfully transferred to " +
                receiver.fio + " from " + sender.fio);
    }
}
