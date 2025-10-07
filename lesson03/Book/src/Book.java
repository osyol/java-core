import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String name;
    private String author;
    private String isbn;
    private int year;
    private String status;

    private static ArrayList<Book> books = new ArrayList<>();

    public Book(String name, String author, String isbn, int year, String status) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.status = status;
    }
//    получение информации о книге
    public void getBookInfo() {
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Year: " + year);
        System.out.println("Status: " + status + "\n\n");
    }
//    получение книги
    public static void getBooks() {
        if (books.isEmpty()) {
            System.out.println("There is no book left in da store");
        } else {
            System.out.println("The list of available books:");
            for (Book book : books){
                book.getBookInfo();
            }
        }
    }
//    добавление книги
    public static void addNewBook(Scanner in) {
        System.out.print("Enter your book's name: ");
        String name = in.nextLine();

        System.out.print("Enter its author's name: ");
        String author = in.nextLine();

        System.out.print("Enter its ISBN: ");
        String isbn = in.nextLine();

        System.out.print("Enter its release year: ");
        int year = in.nextInt();
        in.nextLine();

        String status = "in store";

        Book newBook = new Book(name, author, isbn, year, status);
        books.add(newBook);

    }
//    зарезервирование книги
    public void reserveBook() {
        if (status.equalsIgnoreCase("in store")) {
            status = "booked";
            System.out.println("Your " + name + " is " + status);
        } else {
            System.out.println(name + " is not available for booking, " +
                    "but you can book it at Aviasales.com");
        }
    }

    public static Book findBookByName(String name) {
        for (Book book : books) {
            if (book.name.equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }

}
