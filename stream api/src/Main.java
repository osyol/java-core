import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("\nКвадрат чётных цифр из 1-6");

//        to double the values
//        Stream<Integer> doubledValues = numbers.stream().map(n -> n*2);

//        doubledValues.forEach(n -> System.out.println(n));

//        to leave only odd ones and get their square values
        numbers.stream()
                .filter(n -> n%2 == 1)
                .sorted()
                .map(n -> n*n)
                .forEach(n -> System.out.println(n));

//        the number of words with length more than 5
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        System.out.println("\nКоличество слов длиною больше 5");


        System.out.println(words.stream()
                .filter(s -> s.length() > 5)
//                .sorted()
                .count());
//                .forEach(s -> System.out.println(s));

//        max and min
        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        System.out.println("\nЛист из 10, 2, 33, 4, 25");
        nums.stream()
                .min(Comparator.comparing(Integer::valueOf))
                .ifPresent(min -> System.out.println("Самое маленькое число:" + min));

        nums.stream()
                .max(Comparator.comparing(Integer::valueOf))
                .ifPresent(max -> System.out.println("Самый большой:" + max));

//        средняя длина строк
        List <String> names = List.of("Alice", "Bob", "Charlie", "David");
        System.out.print("\nСредняя длина из 'Alice', 'Bob', 'Charlie' и 'David': ");

        double averageLength = names.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);

        System.out.print(averageLength);

//        удаление дубликатов и отсортировка строки по длине
        List<String> fruits = List.of("apple", "pear", "apple", "banana", "kiwi");
        System.out.print("\nБыло \n" +
                "'apple', 'pear', 'apple', 'banana', 'kiwi' \n" +
                "Стало: ");

        List<String> noduplicate = fruits.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        System.out.print(noduplicate);

//        преобразование список в map
        System.out.println("\nПреобразование List в Map ");
        List<String> fruits2 = List.of("apple", "banana", "kiwi");

        Map<String, Integer> fruits2Mapped = fruits2.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit, String::length
                ));

        System.out.println( fruits2Mapped);

//        Map<String, Item> map = fruits2.stream().collect(Collectors.toMap(Item::getKey, item -> item));
//
//        map.forEach(k, v) ->System.out.println(k + " => " + v);

//        группировка имён по первой букве
        List<String> names2 = List.of("Alice", "Charlie", "Andrew", "Catherine", "Bob");
        System.out.println("Группировка \"Alice\", \"Charlie\", \"Andrew\", \"Catherine\", \"Bob\" по первой букве: ");

String names2sorted = names2.stream()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(names2sorted);

//        собрать список имён в одну строку через запятую
        List<String> names3 = List.of("Tom", "Jerry", "Spike");

        String oneLine = names3.stream()
                .collect(Collectors.joining(", "));

        System.out.println(oneLine);

//        Из списка предложений получить список всех слов.
        List<String> names4 = List.of("Java is cool", "Streams are powerful");

        List<String> names4Words = names4.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());
        System.out.println(names4Words);

//        Найди самый дорогой продукт в каждой категории.
        record Product(String name, String category, double price){}
        List<Product> products = List.of(
                new Product("Phone", "Electronics", 1200),
                new Product("TV", "Electronics", 1800),
                new Product("Apple", "Fruits", 2.5),
                new Product("Mango", "Fruits", 4.0));

        Map<String, Product> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Product::price)),
                                Optional::get
                        )
                ));

        mostExpensiveByCategory.forEach((category, product) ->
        System.out.println("Категория: " + category +
                ", самый дорогой: " + product.name() +
                " " + product.price()));

    }
}