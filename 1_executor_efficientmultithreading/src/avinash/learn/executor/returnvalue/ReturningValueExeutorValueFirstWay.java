package avinash.learn.executor.returnvalue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

import avinash.learn.executor.common.CalculationTaskA;
import avinash.learn.executor.common.LoopTaskA;
import avinash.learn.executor.common.NamedThreadFactory;
import avinash.learn.executor.common.ValueReturningTaskA;
import avinash.learn.executor.common.ValueReturningTaskB;

public class ReturningValueExeutorValueFirstWay {

	public static void main(String[] args) {
    String currentThreadName = Thread.currentThread().getName();
    System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
	ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
	Future<Integer> result1 =execService.submit(new CalculationTaskA(2,3, 2000));
	Future<Integer> result2 =execService.submit(new CalculationTaskA(2,4, 1000));
	Future<Integer> result3 =execService.submit(new CalculationTaskA(2,5, 500));

	
	Future<?> result4 =	execService.submit(new LoopTaskA());
	Future<Double> result5 = execService.submit(new LoopTaskA(), 99.98);
	
	execService.shutdown();
	
	try {
		System.out.println("Resukt 1" + result1.get());
		System.out.println("Resukt 2" + result2.get());
		System.out.println("Resukt 3" + result3.get());
		System.out.println("Resukt 4" + result4.get());
		System.out.println("Resukt 5" + result5.get());


	} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    System.out.println("[ " + currentThreadName + " ] Main Thread Ends Here");

	}

}
