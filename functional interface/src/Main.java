//задания 1-10

import java.util.List;
import java.util.UUID;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
//        Создай Predicate<String>, который проверяет, что строка не пуста и длиннее 3 символов
        Predicate<String> threeORmore = s -> s != null && !s.isEmpty() && s.length() > 3;

        System.out.println(threeORmore.test("hi"));
        System.out.println(threeORmore.test(""));
        System.out.println(threeORmore.test("germany"));
        System.out.println(threeORmore.test(null));

//        Создай Function<String, Integer>, возвращающую длину строки.
        Function<String, Integer> getLength = s -> s.length();

        System.out.println();
        System.out.println("Germany is the country in my mind rigth now");
        System.out.println(getLength.apply("Germany is the country in my mind rigth now"));

//        Создай Supplier<UUID>, который возвращает новый UUID при каждом вызове.
        Supplier<UUID> newUUID = () -> UUID.randomUUID();
        System.out.println("Тройка новых UUID");
        System.out.println(newUUID.get());
        System.out.println(newUUID.get());
        System.out.println(newUUID.get());

//        Создай Consumer<String>, который выводит строку в upper case.
        Consumer<String> toUpperTheString = s -> System.out.println(s.toUpperCase());

        System.out.println("Строка для ввода");
        System.out.println("Some random sentence");
        toUpperTheString.accept("Some random sentence");

//        Создай BiFunction<Integer, Integer, Integer>, которая возвращает сумму двух чисел.
        BiFunction<Integer, Integer, Integer> sumoftwo = (a, b) -> a + b;

        System.out.println(sumoftwo.apply(6, 9));

//        Function<String, String> trim и Function<String, String> toUpperCase. Объедини их в одну, которая сначала обрезает пробелы, потом делает верхний регистр
        Function<String, String> trim = s -> s.replaceAll(" ", "");
        Function<String, String> toUppperCase = s -> s.toUpperCase();

        Function<String, String> trimandUpper = trim.andThen(toUppperCase);

        System.out.println(trimandUpper.apply("let you cut me open"));

//        Один Consumer печатает строку в консоль, второй — печатает длину строки. Объедини их через andThen().
//        печатание строки
        Consumer<String> printString = s -> System.out.println("Строка " + s);

//        печанание её длины
        Consumer<String> printLength = s -> System.out.println("Длина " + s.length());

//        2 в 1
        Consumer<String> combination = printString.andThen(printLength);

        combination.accept("Osama bin Russel");

//        Создай Predicate<Integer> isEven и isPositive. Получи Predicate, который проверяет "нечётное или отрицательное".
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        Predicate<Integer> oddORnegative = isEven.negate().or(isPositive.negate());

        System.out.println(oddORnegative.test(15));
        System.out.println(oddORnegative.test(-69));
        System.out.println(oddORnegative.test(28));
        System.out.println(oddORnegative.test(0));

//        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b; Function<Integer, String> toStr = x -> "Result: " + x; Используй andThen(), чтобы объединить в одну цепочку.
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result " + x;

        BiFunction<Integer, Integer, String> result = multiply.andThen(toStr);

        System.out.println(result.apply(6, 9));

//        Создай UnaryOperator<String>, который добавляет "!!!" к строке.
        UnaryOperator<String> addiction = s -> s.concat("!!!");
        System.out.println(addiction.apply("This is a warning like it or not"));






    }
}