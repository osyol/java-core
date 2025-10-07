import java.util.Scanner;
import java.util.ArrayList;

public class OnlineStore {
    private String name;
    private String code;
    private double price;
    private int count;

    private static ArrayList<OnlineStore> products =new ArrayList<>();

    public OnlineStore(String name, String code, double price, int count) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.count = count;
    }

//    adding a new product
    public static void addProduct(Scanner in) {
        System.out.print("Add what you want: ");
        String name = in.nextLine();

        System.out.print("Enter its code: ");
        String code = in.nextLine();

        System.out.print("Set price for it: ");
        double price = in.nextDouble();
        in.nextLine();

        System.out.print("How many of " + name + " do you want to add? ");
        int count = in.nextInt();
        in.nextLine();

        OnlineStore newProduct = new OnlineStore(name, code, price, count);
        products.add(newProduct);

        System.out.println("Bluetooth device connected successfully");
    }

//    buying a product
    public static void buyProduct(Scanner in) {
        System.out.print("Enter your product's name: ");
        String name = in.nextLine();

        boolean found = false;

        for (OnlineStore product : products) {
            if (product.name.equalsIgnoreCase(name)) {
                found = true;


                System.out.println("There are " + product.count + " " + product.name + "s available in the store");
                System.out.println("How many do you want to buy?");

                int amount = in.nextInt();
                in.nextLine();

                if (amount <= 0) {
                    System.out.println("Invalid input");
                } else if (amount > product.count) {
                    System.out.println("Well, that's way too many to buy");
                } else {
                    product.count -= amount;
                    System.out.println("You bought " + amount + " " + product.name + "s");
                    System.out.println("Remaining: " + product.count);
                }
                break;
            } else{
                System.out.println("There is no " + product.name + " in the stock");
            }
        }
        if (!found) {
            System.out.println("We don't sell such a sh--");
        }
    }

//    get information about products
    public static void getProductInfo() {
        if (products.isEmpty()){
            System.out.println("There is nothing left in this hole");
        } else {
            System.out.println("The list of available products:");
            for (OnlineStore product : products ) {
                System.out.println("Name: " + product.name);
                System.out.println("Price: " + product.price);
                System.out.println("Count: " + product.count);
            }
        }
    }


}
