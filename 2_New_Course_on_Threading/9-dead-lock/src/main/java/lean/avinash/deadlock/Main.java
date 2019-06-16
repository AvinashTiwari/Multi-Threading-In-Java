package lean.avinash.deadlock;

class Writer1 extends  Thread {
    Object book;
    Object pen;

    public Writer1(Object book, Object pen) {
        this.book = book;
        this.pen = pen;
    }


    @Override
    public  void run(){
        synchronized (book){
            synchronized (pen){
                System.out.println("Write 1 writing");
            }
        }

    }
}

class Writer2 extends  Thread {
    Object book;
    Object pen;

    public Writer2(Object book, Object pen) {
        this.book = book;
        this.pen = pen;
    }


    @Override
    public  void run(){
        synchronized (pen){
            synchronized (book){
                System.out.println("Write 2 writing");
            }
        }

    }
}

public class Main {
    public static void main(String[] args) {
            Object book = new Object();
            Object pen = new Object();

            new Writer1(book, pen).start();
            new Writer2(book , pen).start();

        System.out.println("Main is exec");
    }
}
