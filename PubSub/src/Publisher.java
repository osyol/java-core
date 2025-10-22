import java.util.concurrent.BlockingQueue;

public class Publisher {
    private final BlockingQueue<String> queue;

    public Publisher(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void publish(String message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}