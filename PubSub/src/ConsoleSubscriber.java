import java.util.concurrent.BlockingQueue;

public class ConsoleSubscriber implements Subscriber, Runnable{
    private final BlockingQueue<String> queue;

    public ConsoleSubscriber(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void update(String message) {
        System.out.println("Message received: " + message);
    }

    @Override
    public void run() {
        try {
            while (true) {
//                in order to finish the programm when exit is typed
                String message = queue.take();
                if("exit".equalsIgnoreCase(message)) {
                    System.out.println("Bye bye");
                    break;
                }
                update(message);
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
