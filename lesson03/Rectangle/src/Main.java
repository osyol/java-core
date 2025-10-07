import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введи длину прямоугольника ");
        int lenth = in.nextInt();

        System.out.println("Введи ширину прямоугольника ");
        int width = in.nextInt();

//        создание объекта Rectangle с вводными данными
        Rectangle rectangle = new Rectangle(lenth, width);

//        вызов метода calculateSquare()
        rectangle.calculateSquare();
//        вызов метода calculatePerimeter()
        rectangle.calculatePerimeter();
        in.close();
    }
}