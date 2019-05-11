public class main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello World");
        Thread thread = new Thread(new Runnable() {
            public void run() {
            System.out.println("We are now in the thread " + Thread.currentThread().getName());
            System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("New Worker thread");
        System.out.println("We are running thread " + Thread.currentThread().getName() + " this before we started thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        System.out.println("We are running thread " + Thread.currentThread().getName() + " this after we started thread");

        Thread.sleep(300);

    }
}
