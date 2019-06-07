package learn.avinash.thread;

class MyThread extends Thread {
    public void run() {
        for (; ; ) {
            if (interrupted()) {
                System.out.println("Thread was interrupted");
                break;
            }

            System.out.println("T");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread mt = new MyThread();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mt.interrupt();


    }
}
