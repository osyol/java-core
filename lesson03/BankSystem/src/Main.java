import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true; // для выхода из программы

        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1 - Add account");
            System.out.println("2 - Delete account");
            System.out.println("3 - Fill your account");
            System.out.println("4 - Get account info");
            System.out.println("5 - Transfer money");
            System.out.println("6 - Exit");
            System.out.print("Your choice: ");

            int choice = in.nextInt();
            in.nextLine(); // очищаем буфер

            if (choice == 1) {
                BankSystem.addAccount(in);
            }
            else if (choice == 2) {
                BankSystem.deleteAccount(in);
            } else if (choice == 3) {
                BankSystem.replenishAccount(in);
            }
            else if (choice == 4) {
                BankSystem.getAccountInfo(in);
            }
            else if (choice == 5) {
                BankSystem.transferMoneyBetweenAccounts(in);
            }
            else if (choice == 6) {
                System.out.println("Goodbye!");
                running = false;
            }
            else {
                System.out.println("Invalid choice, try again.");
            }
        }

        in.close();
    }
}
