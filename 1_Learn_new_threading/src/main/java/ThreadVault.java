import com.sun.corba.se.impl.io.ValueUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadVault {
    public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random random = new Random();
        Valut valut = new Valut(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<Thread>();
        threads.add(new AscendingHackerThread(valut));
        threads.add(new DscendingHackerThread(valut));
        threads.add(new PoliceThread());

        for(Thread thread: threads){
            thread.start();
        }

    }

    private static class Valut extends Thread{
        private int password;
        public Valut(int password){
            this.password = password;

        }

        public  boolean inCorrectPassword(int guess) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  this.password == guess;
        }
    }

    private static  abstract class HackerThread extends Thread {
        protected Valut valut;
        public  HackerThread(Valut valut){
            this.valut = valut;
            this.setName(this.getClass().getName());
            this.setPriority(Thread.MAX_PRIORITY);
        }
        @Override
        public void start(){
            System.out.println("Starting Thread " + this.getName());
            super.start();
        }

    }

    public static  class AscendingHackerThread extends  HackerThread {
        public  AscendingHackerThread(Valut valut){
            super(valut);
        }

        @Override
        public  void run(){
            for (int guess =0 ; guess < MAX_PASSWORD ; guess++){
                if(valut.inCorrectPassword(guess)){
                    System.out.println(this.getName() + " guessed password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    public static  class DscendingHackerThread extends  HackerThread {
        public  DscendingHackerThread(Valut valut){
            super(valut);
        }

        @Override
        public  void run(){
            for (int guess =MAX_PASSWORD ; guess > 0 ; guess--){
                if(valut.inCorrectPassword(guess)){
                    System.out.println(this.getName() + " guessed password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    public static class PoliceThread extends Thread {
        @Override
        public void run(){
            for(int i=10; i >0 ; i--){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }

            System.out.println("Game over hackers");

            System.exit(0);
        }
    }

}
