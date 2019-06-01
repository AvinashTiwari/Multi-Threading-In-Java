package learn.avinash.thread;

public class SingleThread {
    public static void main(String[] args) {

        Task t1 = new Task();
        t1.start();

        for(int i=1; i <=1500 ; i++){
            System.out.print("A");
        }
    }


}

class Task extends  Thread{

    @Override
    public void run() {
        dotask();
    }

    public void dotask(){
        for(int i=1; i <=1500 ; i++){
            System.out.print("A");
        }
    }
}