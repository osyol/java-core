public class Rectangle {
    private int length;
    private int width;

//    констуктор
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void calculateSquare() {
        System.out.println("Площадь прямоугольнка равна " +
                (length * width));
    }

    public void calculatePerimeter() {
        System.out.println("Периметр прямоугольника равен " +
                ((length + width) * 2));
    }

}
