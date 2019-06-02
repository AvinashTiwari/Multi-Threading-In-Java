package learn.avinash.thread;


class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("T");
        }
    }
}

class MyTask implements Runnable {

    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("-");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread th = new MyThread();
        th.start();

        MyTask t1 = new MyTask();
        Thread t = new Thread(t1);
        t.start();

        for (int i = 0; i <= 100; i++) {
            System.out.println("A");
        }
    }
}
