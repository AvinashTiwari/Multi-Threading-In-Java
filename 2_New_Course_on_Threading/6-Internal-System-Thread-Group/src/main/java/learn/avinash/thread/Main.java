package learn.avinash.thread;

class myTask implements Runnable{

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {


        }
    }
}

public class Main {

    public static void main(String[] args) {
        ThreadGroup myGroup = new ThreadGroup("MyThreadGroup");
        myGroup.setMaxPriority(7);


        Thread myThread = new Thread(myGroup,new myTask(), "Demo THread");
        myThread.start();

        System.out.println("System Threads......");
        Thread thr = Thread.currentThread();
        ThreadGroup grp = thr.getThreadGroup();
        while(grp.getParent() !=null){
            grp = grp.getParent();
        }

        grp.list();
    }
}
