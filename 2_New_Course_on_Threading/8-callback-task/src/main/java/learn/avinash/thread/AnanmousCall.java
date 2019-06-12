package learn.avinash.thread;

import java.util.concurrent.*;

class newMyMath {
    public static int add(int a, int b){
        return  a +b;
    }
}




class AnamousCall {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final int x = 10;
        final int y = 20;

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> result = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return newMyMath.add(x,y);
            }
        });
        while(!result.isDone());

        int z =  result.get();

        System.out.println(z);
    }
}
