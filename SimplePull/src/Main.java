public class Main {
    public static void main(String[] args) {
//        creating 10 polles
        ThreadPool pool = new ThreadPool(10);

//        adding 30 tasks
        for (int i = 1; i <= 30; i++) {
            int taskID = i;
            pool.execute(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " is working on task " + taskID);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        pool.shutdonw();

    }
}