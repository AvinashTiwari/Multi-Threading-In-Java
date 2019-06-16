package lean.avinash.deadlock;

class Writer3 extends  Thread {
    Object book;
    Object pen;

    public Writer3(Object book, Object pen) {
        this.book = book;
        this.pen = pen;
    }


    @Override
    public  void run(){
        synchronized (book){
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (pen){
                System.out.println("Write 1 writing");
            }
        }

    }
}

class Writer4 extends  Thread {
    Object book;
    Object pen;

    public Writer4(Object book, Object pen) {
        this.book = book;
        this.pen = pen;
    }


    @Override
    public  void run(){
        synchronized (pen){
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (book){
                System.out.println("Write 2 writing");
            }
        }

    }
}

public class MainDeadLock {
    public static void main(String[] args) {
            Object book = new Object();
            Object pen = new Object();

            new Writer3(book, pen).start();
            new Writer4(book , pen).start();

        System.out.println("Main is exec");
    }
}
