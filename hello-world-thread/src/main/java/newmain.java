public class newmain {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello World");
        Thread thread = new Thread(new Runnable() {
            public void run() {
            throw new RuntimeException("errpr occured");
            }
        });

        thread.setName(" error thread ");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error in thread " + t.getName() + "this error "+ e.getMessage());
            }
        });
       thread.start();

    }
}
