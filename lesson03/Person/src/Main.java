import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введи своё имя");
        String name = in.nextLine();

        System.out.println("Дай мне свой возраст");
        int age = in.nextInt();

        Person person = new Person(name, age);

        person.introduce();


        in.close();
    }
}