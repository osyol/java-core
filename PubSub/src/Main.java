import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Publisher publisher = new Publisher(queue);
        ConsoleSubscriber subscriber = new ConsoleSubscriber(queue);

        Thread subscriberThread = new Thread(subscriber);
        subscriberThread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'exit' to finish the process");

        while (true) {
            String input = scanner.nextLine();
            publisher.publish(input);
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
        }

        try {
            subscriberThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Bye bye bye");


    }
}

interface Subscriber {
    void update(String message);
}