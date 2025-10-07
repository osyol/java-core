import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want? \n" +
                    "1. See a list of products available \n" +
                    "2. Buy a particular product \n" +
                    "3. Add a new product \n" +
                    "4. Exit \n" +
                    "Your choice: ");

            int choice = in.nextInt();
            in.nextLine();

            if (choice == 1) {
                OnlineStore.getProductInfo();
            } else if (choice == 2) {
                OnlineStore.buyProduct(in);
            } else if (choice == 3) {
                OnlineStore.addProduct(in);
            } else if (choice == 4) {
                System.out.println("Bye bye bye!");
                break;
            } else {
                System.out.println("Invalid input");
            }
        }

        in.close();
    }
}