package avinash.learn.executor.aliveCheck;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import avinash.learn.executor.common.CalculationTaskA;
import avinash.learn.executor.common.DaemonThreadFactory;
import avinash.learn.executor.common.LoopTaskC;
import avinash.learn.executor.common.LoopTaskD;
import avinash.learn.executor.common.NamedThreadFactory;

public class ExecutorThreadAliveCheck {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");

		ExecutorService exeService = Executors.newCachedThreadPool(new NamedThreadFactory());
		Future<?> f1 = exeService.submit(new LoopTaskC());
		Future<Integer> f2 = exeService.submit(new CalculationTaskA(3,4,700));

		for (int i = 1; i <=5 ; i++){
			TimeUnit.MICROSECONDS.sleep(600);
			
			System.out.println("[ " + currentThreadName +" ] " + i  + " is done " + f1.isDone());
			System.out.println("[ " + currentThreadName +" ] " + i  + " is done " + f2.isDone());

		}
		
		System.out.println("[ " + currentThreadName +" ]  Reterving Result" );
		System.out.println("[ " + currentThreadName +" ]  Reterving Result"  + f1.get());
		System.out.println("[ " + currentThreadName +" ]  Reterving Result"  + f2.get());

		
		exeService.shutdown();
		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
