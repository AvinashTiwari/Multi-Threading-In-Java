package learn.avinash.thread;

import java.util.concurrent.*;

class MyMath {
    public static int add(int a, int b){
        return  a +b;
    }
}

class MyMathAdd implements Callable<Integer> {
    int x;
    int y;

    public MyMathAdd(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Integer call() throws Exception {
        return  MyMath.add(this.x, this.y);
    }
}


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int x = 10;
        int y = 20;

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> result = executorService.submit(new MyMathAdd(x, y));
        while(!result.isDone());

        int z =  result.get();

        System.out.println(z);
    }
}
