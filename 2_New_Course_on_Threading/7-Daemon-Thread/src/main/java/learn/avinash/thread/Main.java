package learn.avinash.thread;

class myTask implements Runnable{

    public void run() {
        for(;;){
            System.out.println("T");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thr = new Thread(new myTask());
        thr.setDaemon(true);
        thr.start();

        for (int i=1; i<=200; i++){
            System.out.println("A");
        }
    }
}
