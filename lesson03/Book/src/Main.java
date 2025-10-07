import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want?");
            System.out.println("1. Show all books");
            System.out.println("2. Add a new book");
            System.out.println("3.Book a book");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = in.nextInt();
            in.nextLine(); //очистка буфера

            if (choice == 1) {
                Book.getBooks();
            } else if (choice == 2) {
                Book.addNewBook(in);
            } else if (choice == 3) {
                System.out.println("Which book do you want to reserve?");
                String name = in.nextLine();
                Book book = Book.findBookByName(name);
                if (book != null){
                    book.reserveBook();
                } else {
                    System.out.println("There is no book which you want");
                }
            }
            else if (choice == 0) {
                System.out.println("Bye bye bye!");
                break;
            } else {
                System.out.println("What do you want from me?");
            }
        }

      in.close();
    }
}